package candysignal.candy.entity;


import candysignal.candy.enums.AuthProvider;
import candysignal.candy.enums.Role;
import candysignal.candy.oauth2.OAuth2UserInfo;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;


@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Users extends BaseDateEntity {

    @Id @GeneratedValue
    @Column(name = "user_id")
    private Long id;
    private Long coin;

    private String email;
    private String name;
    private String oauth2Id;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @Enumerated(EnumType.STRING)
    private Role role;


    private String university;
    private String phone;
    private String certification;
    private String age;
    private String nickname;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Candy> candys = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<CandyHistory> candyHistorys = new ArrayList<>();


    public Users update(OAuth2UserInfo oAuth2UserInfo) {
        this.name = oAuth2UserInfo.getName();
        this.oauth2Id = oAuth2UserInfo.getOAuth2Id();
        return this;
    }

}
