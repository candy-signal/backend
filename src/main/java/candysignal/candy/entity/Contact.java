package candysignal.candy.entity;

import jakarta.persistence.*;


@Entity
public class Contact {
    @Id @GeneratedValue
    @Column(name = "contact_id")
    private Long id;

    @OneToOne(mappedBy = "contact")
    private Candy candy;

}