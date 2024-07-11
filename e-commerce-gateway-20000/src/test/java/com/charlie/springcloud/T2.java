package com.charlie.springcloud;

import java.time.ZonedDateTime;

public class T2 {
    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        // 2024-07-09T22:16:08.248+08:00[Asia/Shanghai]
        System.out.println(now);
    }
}
