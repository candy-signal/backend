package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import candysignal.candy.entity.CandyHistory;
import lombok.Getter;

@Getter
public class AddMessageResponse {

    private String mbti;
    private String hobby;
    private String text;

    public AddMessageResponse(Candy candy) {
        this.mbti = candy.getMessage().getMbti();
        this.hobby = candy.getMessage().getHobby();
        this.text = candy.getMessage().getText();
    }

    public AddMessageResponse(CandyHistory candyHistory) {
        this.mbti = candyHistory.getMessage().getMbti();
        this.hobby = candyHistory.getMessage().getHobby();
        this.text = candyHistory.getMessage().getText();
    }
}
