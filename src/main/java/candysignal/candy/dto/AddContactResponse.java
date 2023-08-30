package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
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
}
