package candysignal.candy.entity;

import candysignal.candy.enums.Approve;
import jakarta.persistence.*;


@Entity
public class Contact {
    @Id @GeneratedValue
    @Column(name = "contact_id")
    private Long id;

    private String phone;

    @Enumerated(EnumType.STRING)
    private Approve approve;

    @OneToOne(mappedBy = "contact")
    private Candy candy;

}
