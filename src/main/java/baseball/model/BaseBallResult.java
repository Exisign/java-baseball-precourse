package baseball.model;

public class BaseBallResult {
    private int strikeCnt = 0;
    private int ballCnt = 0;

    public void addStrikeCnt() {
        strikeCnt++;
    }
    public int getStrikeCnt(){
        return strikeCnt;
    }

    public void addBallCnt(){
        ballCnt++;
    }
    public int getBallCnt(){
        return ballCnt;
    }
}
