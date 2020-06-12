// ## Problem2 
// Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes

const calculate = function(s) {
    if(!s || s.length === 0) return 0;
    s = s.trim();
    let st = [], lastSign = '+', num = 0, res = 0;
    for(let i = 0; i < s.length; i++) {
        if(s[i] === ' ') continue;
        if(isNaN(s[i]) === false) num = 10*num + parseInt(s[i]);
        if((isNaN(s[i]) === true) || i === s.length - 1) {
            if(lastSign === '+') st.push(num);
            else if(lastSign === '-') st.push(-num);
            else if(lastSign === '*') st.push(st.pop()*num);
            else if(lastSign === '/') st.push(parseInt(st.pop() / num));
            num = 0;
            lastSign = s[i];
        }
    }
    while(st.length > 0) {
        res += st.pop();
    }
    return res;
};