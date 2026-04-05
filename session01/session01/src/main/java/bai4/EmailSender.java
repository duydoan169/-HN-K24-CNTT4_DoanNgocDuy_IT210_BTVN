package bai4;

import org.springframework.stereotype.Component;

//Chức năng: Gửi thông báo qua Email
@Component
public class EmailSender {

    public void send(String message){
        System.out.println("Send Email: " + message);
    }
}