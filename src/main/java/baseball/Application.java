package baseball;

import baseball.message.Message;
import baseball.model.BaseBallResult;
import baseball.rule.BaseBall;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        BaseBall baseBall = BaseBall.getInstacne();
        boolean isFinished = false;
        while (!isFinished) {
            BaseBallResult baseBallResult = baseBall.getResult(Message.getNumber());
            Message.showResult(baseBallResult);
            isFinished = Message.checkGameOver(baseBallResult);
            if(isFinished)
                isFinished = !baseBall.isInit(Message.getEndNumber());
        }
    }
}
