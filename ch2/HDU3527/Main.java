package ch2.HDU3527;

import java.util.*;

public class Main {
    //没有AC
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int a = scanner.nextInt(), b = scanner.nextInt(), c = scanner.nextInt();
            Set<String> aSet = new LinkedHashSet<>(), bSet = new LinkedHashSet<>(), cSet = new LinkedHashSet<>();
            for (int i = 0; i < a; i++) {
                aSet.add(scanner.next());
            }

            for (int i = 0; i < b; i++) {
                bSet.add(scanner.next());
            }

            for (int i = 0; i < c; i++) {
                cSet.add(scanner.next());
            }

            List<String> result = new ArrayList<>();
            for (String s : bSet) {
                if (!cSet.contains(s) && aSet.contains(s)) {
                    result.add(s);
                }
            }
            if (result.isEmpty()) {
                System.out.print("No enemy spy\n");
            }

            for (int i = 0; i < result.size(); i++) {
                String s = i == result.size() - 1 ? result.get(i) + "\n" : result.get(i) + " ";
                System.out.print(s);
            }
        }
    }


}