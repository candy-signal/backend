package candysignal.candy.entity;


import candysignal.candy.enums.AuthProvider;
import candysignal.candy.enums.Role;
import candysignal.candy.oauth2.OAuth2UserInfo;
import jakarta.persistence.*;
import lombok.*;



@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Users extends BaseDateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String name;

    private String oauth2Id;

    @Enumerated(EnumType.STRING)
    private AuthProvider authProvider;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Users update(OAuth2UserInfo oAuth2UserInfo) {
        this.name = oAuth2UserInfo.getName();
        this.oauth2Id = oAuth2UserInfo.getOAuth2Id();

        return this;
    }
}
