package chap07;

public class IntSet {
    private int max; //집합의 최대 개수
    private int num; //집합의 요소 개수
    private int[] set; //집합 본체

    public IntSet(int capacity){
        num = 0;
        max = capacity;
        try{
            set = new int[max];
        } catch (OutOfMemoryError error){
            max = 0;
        }
    }

    public int capacity() {
        return max;
    }

    public int size() {
        return num;
    }

    //집합에서 n 검색
    public int indexOf(int n){
        for(int i = 0; i < num; i++)
            if(set[i] == n)
                return i;
        return -1;
    }

    //집합에 n 있는지 확인
    public boolean contains(int n) {
        return(indexOf(n) != -1) ? true : false;
    }

    //집합에 n추가
    public boolean add(int n) {
        if(num >= max || contains(n) == true)
            return  false;
        else {
            set[num++] = n;
            return true;
        }
    }

    //집합에서 n삭제
    public boolean remove(int n) {
        int idx;

        if(num <= 0 || (idx = indexOf(n)) == -1)
            return false;
        else{
            set[idx] = set[--num];
            return true;
        }
    }

    public void copyTo(IntSet s){
        int n = (s.max < num) ? s.max : num;
        for(int i = 0; i < n; i++)
            s.set[i] = set[i];
        s.num = n;
    }

    public void copyFrom(IntSet s) {
        int n = (max < s.num) ? max : s.num;
        for(int i = 0; i < n; i++)
            set[i] = s.set[i];
        num = n;
    }

    public boolean equalTo(IntSet s) {
        if(num != s.num)
            return false;

        for(int i = 0; i < num; i++) {
            int j = 0;
            for(; j < s.num; j++)
                if(set[i] == s.set[j])
                    break;
            if(j == s.num)
                return false;
        }
        return true;
    }

    public void unionOf(IntSet s1, IntSet s2) {
        copyFrom(s1);
        for(int i = 0; i < s2.num; i++)
            add(s2.set[i]);
    }

    public String toString() {
        StringBuffer temp = new StringBuffer("{");
        for(int i = 0; i < num; i++)
            temp.append(set[i] + " ");
        temp.append("}");
        return temp.toString();
    }

}
