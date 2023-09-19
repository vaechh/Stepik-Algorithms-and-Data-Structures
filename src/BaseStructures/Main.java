package BaseStructures;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();

        MyStack<Character> stack = new MyStack<>();
        int index = 1;
        int lasComaIndex = -1;
        boolean error = false;

        for (char c : s.toCharArray()) {
            if (c == '{' || c == '(' || c == '[') {
                if (stack.isEmpty())
                    lasComaIndex = index;
                stack.push(c);
            }
            else if (c == '}') {
                if (stack.isEmpty() || stack.top() != '{') {
                    System.out.println(index);
                    error = true;
                    break;
                }
                else stack.pop();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.top() != '[') {
                    System.out.println(index);
                    error = true;
                    break;
                }
                else stack.pop();
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.top() != '(') {
                    System.out.println(index);
                    error = true;
                    break;
                }
                else stack.pop();
            }
            index++;
        }

        if (!error && stack.isEmpty())
            System.out.println("Success");
        else if (!error && !stack.isEmpty())
            System.out.println(lasComaIndex);
    }
}