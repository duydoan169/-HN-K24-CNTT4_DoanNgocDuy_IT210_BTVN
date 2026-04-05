package bai4;

import org.springframework.stereotype.Component;

//Chức năng: Gửi thông báo qua SMS
@Component
public class SmsSender {

    public void send(String message){
        System.out.println("Send SMS: " + message);
    }
}