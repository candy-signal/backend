package candysignal.candy.entity;

import candysignal.candy.dto.AddContactResponse;
import candysignal.candy.dto.AddMessageResponse;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class CandyHistory extends BaseDateEntity{

    @Id
    @GeneratedValue
    @Column(name = "candy_history_id")
    private Long id;

    private Long candyId;
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
    public CandyHistory(Candy candy) {
        this.candyId = candy.getId();
        this.nickname = candy.getNickname();
        this.age = candy.getAge();
        this.university = candy.getUniversity();
        this.phone = candy.getPhone();
        this.message = candy.getMessage();
        this.contact = candy.getContact();
        this.user = candy.getUser();
    }
}
