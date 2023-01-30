package chap06;

import java.util.Scanner;

public class MergeSort {
    static int[] buff; //작업용 배열 생성

    static void __mergeSort(int[] a, int left, int right){
        if(left < right){
            int i;
            int center = (left + right) / 2;
            int p = 0; //buff 커서
            int j = 0; //
            int k = left;

            __mergeSort(a, left, center); //왼쪽 배열 정렬
            __mergeSort(a, center + 1, right); //오른쪽 배열 정렬

            for(i = left; i <= center; i++) //왼쪽부터 중앙까지 버퍼에 넣음
                buff[p++] = a[i];

            while (i <= right && j < p) //왼쪽 배열과 오른쪽 배열을 비교해서 삽입 i = center + 1 j = 0
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

            while (j < p) // 왼쪽 배열의 남은거 삽입
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a, int n){
        buff = new int[n]; // 작업용 배열 생성

        __mergeSort(a, 0, n - 1); // 배열 전체 병합 정렬

        buff = null; //작업용 배열 해제
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.println("병합 정렬");
        System.out.printf("요솟수 :");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for (int i = 0; i < nx; i++) {
            System.out.print("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        mergeSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
