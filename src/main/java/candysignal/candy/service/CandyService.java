package candysignal.candy.service;


import candysignal.candy.dto.AddCandyRequest;
import candysignal.candy.dto.AddCandyResponse;
import candysignal.candy.entity.Candy;
import candysignal.candy.entity.Contact;
import candysignal.candy.entity.Message;
import candysignal.candy.entity.Users;
import candysignal.candy.enums.Approve;
import candysignal.candy.repository.CandyRepository;
import candysignal.candy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CandyService {


    private final CandyRepository candyRepository;
    private final UserRepository userRepository;


    @Transactional
    public AddCandyResponse saveCandy(AddCandyRequest request,Long userId){

        System.out.println(request.getNickname());
        System.out.println(request.getPhone());
        System.out.println(request.getAge());
        System.out.println(request.getUniversity());
        System.out.println(request.getMbti());
        System.out.println(request.getText());
        System.out.println(request.getHobby());

        Message message = new Message();
        Contact contact = new Contact();
        Candy candy = new Candy();

        message.setMbti(request.getMbti());
        message.setHobby(request.getHobby());
        message.setText(request.getText());
        contact.setApprove(Approve.NONE);

        Users user = userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);

        candy.setContact(contact);
        candy.setMessage(message);
        candy.setUser(user);

        candy.setAge(request.getAge());
        candy.setNickname(request.getNickname());
        candy.setPhone(request.getPhone());
        candy.setUniversity(request.getUniversity());

        System.out.println("user find : " + user);
        System.out.println("user find : " + user.getId());
        System.out.println("user find : " + user.getEmail());
        System.out.println("user find : " + user.getNickname());
        System.out.println("user find : " + user.getPhone());

        candyRepository.save(candy);

        return new AddCandyResponse(candy);

    }

}
