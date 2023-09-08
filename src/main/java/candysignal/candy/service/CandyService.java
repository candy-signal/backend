package candysignal.candy.service;


import candysignal.candy.dto.*;
import candysignal.candy.entity.*;
import candysignal.candy.enums.Approve;
import candysignal.candy.repository.CandyHistoryRepository;
import candysignal.candy.repository.CandyRepository;
import candysignal.candy.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
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

        Set<Long> candyHistoryIds = candyHistoryRepository.findAll()
                .stream()
                .map(CandyHistory::getCandyId)
                .collect(Collectors.toSet());

        List<Long> availableCandyIds = allCandyIds.stream()
                .filter(id->!candyHistoryIds.contains(id))
                .collect(Collectors.toList());

        if(availableCandyIds.isEmpty()){
            return null;
        }

        Long randomCandyId = availableCandyIds.get(new Random().nextInt(availableCandyIds.size()));

        Candy randomCandy = candyRepository.findById(randomCandyId).orElseThrow(IllegalArgumentException::new);

        CandyHistory candyHistory = new CandyHistory(randomCandy);

        candyHistoryRepository.save(candyHistory);

        return new RandomCandyResponse(randomCandy);
    }

    @Transactional
    public List<CandyHistoryResponse> candyHistory(Long userId){

        List<CandyHistoryResponse> candyHistorys = candyHistoryRepository.findAllByUserId(userId)
                .stream()
                .map(this::mapToResponseDTO)
                .collect(Collectors.toList());

        System.out.println("candyHistorys : "+candyHistorys.toString());

        return candyHistorys;
    }


    @Transactional
    public CandyPhoneResponse candyPhone(Long candyId){

        Candy candy = candyRepository.findById(candyId).orElseThrow(IllegalArgumentException::new);

        CandyPhoneResponse candyPhone = new CandyPhoneResponse(candy);

        return candyPhone;

    }



    @Transactional
    public String requestPhone(Long candyId){

        Candy candy = candyRepository.findById(candyId).orElseThrow(IllegalArgumentException::new);
        candy.getContact().requestContact();
        return "request Success";

    }











    private CandyHistoryResponse mapToResponseDTO(CandyHistory candyHistory) {
        CandyHistoryResponse candyHistoryResponse = new CandyHistoryResponse(candyHistory);
        return candyHistoryResponse;
    }


}
