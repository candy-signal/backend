package candysignal.candy.service;


import candysignal.candy.dto.AddCandyRequest;
import candysignal.candy.dto.AddCandyResponse;
import candysignal.candy.dto.RandomCandyResponse;
import candysignal.candy.entity.Candy;
import candysignal.candy.entity.Contact;
import candysignal.candy.entity.Message;
import candysignal.candy.entity.Users;
import candysignal.candy.enums.Approve;
import candysignal.candy.repository.CandyHistoryRepository;
import candysignal.candy.repository.CandyRepository;
import candysignal.candy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class CandyService {


    private final CandyRepository candyRepository;

    private final CandyHistoryRepository candyHistoryRepository;

    private final UserRepository userRepository;


    @Transactional
    public AddCandyResponse saveCandy(AddCandyRequest request,Long userId){

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

        candyRepository.save(candy);

        return new AddCandyResponse(candy);

    }

    @Transactional
    public RandomCandyResponse randomCandy(){

        List<Long> allCandyIds = candyRepository.findAll()
                .stream()
                .map(Candy::getId)
                .collect(Collectors.toList());

        Set<Long> candyHistoryIds =




        return new RandomCandyResponse(candy);
    }

}
