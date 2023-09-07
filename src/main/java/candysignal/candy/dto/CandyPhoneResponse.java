package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import lombok.Getter;

@Getter
public class CandyPhoneResponse {
    private String phone;

    public CandyPhoneResponse(Candy candy) {
        this.phone = candy.getPhone();
    }
}
