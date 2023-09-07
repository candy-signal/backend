package candysignal.candy.dto;

import lombok.Getter;

@Getter
public class SendMailResponse {
    private String number;

    public SendMailResponse(String number) {
        this.number = number;
    }
}
