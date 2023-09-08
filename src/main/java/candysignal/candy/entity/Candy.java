package candysignal.candy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.LAZY;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class  Candy extends BaseDateEntity {

    @Id
    @GeneratedValue
    @Column(name = "candy_id")
    private Long id;

    private String nickname;

    private int age;

    private String university;

    private String phone;


    @JsonIgnoreProperties({"candy"}) // Exclude the candy field from serialization
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private Message message;

    @JsonIgnoreProperties({"candy"}) // Exclude the candy field from serialization
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_id")
    private Contact contact;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private Users user;

    @Builder
    public Candy(String nickname, int age, String university, String phone, Message message, Contact contact, Users user) {
        this.nickname = nickname;
        this.age = age;
        this.university = university;
        this.phone = phone;
        this.message = message;
        this.contact = contact;
        this.user = user;
    }

}
