package chap06;

import java.util.Arrays;
import java.util.Scanner;

public class ArraySortTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.printf("요솟수 : ");
        int num = stdIn.nextInt();
        int[] x = new int[num];

        for(int i = 0; i < num; i++){
            System.out.printf("x[" + i + "] : ");
            x[i] = stdIn.nextInt();
        }

        Arrays.sort(x);

        System.out.printf("오름차순으로 정렬했습니다.");
        for(int i = 0; i < num; i++)
            System.out.println("x[" + i +"] = " + x[i]);
    }
}
