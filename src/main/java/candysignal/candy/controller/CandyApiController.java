package candysignal.candy.controller;

import candysignal.candy.dto.AddCandyRequest;
import candysignal.candy.dto.AddCandyResponse;
import candysignal.candy.service.CandyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class CandyApiController {

    private final CandyService candyService;
    @PostMapping("/api/v1/candys")
    public ResponseEntity<AddCandyResponse> addCandy(@RequestParam("userId") Long userId, @RequestBody AddCandyRequest request){

        AddCandyResponse savedCandy = candyService.saveCandy(request,userId);
        System.out.println("savedCandy : " + savedCandy);

        System.out.println("ResponseEntity : " + ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCandy));


        return ResponseEntity.status(HttpStatus.CREATED)
                .body(savedCandy);
    }





}
