import java.util.Scanner;

public class TaschenRechnerV42Adv {
    static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyStack stack = new MyStack();

        System.out.println("Weißt du wie ein RPN-Taschenrechner funktioniert? (true/false)");
        boolean know;
        String x;

        while (true) {
            x = scan.next();
            if (x.equals("true")) {
                know = true;
                break;
            } else if (x.equals("false")) {
                know = false;
                break;
            } else {
                System.out.println("Wrong input");
            }
        }
        System.out.print(know ? "lets Start, give me the first number. (exit = exit)\n->" : "\nGo and read something about it.");
        if (!know) return;

        while (!x.equals("exit")) {
            x = scan.next();
            //no negative numbers?
            if (isDouble(x)) {
                double push = Double.parseDouble(x);
                if (push < 0) {
                    System.out.println("no negative numbers\n->");
                    continue;
                }
                stack.push(push);
                print(stack);
            } else {
                int sz = stack.size();

                // Stack size prüfen
                boolean need2 = x.equals("+") || x.equals("-") || x.equals("*") || x.equals("/") || x.equals("swap");
                boolean need1 = x.equals("sqrt") || x.equals("inv") || x.equals("dup") || x.equals("drop") || x.equals("fact");
                if (need2 && sz < 2) {
                    System.out.println("Need 2 items on stack!");
                    continue;
                }
                if (need1 && sz < 1) {
                    System.out.println("Need 1 item on stack!");
                    continue;
                }

                switch (x) {
                    //Operatoren
                    case "+" -> {
                        double[] ab = pop2(stack);
                        stack.push(ab[0] + ab[1]);
                    }
                    case "-" -> {
                        double[] ab = pop2(stack);
                        stack.push(ab[1] - ab[0]);
                    }
                    case "*" -> {
                        double[] ab = pop2(stack);
                        stack.push(ab[0] * ab[1]);
                    }
                    case "/" -> {
                        double[] ab = pop2(stack);
                        if (ab[1] == 0) {
                            System.out.println("div by zero!");
                            stack.push(ab[1]);
                            stack.push(ab[0]);
                            break;
                        }
                        stack.push(ab[0] / ab[1]);
                    }
                    //funktionen
                    case "swap" -> swap(stack);
                    case "sqrt" -> sqrt(stack, pop1(stack));
                    case "inv" -> inv(stack, pop1(stack));
                    case "dup" -> dup(stack);
                    case "drop" -> drop(stack);
                    case "fact" -> fact(stack);
                    case "ln" -> ln(stack);
                    case "yx" -> yx(stack);
                    case "pi" -> stack.push(Math.PI);
                    case "clear" -> stack.clear();
                    //error
                    default -> System.out.println("Unknown operator");
                }
                print(stack);
            }
        }
    }

    //input prüfen
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    //Mathe stuff
    public static void sqrt(MyStack stack, double x) {
        //herumprobieren error bei abbruch auswerfen
        if (x < 0) throw new IllegalArgumentException("stay positive :)");
        stack.push(Math.sqrt(x));
    }

    public static void inv(MyStack stack, double x) {
        if (x == 0) throw new IllegalArgumentException("Cannot invert zero");
        stack.push(1 / x);
    }

    public static void dup(MyStack stack) {
        stack.push(stack.peek());
    }

    public static void fact(MyStack stack) {
        double x = stack.pop();
        if (x < 0 || x != (int) x) throw new IllegalArgumentException("factorial requires non-negative integer");
        for (int i = (int) x - 1; i > 0; i--)  x *= i;
        stack.push(x);
    }

    public static void ln(MyStack stack) {
        double x = stack.pop();
        stack.push(Math.log(x));
    }

    public static void yx(MyStack stack) {
        double x = stack.pop(), y = stack.pop();
        stack.push(Math.pow(y, x));
    }

    //swap
    public static void swap(MyStack stack) {
        double top = stack.pop(), below = stack.pop();
        stack.push(top);
        stack.push(below);
    }

    //hot potato
    public static void drop(MyStack stack) {
        stack.pop();
    }

    //popper
    static double[] pop2(MyStack stack) {
        return new double[]{stack.pop(), stack.pop()};
    }

    static double pop1(MyStack stack) {
        return stack.pop();
    }

    //Print
    private static void print(MyStack stack) {
        System.out.println("=".repeat(30));
        for (int line = 4; line >= 1; line--) {
            double val = 0.0;
            int idx = line - 1;
            if (idx < stack.size()) val = stack.peek(idx);
            System.out.printf(val == 0 ? "%d:%22.2f%n" : "%d:%22f%n", line, val);
        }
        System.out.println("=".repeat(30));
        System.out.print("->");
    }
}//Quack!
