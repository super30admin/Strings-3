TC - O(N)
SC - O(N) for stack
/**
 * @param {string} s
 * @return {number}
 */
var calculate = function(s) {
     s = s.trim();
    var stack=[],num=0;
    var sign='+';
    for(let i=0;i<s.length;i++)
    {   
        
        if(s[i] === ' ') continue;
        if(!isNaN(s[i])) num = num * 10 + s[i].charCodeAt(0) - '0'.charCodeAt(0);
        if(isNaN(s[i])||i===s.length-1) {
            switch(sign) {
                case '+':
                    stack.push(num);
                    break;
                case '-':
                    stack.push(-num);
                    break;
                case '*':         
                    stack.push(stack.pop() * num);
                    break;
                case '/':
                    stack.push(parseInt(stack.pop() / num, 10));
                    break;
            }
            sign = s[i];
            num = 0;
        }
    }
    return stack.reduce((A,B)=>A+B);
};