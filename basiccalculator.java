
//time complexity: O(string length)
//space complexity: O(n)

//we calculate * and / first. When iterating over the operators, when meet a ‘+’ or ‘-‘, then we can pass the next number into stack,  if we meet ‘-‘, we push the negative value of that number. When meet a ‘’ or ‘/’, we calculate this first, pop one element from the stack and use it to calculate with the next number. 
//Then pushing the result back to the stack. 

Extracting numbers and ops can be done by iterating instead of using regex as well.
class Solution {
    public int calculate(String s) {
       s = s.trim().replaceAll(" ","");
        String[] nums = s.split("[\\+\\-\\*/]+");
        String[] ops = s.split("[\\d]+");
        Stack<Integer> numsStack = new Stack<Integer>();
        numsStack.push(Integer.parseInt(nums[0]));
        for (int i = 1; i < ops.length; i ++) {
            int curr = Integer.parseInt(nums[i]);
            if (ops[i].equals("*")) {
                curr = numsStack.pop() * curr;
            }
            if (ops[i].equals("/")) {
                curr = numsStack.pop() / curr;
            }
            if (ops[i].equals("-")){
                curr = -curr;
            }
            numsStack.push(curr);
        }
        int result = 0;
        while (numsStack.size() > 0) {
            result += numsStack.pop();
        }
        return result;
    }
}