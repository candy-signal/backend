package candysignal.candy.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class  Candy  {

    @Id
    @GeneratedValue
    @Column(name = "candy_id")
    private Long id;

    private String nickname;

    private int age;

    private String university;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private Message message;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_id")
    private Contact contact;


    @Builder
    public Candy(Long id, String nickname, int age, String university, String phone, Message message, Contact contact) {
        this.id = id;
        this.nickname = nickname;
        this.age = age;
        this.university = university;
        this.phone = phone;
        this.message = message;
        this.contact = contact;
    }




}
