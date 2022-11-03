// Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

// Without Stack
// Time Complexity : O(N)
// Space Complexity : O(1)

// With Stack
// Time Complexity : O(N)
// Space Complexity : O(N)

// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/**
 * @param {string} s
 * @return {number}
 */
var calculate = function (s) {
    if (s === null || s.length === 0)
        return 0;

    // W/o stack

    // let tail = 0; 
    // let lastSign = "+";
    // let num = 0;
    // let result = 0;
    // for(let i=0; i<s.length; i++){
    //     let ch = s[i];
    //     if(!isNaN(ch) && ch!==" " ){
    //         num = num*10 + parseInt(ch);
    //     }
    //     if((isNaN(ch) && ch!==" ") || (i === s.length-1)){
    //         switch(lastSign){
    //             case "+": result = result + num;
    //                 tail = num;
    //                 break;
    //             case "-": result = result - num;
    //                 tail = -num;                
    //                 break;
    //             case "*": result = result - tail + (tail*num);
    //                 tail = tail*num;
    //                 break;
    //             case "/": 
    //                 let newTail = tail<0 ? Math.ceil(tail/num) : Math.floor(tail/num);
    //                 result = (result - tail) + newTail;
    //                 tail = newTail;
    //                 break;
    //         }
    //         num = 0;
    //         lastSign = ch;
    //     }
    // }
    // result+=num;
    // return result;

    // With stack
    let stack = [];
    let result = 0;
    s = s.trim();
    let num = 0;
    let lastSign = "+"
    for (let i = 0; i < s.length; i++) {
        let ch = s[i];
        // Grab number
        if (!isNaN(ch) && ch !== " ") {
            num = num * 10 + parseInt(ch);
        }
        // If found a sign, push to stack
        // If found / or *, pop from stack, calculate and then push
        if ((isNaN(ch) && ch !== " ") || (i === s.length - 1)) {
            switch (lastSign) {
                case "+": stack.push(num)
                    break;
                case "-": stack.push(-num)
                    break;
                case "*": stack.push(stack.pop() * num);
                    break;
                case "/":
                    let lastNum = stack.pop();
                    let newNum = lastNum < 0 ? Math.ceil(lastNum / num) : Math.floor(lastNum / num);
                    stack.push(newNum);
                    break;
            }
            num = 0;
            lastSign = ch;

        }
    }
    // Add all elements in stack
    while (stack.length > 0) {
        result += stack.pop();
    }
    return result;
};