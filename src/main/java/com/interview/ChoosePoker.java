package com.interview;

import java.util.HashSet;
import java.util.Set;

/**
 * @author GF
 * @since 2023/8/5
 */
public class ChoosePoker {

    private int times = 0;

    public int choosePoker(String[][] pokers) {
        //最多出牌的数量
        for (String[] poker : pokers) {
            Set<String> usedPokers = new HashSet<>();
            usedPokers.add(poker[0] + poker[1]);
            backtrack(pokers, usedPokers, poker, 1);
        }
        return times;
    }

    private void backtrack(String[][] pokers, Set<String> usedPokers, String[] poker, int count) {
        boolean hasNextPoker = false;
        for (int i = 0; i < pokers.length; i++) {
            boolean used = usedPokers.contains(pokers[i][0] + pokers[i][1]);
            if (!used && (pokers[i][0].equals(poker[0]) || pokers[i][1].equals(poker[1]))) {
                hasNextPoker = true;
                usedPokers.add(pokers[i][0] + pokers[i][1]);
                backtrack(pokers, usedPokers, pokers[i], count + 1);
            }
        }
        //没有找到下一张可以匹配的卡片
        if (!hasNextPoker) {
            times = Math.max(times, count);
        }
    }


    public static void main(String[] args) {
        String[][] poker = {
                {"1", "b"},
                {"2", "r"},
                {"3", "g"},
                {"4", "y"},
                {"4", "r"}
        };
        ChoosePoker algorithm = new ChoosePoker();
        int times = algorithm.choosePoker(poker);
        System.out.println(times);
    }

}
