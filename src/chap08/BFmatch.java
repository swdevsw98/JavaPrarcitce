package chap08;

import java.util.Scanner;

public class BFmatch {
    static int bfMatch(String txt, String pat){
        int pt = 0;
        int pp = 0;

        while(pt != txt.length() && pp != pat.length()){
            if(txt.charAt(pt) == pat.charAt(pp)){ //charAt() == 특정 위치 리턴
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }
        if(pp == pat.length())
            return pt - pp;
        return -1;
    }

    public static void main(String[] args){
        Scanner stdIn = new Scanner(System.in);

        System.out.printf("텍스트 : ");
        String s1 = stdIn.next();

        System.out.printf("패턴 : ");
        String s2 = stdIn.next();

        int idx = bfMatch(s1, s2);

        if(idx == 1)
            System.out.println("텍스트에 패턴이 없습니다");
        else {
            //일치하는 문자 바로 앞까지의 길이를 구함.
            int len = 0;
            for (int i = 0; i < idx; i++)
                len += s1.substring(i, i+1).getBytes().length; //substring(a,b) -> a부터 b까지 자른값 리턴
            len += s2.length();

            System.out.println((idx + 1) + "번째 문자부터 일치합니다.");
            System.out.println("텍스트 : " + s1);
            System.out.printf(String.format("패턴 : %%%ds\n", len), s2);
        }
    }
}
