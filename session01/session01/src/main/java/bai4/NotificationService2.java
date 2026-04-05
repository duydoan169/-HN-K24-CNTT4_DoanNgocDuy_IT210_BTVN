package bai4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
Field Injection
Dependency được tiêm trực tiếp vào biến

 */
@Service
public class NotificationService2 {
    //Field Injection nằm ở đây Spring inject trực tiếp vào biến
    @Autowired
    private EmailSender emailSender;

    @Autowired
    private SmsSender smsSender;

    public void notifyUser(String message){
        emailSender.send(message);

        try{
            smsSender.send(message);
        }catch(Exception e){
            System.out.println("SMS lỗi, chỉ gửi Email");
        }
    }
}