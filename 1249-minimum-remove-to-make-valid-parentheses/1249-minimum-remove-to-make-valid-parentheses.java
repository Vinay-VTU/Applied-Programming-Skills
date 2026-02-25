import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder(s);
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty()) {
                    stack.pop(); // Found a valid pair
                } else {
                    // Mark invalid ')' with a placeholder
                    sb.setCharAt(i, '*');
                }
            }
        }
        
        // Remaining indices in stack are unmatched '('
        while (!stack.isEmpty()) {
            sb.setCharAt(stack.pop(), '*');
        }
        
        // Build final string by filtering out placeholders
        return sb.toString().replace("*", "");
    }
}
