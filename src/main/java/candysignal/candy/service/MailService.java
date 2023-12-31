package candysignal.candy.service;


import candysignal.candy.dto.SendMailRequest;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender javaMailSender;
    private static final String senderEmail = "ggprgrkjh2@gmail.com";
    private static int number;


    public static void createNumber(){
        number = (int)(Math.random()*(90000)) + 100000;
    }

    public MimeMessage createMail(String mail){
        createNumber();
        MimeMessage message = javaMailSender.createMimeMessage();

        try{

            message.setFrom(senderEmail);
            message.setRecipients(MimeMessage.RecipientType.TO,mail);
            message.setSubject("CandySignal 이메일 인증");
            String body = "";
            body += "<h3>" + "요청하신 인증 번호입니다." + "</h3>";
            body += "<h1>" + number + "</h1>";
            body += "<h3>" + "감사합니다." + "</h3>";
            message.setText(body,"UTF-8","html");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return message;
    }

    public int sendMail(SendMailRequest sendMailRequest){

        MimeMessage message = createMail(sendMailRequest.getMail());

        try{
            javaMailSender.send(message);
        }catch(Exception e){
            System.out.println("error log : "+e);
        }
        return number;
    }


}
