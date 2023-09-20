package BaseStructures.MaximumStack;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        MaximumStack ms = new MaximumStack();
        ArrayList<String> output = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            String[] command = scanner.nextLine().split(" ");
            switch (command[0]) {
                case "push" -> ms.push(Integer.parseInt(command[1]));
                case "pop" -> ms.pop();
                case "max" -> output.add(String.valueOf(ms.max()));
            }
        }
        for (String s : output)
            System.out.println(s);
    }
}

class MaximumStack {
    Stack<Integer> stack;
    Stack<Integer>  mins;

    public MaximumStack() {
        stack = new Stack<>();
        mins  = new Stack<>();
        mins.push(Integer.MIN_VALUE);
    }

    public void push(int num) {
        stack.push(num);
        mins.push(Math.max(mins.peek(), num));
    }

    public void pop() {
        stack.pop();
        mins.pop();
    }

    public int max() {
        return mins.peek();
    }
}