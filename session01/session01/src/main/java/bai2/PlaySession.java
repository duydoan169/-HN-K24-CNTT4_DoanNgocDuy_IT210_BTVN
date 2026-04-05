package bai2;

/*
@Component
public class PlaySession {
    private double playTime = 0;
}

Trong Spring, khi sử dụng @Component, Bean mặc định có scope Singleton.
Điều này có nghĩa là chỉ có một instance duy nhất của PlaySession được
tạo ra và dùng chung cho tất cả người dùng.

Vì tất cả máy trạm đều sử dụng chung một đối tượng PlaySession, nên khi
máy số 01 cộng thời gian chơi, máy số 02 cũng bị ảnh hưởng vì đang dùng
chung biến playTime. Điều này dẫn đến hiện tượng tính nhầm tiền giờ giữa các máy.

Nguyên nhân
Bean mặc định của Spring là Singleton
Tất cả user dùng chung một instance
playTime bị chia sẻ giữa nhiều phiên chơi
*/


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class PlaySession {

    private double playTime = 0;

    public void addTime(double time) {
        this.playTime += time;
    }

    public double getPlayTime() {
        return playTime;
    }
}
//Do Spring mặc định Bean là Singleton nên tất cả máy trạm dùng chung một instance PlaySession,
// dẫn đến việc thời gian chơi bị chia sẻ và tính tiền sai. Để khắc phục, cần sử dụng @Scope("prototype")
// để tạo một instance riêng cho mỗi phiên chơi.
