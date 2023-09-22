package BaseStructures.TreeDepth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int [] tree = new int[n];
        int head = 0;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            tree[i] = scanner.nextInt();
            if (tree[i] == -1)
                head = i;
            hashMap.putIfAbsent(tree[i], new ArrayList<>());
            ArrayList<Integer> list = hashMap.get(tree[i]);
            list.add(i);
        }
        //System.out.println(mapApproach(hashMap, -1));

        //System.out.println(bruteForce(tree, head));

        boolean[] visitedMap = new boolean[n];
        System.out.println(upgradedBruteForce(tree, visitedMap, head));
    }

    private static int mapApproach(HashMap<Integer, ArrayList<Integer>> map, int currentNode) {
        if (!map.containsKey(currentNode))
            return 0;

        int max = 0;
        for (Integer child : map.get(currentNode))
            max = Math.max(max, mapApproach(map, child) + 1);

        return max;
    }

    private static int bruteForce(int[] tree, int currentNode) {
        int maxDept = 1;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == currentNode)
                maxDept = Math.max(maxDept, bruteForce(tree, i) + 1);
        }
        return maxDept;
    }

    private static int upgradedBruteForce(int[] tree, boolean[] visitedNodes, int currentNode) {
        visitedNodes[currentNode] = true;
        int maxDept = 1;
        for (int i = 0; i < tree.length; i++) {
            if (tree[i] == currentNode && !visitedNodes[i])
                maxDept = Math.max(maxDept, upgradedBruteForce(tree, visitedNodes, i) + 1);
        }
        return maxDept;
    }
}
