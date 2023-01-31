package chap06;

import java.util.Scanner;

public class HeapSort {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void downHeap(int[] a, int left, int right){
        int temp = a[left]; //루트
        int child; // 큰값을 가진 노드
        int parent; // 부모

        for(parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;
            int cr = cl + 1;
            child = (cr <= right && a[cr] > a[cl]) ? cr : cl; // 큰값을 가진 노드를 자식에 대입
            if(temp >= a[child])
                break;
            a[parent] = a[child];
        }
        a[parent] = temp;
    }

    static void heapSort(int[] a, int n){
        for(int i = (n - 1) / 2; i >= 0; i--) //a[i] ~ a[n-1] 힙으로 만들기
            downHeap(a, i , n-1);

        for(int i = n - 1; i > 0; i--){
            swap(a, 0, i); //가장 큰 요소와 마지막 요소 교환
            downHeap(a, 0, i - 1); // a[0] ~ a[i-1]을 힙으로 만듬
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("힙 정렬");
        System.out.printf("요솟수 : ");
        int nx = stdIn.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.printf("x[" + i + "] :");
            x[i] = stdIn.nextInt();
        }

        heapSort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
