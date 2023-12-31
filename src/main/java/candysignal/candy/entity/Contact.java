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


    public void requestContact(){
        this.approve = Approve.PROCEEDING;
    }
    public void approvalContact(){
        this.approve = Approve.DONE;
    }
    public void refuseContact(){
        this.approve = Approve.FAIL;
    }




}
