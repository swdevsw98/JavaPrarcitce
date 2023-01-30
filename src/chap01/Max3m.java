package chap01;

public class Max3m {
    static int max3(int a, int b, int c) {
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;

        return max;
    }

    static int max4(int a, int b, int c, int d){
        int max = a;
        if(b > max)
            max = b;
        if(c > max)
            max = c;
        if(d > max)
            max = d;

        return max;
    }

    static int min3(int a, int b, int c) {
        int min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;

        return min;
    }

    static int min4(int a, int b, int c, int d) {
        int min = a;
        if(b < min)
            min = b;
        if(c < min)
            min = c;
        if(d < min)
            min = d;

        return min;
    }

    public static void main(String[] args){
        System.out.println("max3(3,2,1) = " + max3(3,2,1));
        System.out.println("max4(3,2,2,4) = " + max4(3,2,2, 4));
        System.out.println("min3(3,1,2) = " + min3(3,1,2));
        System.out.println("min4(3,2,3,1) = " + min4(3,2,3,1));
    }
}
