package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import candysignal.candy.entity.CandyHistory;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class CandyHistoryResponse {

    private Long candyId;
    private String nickname;
    private int age;
    private String university;
    private String phone;

    private AddMessageResponse message;

    private AddContactResponse contact;

    public CandyHistoryResponse(CandyHistory candyHistory) {
        this.candyId = candyHistory.getCandyId();
        this.nickname = candyHistory.getNickname();
        this.age = candyHistory.getAge();
        this.university = candyHistory.getUniversity();
        this.phone = candyHistory.getPhone();
        this.message = new AddMessageResponse(candyHistory);
        this.contact = new AddContactResponse(candyHistory);
    }


}
