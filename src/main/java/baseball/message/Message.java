package baseball.message;

import baseball.model.BaseBallResult;
import camp.nextstep.edu.missionutils.Console;

public class Message {
    private static String gameMent     =   "숫자를 입력해주세요 : ";
    private static String strikeMent   =   "스트라이크 ";
    private static String ballMent     =   "볼 ";
    private static String notMent      =   "낫싱";
    private static String complMent    =   "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static String endMent      =   "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static String getNumber(){
        System.out.print(gameMent);
        return Console.readLine();
    }

    public static void showResult(BaseBallResult baseBallResult){
        System.out.println(getMessage(baseBallResult));
    }

    public static boolean checkGameOver(BaseBallResult baseBallResult){
        boolean isGameOver = false;
        int strikeCnt =  baseBallResult.getStrikeCnt();
        if ( strikeCnt == 3) {
            isGameOver = true;
        }
        return isGameOver;
    }

    private static String getMessage(BaseBallResult baseBallResult){
        StringBuilder sb = new StringBuilder();
        int ballCnt = baseBallResult.getBallCnt();
        int strikeCnt = baseBallResult.getStrikeCnt();

        sb.append(getNotThingMent(ballCnt, strikeCnt));
        sb.append(getBallMent(ballCnt));
        sb.append(getStrikMent(strikeCnt));
        sb.append(getEndMent(strikeCnt));

        return sb.toString();
    }

    private static String getNotThingMent(int ballCnt, int strikeCnt){
        if(ballCnt==0&&strikeCnt==0){
            return notMent;
        }
        return "";
    }

    private static String getBallMent(int ballCnt){
        if(ballCnt>0){
            return "" + ballCnt + ballMent;
        }
        return "";
    }

    private static String getStrikMent(int strikeCnt){
        if(strikeCnt>0){
            return "" + strikeCnt + strikeMent;
        }
        return "";
    }

    private static String getEndMent(int strikeCnt){
        if(strikeCnt==3){
            return "\n" + complMent + "\n" + endMent;
        }
        return "";
    }

    public static String getEndNumber(){
        return Console.readLine();
    }
}
