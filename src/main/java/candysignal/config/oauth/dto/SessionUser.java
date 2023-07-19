package candysignal.config.oauth.dto;

import candysignal.domain.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String nickname;
    private String email;

    public SessionUser(User user) {
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }
}