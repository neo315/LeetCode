//// #155 Min Stack
//Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
//
//push(x) -- Push element x onto stack.
//pop() -- Removes the element on top of the stack.
//top() -- Get the top element.
//getMin() -- Retrieve the minimum element in the stack.
// Tags:  Stack, Data Structure
class MinStack { 
    ArrayList<Integer> num = new ArrayList<Integer>(); 
    ArrayList<Integer> min = new ArrayList<Integer>(); 
     
    public void push(int x) { 
        num.add(x); 
        if (min.isEmpty() || x <= min.get(min.size() - 1))  
            min.add(x); 
    } 
 
    public void pop() { 
        if (num.isEmpty()) return; 
        int toremove = num.remove(num.size() - 1); 
        if (toremove == min.get(min.size() - 1)) 
            min.remove(min.size() -1); 
         
        return; 
    } 
 
    public int top() { 
        if (num.isEmpty()) return 0; 
        else return num.get(num.size() - 1); 
    } 
 
    public int getMin() { 
        if (min.isEmpty()) return 0; 
        else return min.get(min.size() - 1); 
    } 
} 
