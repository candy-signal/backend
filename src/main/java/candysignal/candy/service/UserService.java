package candysignal.candy.service;

import candysignal.candy.dto.AddCandyRequest;
import candysignal.candy.dto.AddCandyResponse;
import candysignal.candy.dto.UpdateDeviceTokenRequest;
import candysignal.candy.dto.UserInfoResponse;
import candysignal.candy.entity.Candy;
import candysignal.candy.entity.Contact;
import candysignal.candy.entity.Message;
import candysignal.candy.entity.Users;
import candysignal.candy.enums.Approve;
import candysignal.candy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public UserInfoResponse getUser(Long userId){
        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        return new UserInfoResponse(user);
    }


    @Transactional
    public UserInfoResponse updateDeviceToken(Long userId, UpdateDeviceTokenRequest request){
        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
        user.updateDeviceToken(request);

        return new UserInfoResponse(user);
    }


}
