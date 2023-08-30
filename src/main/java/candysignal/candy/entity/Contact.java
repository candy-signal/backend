package candysignal.candy.entity;

import candysignal.candy.enums.Approve;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import net.minidev.json.annotate.JsonIgnore;


@Entity
@Getter
@Setter
public class Contact {
    @Id @GeneratedValue
    @Column(name = "contact_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Approve approve;

    @OneToOne(mappedBy = "contact")
    private Candy candy;

}
