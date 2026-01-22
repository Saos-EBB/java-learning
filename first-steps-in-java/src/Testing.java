public class Testing {
    static void main(String[] args) {

        MyStack Stack1 = new MyStack();
        MyStack Stack2 = new MyStack();

        Stack1.push(234);Stack1.push(11);Stack1.push(567);Stack1.push(890);


        Stack1.toString();
        String x = Stack1.toString();
        System.out.println(x);
        System.out.println(Stack1.peek());

        var y = Stack1.pop();
        var z = Stack1.pop();

        System.out.println(y + " " + z);




    }
}
