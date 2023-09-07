package candysignal.candy.controller;


import candysignal.candy.service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MailController {

    private final MailService mailService;

    @ResponseBody
    @PostMapping("/api/v1/mail")
    public String MailSend(String mail){
        int number = mailService.sendMail(mail);

        String num = "" + number;

        return num;

    }



}