package candysignal.candy.entity;

import jakarta.persistence.*;

@Entity
public class Message {

    @Id @GeneratedValue
    @Column(name = "message_id")
    private Long id;

    @OneToOne(mappedBy = "message")
    private Candy candy;

}
