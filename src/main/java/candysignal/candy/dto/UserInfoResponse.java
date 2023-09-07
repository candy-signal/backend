package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import candysignal.candy.entity.Users;
import candysignal.candy.enums.AuthProvider;
import candysignal.candy.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class UserInfoResponse {

    private Long id;
    private Long coin;

    private String email;
    private String name;
    private String oauth2Id;

    private String firebaseToken;

    private AuthProvider authProvider;

    private Role role;

    private String university;
    private String phone;
    private String certification;
    private String age;
    private String nickname;

    private List<Candy> candys = new ArrayList<>();

    public UserInfoResponse(Users user) {
        this.id = user.getId();
        this.coin = user.getCoin();
        this.email = user.getEmail();
        this.name = user.getName();
        this.oauth2Id = user.getOauth2Id();
        this.authProvider = user.getAuthProvider();
        this.role = user.getRole();
        this.university = user.getUniversity();
        this.phone = user.getPhone();
        this.certification = user.getCertification();
        this.age = user.getAge();
        this.nickname = user.getNickname();
        this.candys = user.getCandys();
    }
}
