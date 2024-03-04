package org.example;

import lombok.Builder;
import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author gf01867832
 * @since 2024/1/8
 */
public class Main {

    public static void main(String[] args) {
        CalculateEntity calculateEntity = new CalculateEntity.CalculateEntityBuilder()
                .buyRecord(new LinkedHashMap<>())
                .money(1000)
                .price(1)
                .changePrice(0.04)
                .lever(2)
                .count(25)
                .build();
        calculateEntity.calculateLong();

        CalculateEntity calculateEntity2 = new CalculateEntity.CalculateEntityBuilder()
                .buyRecord(new LinkedHashMap<>())
                .money(400)
                .price(70000)
                .changePrice(700)
                .lever(10)
                .count(10)
                .build();
        calculateEntity2.calculateShort();
    }

    @Data
    @Builder
    public static class CalculateEntity {
        private double money;
        private double price;
        private double changePrice;
        private double avgPrice;
        private double quantity;
        private double lever;
        private Map<Double, Double> buyRecord;
        private int count;

        public void calculateLong() {
            double profit = money;
            System.out.printf("初始金额: %.2f, 建仓价格: %.6f, 持仓数量: %.2f, 杠杆: %.0f, 操作方式: 每次涨幅达到%.0f%%后(相对于初始建仓时的价格)，将本次涨幅的盈利以相同的杠杆继续买入加仓 %n", money, price, money * lever / price, lever, changePrice / price * 100);
            for (int i = 1; i <= count; i++) {
                buyRecord.put(price, profit * lever / price);
                quantity = calculateQuantity(buyRecord);
                price = price + changePrice;
                profit = quantity * price - money * lever;
                money = money + profit;
                avgPrice = calculateAvg(buyRecord);
                System.out.printf("第%d次涨幅后，金额: %.2f，币价: %.6f, 持仓数量: %.2f, 持仓均价: %.6f, 杠杆: %.0f, 本次获利: %.2f %n", i, money, price, quantity, avgPrice, lever, profit);
            }
//            printBuyRecord(buyRecord);
        }

        public void calculateShort() {
            double profit = money;
            System.out.printf("初始金额: %.2f, 建仓价格: %.6f, 持仓数量: %.2f, 杠杆: %.0f, 操作方式: 每次跌幅达到%.0f%%后(相对于初始建仓时的价格)，将本次跌幅的盈利以相同的杠杆继续卖出加仓 %n", money, price, money * lever / price, lever, changePrice / price * 100);
            for (int i = 1; i <= count; i++) {
                buyRecord.put(price, profit * lever / price);
                quantity = calculateQuantity(buyRecord);
                price = price - changePrice;
                profit = money * lever - quantity * price;
                money = money + profit;
                avgPrice = calculateAvg(buyRecord);
                System.out.printf("第%d次跌幅后，金额: %.2f，币价: %.6f, 持仓数量: %.2f, 持仓均价: %.6f, 杠杆: %.0f, 本次获利: %.2f %n", i, money, price, quantity, avgPrice, lever, profit);
            }
//            printBuyRecord(buyRecord);
        }

        private double calculateAvg(Map<Double, Double> buyRecord) {
            double totalMoney = 0;
            double totalQuantity = 0;
            for (Double price : buyRecord.keySet()) {
                Double eachQuantity = buyRecord.get(price);
                totalMoney += price * eachQuantity;
                totalQuantity += eachQuantity;
            }
            return totalMoney / totalQuantity;
        }

        private double calculateQuantity(Map<Double, Double> buyRecord) {
            return buyRecord.values().stream().reduce(Double::sum).orElse((double) 0);
        }

        private void printBuyRecord(Map<Double, Double> buyRecord) {
            System.out.println("\n购买明细 ===>\n");
            buyRecord.forEach((price, quantity) -> {
                System.out.printf("购买价格%.6f, 购买数量: %f %n", price, quantity);
            });
            System.out.println();
        }
    }

}
