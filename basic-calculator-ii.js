// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes, integer division in javascript is weird.
// I had to handle the case of 14 - 3/2.  This should evaluate to 14 - 1, but I was using Math.floor (which rounds down)
// Therefore, it was evaluating to 14 - 2 instead.  To get around this I had to use ~~ which apparently is a shorthand for Math.floor
// and runs faster??? It's a double NOT bitwise operator.

/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
    if (!s || !s.length) return 0;
    
    let sign = '+',
        val = 0,
        stack = [],
        result = 0,
        i = 0;
    
    while (i <= s.length) {
        let ch = s[i];
        
        if (!isNaN(ch) && ch != ' ') val = val * 10 + parseInt(ch);

        if ((isNaN(ch) && ch != ' ') || i == s.length - 1) {
            if (sign == '+') stack.push(val);
            else if (sign == '-') stack.push(-val);
            else if (sign == '*') stack.push(stack.pop() * val);
            else if (sign == '/') {
                stack.push(~~(stack.pop() / val));
            }
            
            val = 0;
            sign = ch;
        }
        i++;
    }
    while (stack.length) {
        result += stack.pop();
    }
    
    return result;
};
