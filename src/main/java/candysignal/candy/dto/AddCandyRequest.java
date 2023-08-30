package candysignal.candy.dto;

import candysignal.candy.entity.Contact;
import candysignal.candy.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class AddCandyRequest {

    private String nickname;
    private int age;
    private String university;
    private String phone;
    private String mbti;
    private String hobby;
    private String text;




}
