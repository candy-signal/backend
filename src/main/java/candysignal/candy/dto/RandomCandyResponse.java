package candysignal.candy.dto;

import candysignal.candy.entity.Candy;
import lombok.Getter;


@Getter
public class RandomCandyResponse {
    private Long candyId;
    private String nickname;
    private int age;
    private String university;
    private String phone;

    private AddMessageResponse message;

    private AddContactResponse contact;


    public RandomCandyResponse(Candy candy) {
        this.candyId = candy.getId();
        this.nickname = candy.getNickname();
        this.age = candy.getAge();
        this.university = candy.getUniversity();
        this.phone = candy.getPhone();
        this.message = new AddMessageResponse(candy);
        this.contact = new AddContactResponse(candy);
    }



}
