package chap01;

import java.util.Scanner;

public class Q10 {
    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);
        int n;

        do {
            System.out.printf("양의 정수 : ");
            n = stdIn.nextInt();
        } while(n <= 0);

        int i = 1;
        while(n > 0){
            n = n/10;
            if(n >= 1)
                i++;
            else
                break;
        }

        System.out.println("자리수 = " + i);
    }
}
