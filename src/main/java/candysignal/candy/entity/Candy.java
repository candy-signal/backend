package candysignal.candy.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Candy {

    @Id
    @GeneratedValue
    @Column(name = "candy_id")
    private Long id;

    private String nickanme;

    private String age;

    private String university;

    private String phone;

    @OneToOne
    @JoinColumn(name = "message_id")
    private Message message;

    @OneToOne
    @JoinColumn(name="contact_id")
    private Contact contact;






}
