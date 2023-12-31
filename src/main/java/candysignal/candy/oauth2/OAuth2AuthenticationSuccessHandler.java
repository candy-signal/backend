package candysignal.candy.oauth2;

import candysignal.candy.dto.UserResponseDto;
import candysignal.candy.jwt.JwtTokenProvider;
import candysignal.candy.lib.CookieUtils;
import candysignal.candy.repository.CookieAuthorizationRequestRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;


import java.io.IOException;
import java.net.URI;
import java.util.Optional;

import static candysignal.candy.repository.CookieAuthorizationRequestRepository.REDIRECT_URI_PARAM_COOKIE_NAME;

@Slf4j
@Component
@RequiredArgsConstructor
public class OAuth2AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Value("${oauth.authorizedRedirectUri}")
    private String redirectUri;
    private final JwtTokenProvider jwtTokenProvider;
    private final CookieAuthorizationRequestRepository cookieAuthorizationRequestRepository;


    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String targetUrl = determineTargetUrl(request, response, authentication);
        System.out.println(request);
        System.out.println(response);


        System.out.println("success targetURL : "+targetUrl);

        if (response.isCommitted()) {
            log.debug("Response has already been committed.");
            return;
        }
        clearAuthenticationAttributes( request,  response);

        try{
            getRedirectStrategy().sendRedirect(request, response, "candysignal:"+targetUrl);
            System.out.println("redirect success ");
        }catch(Exception e){
            System.out.println("redirect failed : "+e);
        }


    }


    protected String determineTargetUrl(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) {
        Optional<String> redirectUri = CookieUtils.getCookie(request, REDIRECT_URI_PARAM_COOKIE_NAME)
                .map(Cookie::getValue);

        System.out.println("redirectUri : " + redirectUri);

        if (redirectUri.isPresent() && !isAuthorizedRedirectUri(redirectUri.get())) {
            throw new RuntimeException("redirect URIs are not matched.");
        }
        String targetUrl = redirectUri.orElse(getDefaultTargetUrl());

        //JWT 생성
        UserResponseDto.TokenInfo tokenInfo = jwtTokenProvider.generateToken(authentication);

        return UriComponentsBuilder.fromUriString(targetUrl)
                .queryParam("token", tokenInfo.getAccessToken())
                .build().toUriString();
    }

    protected void clearAuthenticationAttributes(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response) {
        super.clearAuthenticationAttributes((jakarta.servlet.http.HttpServletRequest) request);
        cookieAuthorizationRequestRepository.removeAuthorizationRequestCookies(request, response);
    }

    private boolean isAuthorizedRedirectUri(String uri) {
        URI clientRedirectUri = URI.create(uri);
        URI authorizedUri = URI.create(redirectUri);

        if (authorizedUri.getHost().equalsIgnoreCase(clientRedirectUri.getHost())
                && authorizedUri.getPort() == clientRedirectUri.getPort()) {
            return true;
        }
        return false;
    }
}
