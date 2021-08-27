package ch2.HDU1276;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(int i=0;i<count;i++) {
            int n = scanner.nextInt();
            DoubleLinkList head = new DoubleLinkList();
            DoubleLinkList node = head;
            for(int j=1;j<=n;j++) {
                DoubleLinkList newNode = new DoubleLinkList();
                newNode.val = j;
                node.next = newNode;
                newNode.pre = node;
                node = node.next;
            }

            int size = n;
            boolean flag = true;
            while(size > 3) {
                node = head.next;
                if (flag) {
                    while(size > 3 && node != null && node.next != null) {
                        node.next = node.next.next;
                        if(node.next != null) node.next.pre = node;
                        node = node.next;
                        size--;
                    }
                }

                if (!flag) {
                    while(size > 3 && node != null && node.next != null && node.next.next != null) {
                        node.next.next = node.next.next.next;
                        if(node.next.next != null) node.next.next.pre = node.next;
                        node = node.next.next;
                        size--;
                    }
                }

                flag = !flag;
            }

            node = head.next;
            while(node != null) {
               String str = node.next == null ? node.val +"" : node.val +" ";
               node = node.next;
               System.out.print(str);
            }
            if(i < count - 1) System.out.println();
        }
    }




    static class DoubleLinkList {
        int val;
        DoubleLinkList pre;
        DoubleLinkList next;
    }
}
