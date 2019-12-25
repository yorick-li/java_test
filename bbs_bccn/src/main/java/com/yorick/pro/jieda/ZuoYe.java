package com.yorick.pro.jieda;

import java.util.Scanner;

public class ZuoYe {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int number;
        int a = 0;
        int b = 0;
        number = in.nextInt();
        while (number != -1) {
            if (number % 2 == 0) {
                a += 1;
            }else {
                b += 1;
            }
            number = in.nextInt();
        }

        System.out.println("奇数有：" + a);
        System.out.println("偶数有：" + b);

    }

}
