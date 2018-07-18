package com.github.ericmoshare.adc.utils;

import java.util.concurrent.atomic.AtomicLong;

/**
 * 序列号的工具类
 */
public class GeneratorUtil {
    // 序列号尾数最小值
    private final static long SuffixMin = 1;

    // 序列号尾数最大值
    private final static long SuffixMax = 9999999;
    private static AtomicLong Suffix = new AtomicLong(SuffixMin);

    /**
     * 创建位移序号(以毫秒可支持)
     */
    public static long createSeq() {
        long tPrefix = System.currentTimeMillis();
        long tSuffix = getIncreaseSuffix();
        return (tPrefix * 1000000) + tSuffix;
    }

    /**
     * 获取递增、循环的序号尾数，控制在SuffixMin~SuffixMax范围内
     */
    private static long getIncreaseSuffix() {
        while (true) {
            try {
                long tem = Suffix.get();

                if (tem >= SuffixMax) {
                    boolean result = Suffix.compareAndSet(SuffixMax, SuffixMin);
                    if (result) {
                        return SuffixMin;
                    }
                } else {
                    boolean result = Suffix.compareAndSet(tem, tem + 1);
                    if (result) {
                        return tem + 1;
                    }
                }
            } finally {
            }
        }
    }

}
