package ch2.HDU6375;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), q = scanner.nextInt();
        Deque<Integer>[] deques = new Deque[n + 1];
        for (int i = 0; i <= n; i++) {
            deques[i] = new LinkedList<>();
        }
        for (int i = 0; i < q; i++) {
            int command = scanner.nextInt();
            if (command == 1) {
                int u = scanner.nextInt();
                int w = scanner.nextInt();
                int val = scanner.nextInt();
                Deque<Integer> deque = deques[u];
                if (w == 0) deque.offerFirst(val);
                else if (w == 1) deque.offerLast(val);
            }

            if (command == 2) {
                int u = scanner.nextInt();
                int w = scanner.nextInt();
                Deque<Integer> deque = deques[u];
                if (deque.isEmpty()) System.out.println(-1);
                else if (w == 0) System.out.println(deque.pollFirst());
                else if (w == 1) System.out.println(deque.pollLast());
            }

            if (command == 3) {
                int u = scanner.nextInt();
                int v = scanner.nextInt();
                int w = scanner.nextInt();

                Deque<Integer> uDeque = deques[u];
                Deque<Integer> vDeque = deques[v];
                if (w == 0) {
                    while(!vDeque.isEmpty())  uDeque.offerLast(vDeque.pollFirst());
                }

                if (w == 1) {
                    while(!vDeque.isEmpty())  uDeque.offerLast(vDeque.pollLast());
                }
            }
        }
    }
}
