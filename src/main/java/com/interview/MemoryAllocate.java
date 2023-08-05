package com.interview;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * @author GF
 * @since 2023/8/4
 */
public class MemoryAllocate {

    //起始地址，内存大小
    private final TreeMap<Integer, Integer> MEMORY_USED = new TreeMap<>();
    private final TreeMap<Integer, Integer> MEMORY_FREE = new TreeMap<>();

    private final int capacity;

    private int used;

    public MemoryAllocate(int capacity) {
        this.capacity = capacity;
        this.used = 0;
        MEMORY_FREE.put(0, 100);
    }


    /**
     * 分配内存
     */
    public String request(int requestSize) {
        if (used + requestSize > capacity || requestSize == 0) {
            return "error";
        }

        int address = -1;
        Set<Map.Entry<Integer, Integer>> entries = MEMORY_FREE.entrySet();
        for (Map.Entry<Integer, Integer> entry : entries) {
            if (entry.getValue() >= requestSize) {
                address = entry.getKey();
                MEMORY_USED.put(entry.getKey(), requestSize);
                if (entry.getValue() > requestSize) {
                    MEMORY_FREE.put(entry.getKey() + requestSize, entry.getValue() - requestSize);
                }
                MEMORY_FREE.remove(entry.getKey());
                break;
            }
        }
        return address == -1 ? "error" : (address + "");
    }


    /**
     * 释放内存
     */
    public String release(int address) {
       if (MEMORY_USED.containsKey(address)) {
           int release = MEMORY_USED.get(address);
           MEMORY_FREE.put(address, release);
           MEMORY_USED.remove(address);
           used -= release;
           return "";
       }
       return "error";
    }


    public static void main(String[] args) {
        MemoryAllocate algorithm = new MemoryAllocate(100);
        System.out.println(algorithm.request(10));
        System.out.println(algorithm.request(20));
        System.out.println(algorithm.release(0));
        System.out.println(algorithm.request(20));
        System.out.println(algorithm.request(10));

    }

}
