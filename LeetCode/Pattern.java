import java.util.Stack;

class Pattern {
    public static void main(String[] args) {
    }
}
class Solution {
    public boolean find132pattern(int[] nums) {
        Stack<Pair> stk = new Stack<>();
        for (int n: nums) {
            if (stk.empty()||n<stk.peek().min) stk.push(new Pair(n, n));
            else if (n>stk.peek().min) {
                Pair last = stk.pop();
                if (n<last.max) return true;
                else {
                    last.max = n;
                    while(!stk.empty()&&n>=stk.peek().max) stk.pop();
                    if(!stk.isEmpty() && stk.peek().min < n) return true;
                    stk.push(last);
                }                
            }
        }
        return false; 
    }
}
class Pair {
    int min, max;
    public Pair(int min, int max) {
        this.min = min;
        this.max = max;
    }
}