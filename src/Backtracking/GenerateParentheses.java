package Backtracking;


import java.util.*;
public class GenerateParentheses {

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, "", 0, 0, n);
        return result;
    }

    // backtracking function
    private static void backtrack(List<String> result, String current, int open, int close, int max) {
        // if the string is complete
        if (current.length() == max * 2) {
            result.add(current);
            return;
        }

        // if we can add '('
        if (open < max) {
            backtrack(result, current + "(", open + 1, close, max);
        }

        // if we can add ')'
        if (close < open) {
            backtrack(result, current + ")", open, close + 1, max);
        }
    }

    public static void main(String[] args) {
        int n = 3;
        System.out.println(generateParenthesis(n));
    }
}