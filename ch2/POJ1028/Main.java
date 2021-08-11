package ch2.POJ1028;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<String> backStack = new Stack<>();
        Stack<String> forwardStack = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String cur = "***###.acm.org/";
        while(scanner.hasNext()) {
            String command = scanner.next();
            if(command.equals("VISIT")) {
                String url = scanner.next();
                forwardStack.clear();
                backStack.push(cur);
                cur = url;
                System.out.println(cur);
            } else if(command.equals("BACK")) {
                if(backStack.isEmpty()) {
                    System.out.println("Ignored");
                    continue;
                }
                forwardStack.push(cur);
                cur = backStack.pop();
                System.out.println(cur);
            } else if(command.equals("FORWARD")) {
                if(forwardStack.isEmpty()) {
                    System.out.println("Ignored");
                    continue;
                }
                backStack.push(cur);
                cur = forwardStack.pop();
                System.out.println(cur);
            } if(command.equals("QUIT")) {
                break;
            }
        }
    }
}
