package candysignal.candy.dto;

import candysignal.candy.entity.Contact;
import candysignal.candy.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCandyRequest {

    private String nickname;
    private int age;
    private String university;
    private Message message;
    private String phone;
    private Contact contact;

}
