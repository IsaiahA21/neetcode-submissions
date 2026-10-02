/**
"([{}])"
'(' - will be closed last

Open → push.
Close → stack cannot be empty, and top must match → pop.
End → stack must be empty.
*/
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque(); // add open parenthesis to stack

        // we add open bracket to the stack and try to fix the closing bracket
        for(char ch : s.toCharArray()){
            if (ch == '(' || ch == '{' || ch == '['){
                // System.out.println("open bracket");
                stack.push(ch);
                continue;
            }

            if (stack.isEmpty()){
                // theres a closing bracket and no opening bracket
                return false;
            }
            // else if not a open bracket, its a close bracket and we expect to see its opening bracket in the stack
            if (ch == ')' && stack.peek() != '('){
                return false;
            }
            if (ch == '}' && stack.peek() != '{'){
                return false;
            }
            if (ch == ']' && stack.peek() != '['){
                return false;
            }
            stack.pop();
        }

        if (stack.isEmpty()){
            return true;
        }
        return false;

    }
}
