package com.interview;

/**
 * @author GF
 * @since 2023/8/2
 */
public class Water {


    public int water(int n) {
        int water = 0;
        while (true) {
            int[] record = calculate(n);
            water += record[0];
            if (record[1] == 2) {
                water += 1;
                break;
            } else if (record[1] < 2) {
                break;
            }
            n = record[1];
        }
        return water;
    }

    private int[] calculate(int n) {
        int water = n / 3;
        int count = water + n % 3;
        return new int[] {water, count};
    }

    public static void main(String[] args) {
        Water algorithm = new Water();
        int water = algorithm.water(81);
        System.out.println(water);
    }

}
