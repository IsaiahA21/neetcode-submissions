class Solution {
    public boolean isValid(String s) {
        // Carina's solution
        Deque<Character> stack = new ArrayDeque(); 

        for(char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() &&
                    ((ch == ')' && stack.peek() == '(') ||
                    (ch == '}' && stack.peek() == '{') ||
                    (ch == ']' && stack.peek() == '['))) {
                        stack.pop();
                } else {
                    return false;
                }

            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
        
    }
}
