import java.util.Stack;

public class larningStack {
    public static void main(String[] args) {
        //Stack is a data structure where it follows FIFO
        Stack<String> newStack = new Stack<>();

        //push into stack:
        newStack.push("item1");
        newStack.push("item2");
        newStack.push("item3");
        newStack.push("item4");

        System.out.println("The stack: " + newStack);

        //peek() will return the peek element in stack:
        System.out.println("The peek element: " + newStack.peek());
    }
}
