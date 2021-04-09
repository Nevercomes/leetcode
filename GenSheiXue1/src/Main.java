import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static class Node {

        private int data;
        private Node next;

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static Node getCommon(Map<String, Node> map, Node headA, Node headB) {
        // 在第一遍遍历的时候不就可以拿到了吗？
        Node a = headA;
        Node b = headB;
        while (a != null && b != null) {
            if (map.get(String.valueOf(a.getData())) != null && map.get(String.valueOf(b.getData())) != null) {
                return a;
            }
            a = a.getNext();
            b = b.getNext();
        }
        return null;
    }
    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        String line1 = in.nextLine();
        String line2 = in.nextLine();

        Node headA = null;
        Node headB = null;

        Integer ans = null;
        int indexSum = Integer.MAX_VALUE;
        Map<String, Integer> map = new HashMap<>();
        if (line1 != null && line1.length() > 0) {
            String[] arr1 = line1.split(",");
            for (int i = 0; i < arr1.length; i++) {
                if (map.get(arr1[i]) != null) {
                    map.put(arr1[i], i);
                }
            }
        }
        if (line2 != null && line2.length() > 0) {
            String[] arr2 = line2.split(",");
            for (int i = 0; i < arr2.length; i++) {
                Integer idx1 = map.get(arr2[i]);
                if (idx1 != null) {
                    if (idx1 + i < indexSum) {
                        ans = Integer.getInteger(arr2[i]);
                    }
                }
            }
        }

//        if (line1 != null && line1.length() > 0) {
//            String[] array1 = line1.split(",");
//            headA = new Node();
//            headA.setData(Integer.parseInt(array1[0].split("\\(")[0]));
//            map.put(array1[0], headA);
//            Node pre = headA;
//            for (int i = 1; i < array1.length; i++) {
//                Node node = map.get(array1[i]);
//                if (node == null) {
//                    node = new Node();
//                    node.setData(Integer.parseInt(array1[i].split("\\(")[0]));
//                    map.put(array1[i], node);
//                }
//                pre.next = node;
//                pre = node;
//            }
//        }
//        Node res = null;
//        if (line2 != null && line2.length() > 0) {
//            String[] array2 = line2.split(",");
//            headB = map.get(array2[0]);
////            if (headB == null) {
////                headB = new Node();
////                headB.setData(Integer.parseInt(array2[0].split("\\(")[0]));
////                map.put(array2[0], headB);
////            }
//            if (headB != null) {
//                res = headB;
//            } else {
////                Node pre = headB;
//                for (int i = 1; i < array2.length; i++) {
//                    Node node = map.get(array2[i]);
////                    if (node == null) {
////                        node = new Node();
////                        node.setData(Integer.parseInt(array2[i].split("\\(")[0]));
////                        map.put(array2[i], node);
////                    }
//                    if (node != null) {
//                        res = node;
//                    }
////                    pre.next = node;
////                    pre = node;
//                }
//            }
//
//        }
//
////        Node res = getCommon(map, headA, headB);
        System.out.println(ans);
    }
}
