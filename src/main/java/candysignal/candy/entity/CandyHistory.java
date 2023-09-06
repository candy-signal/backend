package candysignal.candy.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
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

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name="user_id")
    private Users user;

    public CandyHistory(Candy candy) {
        this.candyId = candy.getId();
        this.user = candy.getUser();
    }
}
