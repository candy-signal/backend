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

    private String age;

    private String university;

    private String phone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "message_id")
    private Message message;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_id")
    private Contact contact;

}
