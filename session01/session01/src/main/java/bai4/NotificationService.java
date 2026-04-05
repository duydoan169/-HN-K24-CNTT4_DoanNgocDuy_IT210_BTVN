package bai4;

import org.springframework.stereotype.Service;

/*
Constructor Injection
Dependency được tiêm thông qua Constructor
 */
@Service
public class NotificationService {
    private EmailSender emailSender;
    private SmsSender smsSender;

    //Constructor Injection nằm ở đây Spring sẽ tự động inject EmailSender và SmsSender
    public NotificationService(EmailSender emailSender, SmsSender smsSender){
        this.emailSender = emailSender;
        this.smsSender = smsSender;
    }

    public void notifyUser(String message){
        emailSender.send(message);

        try{
            smsSender.send(message);
        }catch(Exception e){
            System.out.println("SMS lỗi, chỉ gửi Email");
        }
    }
}