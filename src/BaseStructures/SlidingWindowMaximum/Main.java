package BaseStructures.SlidingWindowMaximum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = scanner.nextInt();
        int k = scanner.nextInt();
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        Stack<Integer> firstWindow = new Stack<>();
        Stack<Integer> firstMaxes  = new Stack<>();

        Stack<Integer> reverseWindow = new Stack<>();
        Stack<Integer> reverseMaxes  = new Stack<>();

        ArrayList<Integer> result = new ArrayList<>();

        for (int g = 0; g < nums.length; g++) {
            if (firstWindow.size() < k && reverseWindow.isEmpty()) {
                firstWindow.push(nums[g]);
                firstMaxes.push(Math.max(nums[g], firstMaxes.size() > 0 ? firstMaxes.peek() : Integer.MIN_VALUE));
            }
            if (firstWindow.size() == k && reverseWindow.isEmpty()) {
                int max = Integer.MIN_VALUE;
                while (!firstWindow.isEmpty()) {
                    reverseWindow.push(firstWindow.pop());
                    firstMaxes.pop();
                    max = Math.max(reverseWindow.peek(), max);
                    reverseMaxes.push(max);
                }
                result.add(reverseMaxes.pop());
                reverseWindow.pop();
            }
            else if (firstWindow.size() < k && !reverseWindow.isEmpty()) {
                firstWindow.push(nums[g]);
                firstMaxes.push(Math.max(nums[g], firstMaxes.size() > 0 ? firstMaxes.peek() : Integer.MIN_VALUE));
                result.add(Math.max(reverseMaxes.pop(),  firstMaxes.peek()));
                reverseWindow.pop();
            }
        }

        int[] resultArray = new int [result.size()];
        for (int i = 0; i < result.size(); i++)
            resultArray[i] = result.get(i);
        return resultArray;
    }
}
