import BaseStructures.PlacingParentheses.MyStack;

import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("name");
        MyStack<Integer> stack = new MyStack<>();
        stack.pop();
        stack.pop();
        stack.top();
        logger.info(String.valueOf(stack.top()));
        for (int i = 0; i < 10; i++)
            stack.push(i);
        logger.info(String.valueOf(stack.top()));
        stack.pop();
        stack.pop();
        logger.info(String.valueOf(stack.top()));
        logger.info(String.valueOf(stack.getSize()));

        int size = stack.getSize();
        for (int j = 0; j < size; j++) {
            stack.pop();
        }
        logger.info(String.valueOf(stack.top()));
        logger.info(String.valueOf(stack.getSize()));
    }
}