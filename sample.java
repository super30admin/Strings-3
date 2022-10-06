// Time Complexity: O(N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : It was complicated and difficult to understand.

class Solution 
{
    private final String[] thousand = {"", "Thousand", "Million", "Billion"};
    
    private final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", 
    "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
     "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    private final String[] ten = {"", "", "Twenty", "Thirty", "Forty", "Fifty",
     "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
            
        StringBuilder sb = new StringBuilder();
        int index = 0;
        
        while (num > 0) {
            if (num % 1000 > 0) {
                StringBuilder temp = new StringBuilder();
                helper(temp, num % 1000);
                temp.append(thousand[index]).append(" ");
                sb.insert(0, temp);
            }
            index++;
            num = num / 1000;
        }
        return sb.toString().trim();
    }
    
    private void helper(StringBuilder temp, int num) 
    {
        if (num == 0) 
        {
            return;
        } 
        else if (num < 20) 
        {
            temp.append(belowTwenty[num]).append(" ");
            return;
        } 
        else if (num < 100) 
        {
            temp.append(ten[num / 10]).append(" ");
            helper(temp, num % 10);
        } 
        else 
        {
            temp.append(belowTwenty[num / 100]).append(" Hundred ");
            helper(temp, num % 100);
        }
    }
}


// Time Complexity: O(n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public int calculate(String s) {
        char[] array = s.toCharArray();
        Stack<Integer> stack = new Stack<>();
        char operator = '+';

        // Get rid of * and /
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ')
                continue;
            if (Character.isDigit(array[i])) {
                // build the number
                StringBuilder num = new StringBuilder();
                while (i < array.length && Character.isDigit(array[i])) {
                    num.append(array[i++]);
                }
                i--;

                int currentNum = Integer.parseInt(num.toString());
                if (operator == '-') {
                    currentNum *= -1;
                } else if (operator == '*') {
                    currentNum *= stack.pop();
                } else if (operator == '/') {
                    currentNum = stack.pop() / currentNum;
                }
                stack.push(currentNum);
            } else {
                operator = array[i];
            }
        }

        int total = 0;
        while (!stack.isEmpty()) {
            total += stack.pop();
        }
        return total;
    }
}