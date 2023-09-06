package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import candysignal.candy.entity.CandyHistory;
import candysignal.candy.enums.Approve;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;

@Getter
public class AddContactResponse {

    private Approve approve;

    public AddContactResponse(Candy candy) {
        this.approve = candy.getContact().getApprove();
    }

    public AddContactResponse(CandyHistory candyHistory) {
        this.approve = candyHistory.getContact().getApprove();
    }

}
