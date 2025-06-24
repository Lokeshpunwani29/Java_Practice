import java.util.ArrayList;
import java.util.Stack;

public class StackAL {
    static class StackClass {
        ArrayList<Integer> list = new ArrayList<>();

        public void push(int data) {
            list.add(data);
        }

        public boolean isEmpty() {
            return list.size() == 0;
        }

        public int pop() {
            if(isEmpty()) {
                return -1;
            }
            int top = list.remove(list.size()-1);
            return top;
        }

        public int peek() {
            if(isEmpty()) {
                return -1;
            }
            return list.get(list.size()-1);
        }
    }
    public static void main(String args[]) {
        StackClass stack = new StackClass();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while(!stack.isEmpty()) {
            System.out.println(stack.peek());
            stack.pop();
        }
        
        System.out.println("------------------------------------------------");
        // Using Collection Framework
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s1.push(4);

        while(!s1.isEmpty()) {
            System.out.println(s1.peek());
            s1.pop();
        }
    }
}
