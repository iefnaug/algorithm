package com.interview;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author GF
 * @since 2023/8/4
 */
public class DivideData {


    public static String divideData(List<String> iList, List<String> rList) {
        LinkedHashMap<String, LinkedHashMap<Integer, String>> resultMap = new LinkedHashMap<>();
        rList = rList.stream().distinct().map(Integer::parseInt).sorted().map(a -> a + "").collect(Collectors.toList());
        for (int i = 0; i < rList.size(); i++) {
            LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
            String r = rList.get(i);
            for (int j = 0; j < iList.size(); j++) {
                if (iList.get(j).contains(r)) {
                    map.put(j, iList.get(j));
                }
            }
            if (map.size() > 0) {
                resultMap.put(r, map);
            }
        }
        //输出结果
        int count = 0;
        StringBuilder output = new StringBuilder();
        Set<Map.Entry<String, LinkedHashMap<Integer, String>>> resultEntrySet = resultMap.entrySet();
        count += resultEntrySet.size(); //r个数
        for (Map.Entry<String, LinkedHashMap<Integer, String>> entry : resultEntrySet) {
            output.append(entry.getKey()).append(" "); //r
            LinkedHashMap<Integer, String> indexToValMap = entry.getValue();
            output.append(indexToValMap.size()).append(" ");//符合r的i个数
            indexToValMap.forEach((key, val) -> output.append(key).append(" ").append(val).append(" "));
            count += indexToValMap.size() * 2 + 1;
        }
        return count + " " + output;
    }


    public static void main(String[] args) {
        List<String> iList = Stream.of(123, 456, 786, 453, 46, 7, 5, 3, 665, 453456, 745, 456, 786, 453, 123).map(a -> a + "").collect(Collectors.toList());
        List<String> rList = Stream.of(6, 3, 6, 3, 0).map(a -> a + "").collect(Collectors.toList());
        String s = divideData(iList, rList);
        System.out.println(s);
    }

}
