import java.util.Scanner;

public class TaschenRechnerV42easy {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        MyStack stack = new MyStack();

        System.out.println("Weißt du wie ein RPN-Taschenrechner funktioniert ? (true / false )");
        boolean know = scan.nextBoolean();
        System.out.println(know ? "Ok gibt die erste Zahl ein um zu Starten." : "Dann bitte Informier dich !!");
        if (!know) return;

        String x = "";
        while (!x.equals("saos")) {

            x = scan.next();
            // Ist ne Zahl, just push onto Stack;
            if (isDouble(x)) {
                double p = Double.parseDouble(x);
                stack.push(p);
                System.out.print("pushed..\n");
            }
            //operator input -> last 2 poppen -> berechnen -> ergebnis pushen;
            else {
                if (stack.size() < 2) {
                    System.out.println("Error.Nicht genug Zahlen im Stack");
                    continue;
                }
                double a = stack.pop(), b = stack.pop();
                double result = switch (x) {
                    case "+" -> b + a;
                    case "-" -> b - a;
                    case "*" -> b * a;
                    case "/" -> b / a;
                    default -> throw new IllegalArgumentException("unknown operator : "+x);
                };
                stack.push(result);
                System.out.println("Ergebnis : "+result);
            }


        }
    }//mainEnte!

    // ist es konvertierbar zu double? yes / no
    public static boolean isDouble(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}//Quack!
