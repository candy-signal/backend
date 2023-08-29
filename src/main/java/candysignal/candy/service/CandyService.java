package candysignal.candy.service;


import candysignal.candy.dto.AddCandyRequest;
import candysignal.candy.entity.Candy;
import candysignal.candy.repository.CandyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CandyService {


    private final CandyRepository candyRepository;

    public Candy saveCandy(AddCandyRequest request){
        return candyRepository.save(Candy.builder()
                .nickname(request.getNickname())
                .age(request.getAge())
                .university(request.getUniversity())
                .message(request.getMessage())
                .contact(request.getContact())
                .phone(request.getPhone())
                .build()
        );
    }





}
