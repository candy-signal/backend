package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import candysignal.candy.entity.Contact;
import candysignal.candy.entity.Message;
import candysignal.candy.enums.Approve;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class AddCandyResponse {

    private Long candyId;
    private String nickname;
    private int age;
    private String university;
    private String phone;

    private AddMessageResponse message;

    private AddContactResponse contact;


    public AddCandyResponse(Candy candy) {
        this.candyId = candy.getId();
        this.nickname = candy.getNickname();
        this.age = candy.getAge();
        this.university = candy.getUniversity();
        this.phone = candy.getPhone();
        this.message = new AddMessageResponse(candy);
        this.contact = new AddContactResponse(candy);
    }
}
