package candysignal.candy.controller;

import candysignal.candy.dto.AddCandyRequest;
import candysignal.candy.dto.AddCandyResponse;
import candysignal.candy.dto.CandyHistoryResponse;
import candysignal.candy.dto.RandomCandyResponse;
import candysignal.candy.service.CandyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class CandyApiController {

    private final CandyService candyService;
    @PostMapping("/api/v1/candy")
    public ResponseEntity<AddCandyResponse> addCandy(@RequestParam("userId") Long userId, @RequestBody AddCandyRequest request){

        AddCandyResponse savedCandy = candyService.saveCandy(request,userId);
        System.out.println("savedCandy : " + savedCandy);

        System.out.println("ResponseEntity : " + ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCandy));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCandy);
    }

    @GetMapping("/api/v1/candy/random")
    public ResponseEntity<RandomCandyResponse> randomCandy(){

        RandomCandyResponse randomCandy =  candyService.randomCandy();

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(randomCandy);
    }


    @GetMapping("/api/v1/candy/mycandy")
    public ResponseEntity<List<CandyHistoryResponse>> candyHistory(@RequestParam("userId") Long userId){

        List<CandyHistoryResponse> candyHistorys = candyService.candyHistory(userId);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(candyHistorys);

    }









}
