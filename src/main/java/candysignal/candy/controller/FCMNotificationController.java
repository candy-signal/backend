package candysignal.candy.controller;

import candysignal.candy.dto.FCMNotificationRequestDto;
import candysignal.candy.entity.Users;
import candysignal.candy.service.FCMNotificationService;
import candysignal.candy.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/notification")
public class FCMNotificationController {

    private final FCMNotificationService fcmNotificationService;
    private final UserService userService;

    @PostMapping()
    public String sendNotificationByToken(@RequestBody FCMNotificationRequestDto requestDto){
        return fcmNotificationService.sendNotificationByToken(requestDto);
    }


    @PutMapping("/deviceToken")
    public ResponseEntity<Users> updateArticle(@RequestParam("userId") long userId, @RequestBody UpdateDeviceTokenRequest request){

        Users updatedUser = userService.updateDeviceToken(userId,request);

        return ResponseEntity.ok()
                .body(updatedUser);

    }


}
