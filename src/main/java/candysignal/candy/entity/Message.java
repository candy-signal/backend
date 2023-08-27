package candysignal.candy.entity;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id @GeneratedValue
    @Column(name = "message_id")
    private Long id;

    private String mbti;
    private String hobby;
    private String text;



    @OneToOne(mappedBy = "message")
    private Candy candy;

}
