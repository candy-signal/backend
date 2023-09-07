package candysignal.candy.controller;

import candysignal.candy.dto.UserInfoResponse;
import candysignal.candy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/v1/user")
    public ResponseEntity<UserInfoResponse> getUser(@RequestParam("userId") Long userId){
        UserInfoResponse userInfo = userService.getUser(userId);

        System.out.println("userInfoResponse!!! : " +userInfo);
        System.out.println("userInfoResponse!!! : " + ResponseEntity.status(HttpStatus.CREATED)
                .body(userInfo));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userInfo);
    }







}
