package chap09;

import java.util.Comparator;
import java.util.Scanner;

public class DblLinkedListTester {
    static Scanner stdIn = new Scanner(System.in);

    static class Data {
        static final int NO = 1;
        static final int NAME = 2;

        private Integer no;
        private String name;

        public String toString() {
            return "(" + no + ") "  + name;
        }

        void scanData(String guide, int sw) {
            System.out.println(guide + "할 데이터를 입력하세요.");

            if((sw & NO) == NO){
                System.out.printf("번호 : ");
                no = stdIn.nextInt();
            }
            if((sw & NAME) == NAME) {
                System.out.printf("이름: ");
                name = stdIn.next();
            }
        }

        public static final Comparator<Data> NO_ORDER =
                new NoOrderComparator();

        private static class NoOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2){
                return (d1.no > d2.no) ? 1 : (d1.no < d2.no) ? -1 : 0;
            }
        }

        public static final Comparator<Data> NAME_ORDER =
                new NameOrderComparator();

        private static class NameOrderComparator implements Comparator<Data> {
            public int compare(Data d1, Data d2){
                return d1.name.compareTo(d2.name);
            }
        }
    }

    enum Menu{
        ADD_FIRST( "머리에 노드를 삽입"),
        ADD_LAST( "꼬리에 노드를 삽입"),
        ADD("선택 노드의 바로 뒤에 삽입"),
        RMV_FIRST("머리 노드를 삭제"),
        RMV_LAST("꼬리 노드를 삭제"),
        RMV_CRNT("선택 노드를 삭제"),
        CLEAR("모든 노드를 삭제"),
        SEARCH_NO("번호로 검색"),
        SEARCH_NAME("이름으로 검색"),
        NEXT("선택 노드를 뒤쪽으로"),
        PREV("선택 노드를 앞쪽으로"),
        PRINT_CRNT("선택 노드를 출력"),
        DUMP("모든 노드를 출력"),
        TERMINATE("종료");

        private final String message;

        static Menu MenuAt(int idx) {
             for(Menu m : Menu.values())
                 if(m.ordinal() == idx)
                     return m;
             return null;
        }

        Menu(String string) {
            message = string;
        }

        String getMessage() {
            return message;
        }
    }

    static Menu SelectMenu() {
        int key;

        do{
            for(Menu m : Menu.values()) {
                System.out.printf("(%d) %s  ", m.ordinal(), m.getMessage());
                if((m.ordinal() % 3) == 2 &&
                m.ordinal() != Menu.TERMINATE.ordinal())
                    System.out.println();
            }
            System.out.printf(" : ");
            key = stdIn.nextInt();
        } while (key < Menu.ADD_FIRST.ordinal() ||
        key > Menu.TERMINATE.ordinal());
        return Menu.MenuAt(key);
    }
}
