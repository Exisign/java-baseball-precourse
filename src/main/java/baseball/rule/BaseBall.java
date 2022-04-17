package baseball.rule;

import baseball.model.BaseBallResult;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.*;

public class BaseBall {
    private LinkedHashSet<Integer> correctSet;

    public static BaseBall getInstacne(){
        BaseBall baseBall = new BaseBall();
        baseBall.initGoalNum();
        return baseBall;
    }
    /**
     * 정답 Set 초기화 부분
     */
    private void initGoalNum() {
        correctSet = new LinkedHashSet<>();

        while (true) {
            correctSet.add(Randoms.pickNumberInRange(1, 9));
            if (correctSet.size() == 3) {
                break;
            }
        }
    }

    public BaseBallResult getResult(String strNum) throws IllegalArgumentException{
        return getResult(getNumList(checkLength(getArrChar(strNum))));
    }

    private char[] getArrChar(String str) throws IllegalArgumentException{
        if(str!=null){
            return str.toCharArray();
        }
        throw new IllegalArgumentException("parameter is null.");
    }

    private char[] checkLength(char[] strNum) throws IllegalArgumentException{
        if(strNum.length==3){
            return strNum;
        }
        throw new IllegalArgumentException("parameter length is not 3.");
    }

    private List<Integer> getNumList(char[] strNum) throws IllegalArgumentException{
        List<Integer> numList = new ArrayList<>();
        for(int i = 0; i < strNum.length; i++) {
            numList.add(checkNum(strNum[i]));
        }
        return numList;
    }

    private Integer checkNum(char num) throws IllegalArgumentException{
        char[] arrDiff = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        for(int i = 0; i < arrDiff.length; i++){
            if(arrDiff[i]==num){
                return Character.getNumericValue(arrDiff[i]);
            }
        }
        throw new IllegalArgumentException("parameter is not Number.");
    }

    private BaseBallResult getResult(List<Integer> numList) {
        BaseBallResult baseBallResult = new BaseBallResult();
        for (int i = 0; i < numList.size(); i++){
            calcBaseBallResult(numList.get(i), i, baseBallResult);
        }
        return baseBallResult;
    }

    private void calcBaseBallResult(int value, int index, BaseBallResult baseBallResult){
        int diffIndex = 0;
        for(int  diff : correctSet){
            if(diff==value){
                addStrikeOrBallCount(diffIndex, index, baseBallResult);
                return;
            }
            diffIndex++;
        }
    }

    private void addStrikeOrBallCount(int diffIndex, int index, BaseBallResult baseBallResult){
        if(diffIndex==index){
            baseBallResult.addStrikeCnt();
            return;
        }
        baseBallResult.addBallCnt();
    }

    public boolean isInit(String numStr) throws IllegalArgumentException{
        if(numStr.equals("1")) {
            initGoalNum();
            return true;
        }
        if(numStr.equals("2"))
            return false;
        throw new IllegalArgumentException("지정되지 않은 값 사용 : " + numStr);
    }
}