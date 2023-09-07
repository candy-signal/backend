package candysignal.candy.controller;


import candysignal.candy.dto.SendMailRequest;
import candysignal.candy.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @PostMapping("/api/v1/mail")
    public ResponseEntity<String> MailSend(@RequestBody SendMailRequest sendMailRequest){
        int number = mailService.sendMail(sendMailRequest);

        System.out.println("mail success : " +number);

        String num = "" + number;

        return  ResponseEntity.status(HttpStatus.CREATED)
                .body(num);

    }



}
