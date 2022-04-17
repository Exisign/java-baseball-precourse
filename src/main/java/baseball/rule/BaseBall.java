package baseball.rule;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;

import java.util.Iterator;
import java.util.LinkedHashSet;

public class BaseBall {
    private LinkedHashSet<Integer> correctSet;

    private BaseBall(){}

    public BaseBall getInstacne(){
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
}