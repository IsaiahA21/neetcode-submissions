/**
Use 2 stacks
stack -> implement a stack
minStack -> always keeps track of the min ele we seen so far.
if the new ele is smaller than the ele we seen so far then its gonna be at the top of the minStack. 
 - we keep the min eles we seen in the minStack cause if the new ele gets popped then the prev min becomes the new min 

if the new ele is bigger then the min ele we seen so far, then we dont add it to the minStack.
// it cant ever be the min cause the elements that arrived in the stack first outlive it.

deque
front[,]back
*/
class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;


    public MinStack() {
        stack = new ArrayDeque<Integer>();
        minStack = new ArrayDeque<Integer>();
    }
    
    public void push(int val) {
        stack.addFirst(val);

        if(minStack.isEmpty() || val <= minStack.peekFirst()){
            minStack.addFirst(val);
        }
    }
    
    public void pop() {
         if (stack.isEmpty()) return;
        int popped = stack.removeFirst();


        if (minStack.peekFirst() == popped){
            minStack.removeFirst();
        }

    }
    
    public int top() {
        return stack.peekFirst();
    }
    
    public int getMin() {
        return minStack.peekFirst();
    }
}
