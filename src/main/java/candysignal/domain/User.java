package candysignal.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Table(name="users")
@NoArgsConstructor(access= AccessLevel.PROTECTED)
@Getter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id",nullable = false, unique = true)
    private Long id;

    @Column(name = "email")
    private String email;
    @Column(name = "nickname",unique=true)
    private String nickname;


    @Builder
    public User(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }

    public User update(String nickname){
        this.nickname = nickname;
        return this;
    }




}
