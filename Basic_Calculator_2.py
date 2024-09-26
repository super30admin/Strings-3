// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach
we set the value as 0 and sign as positive intially and we used stack in here.when we encounter a digit then we concatenate with the value present in val.if it is operation such as '+' we add the value to the stack,if it is a '-', we add negated value to the stack.If it is '*' or '/' then we pop the top element from the stack and then we mutiply with value with the given operator.In the end we add all the elements in the stack.

# Time complexity -->o(n)
# space complexity --> o(n)
class Solution(object):
    def calculate(self, s):
        """
        :type s: str
        :rtype: int
        """
        stack=[]
        sign='+'
        val=0
        result=0
        for i in range(len(s)):
            if s[i].isdigit():
                val=val*10+(ord(s[i])-ord('0'))
            if (not s[i].isdigit() and s[i]!=' ') or i==len(s)-1:
                if sign=='+':
                    stack.append(val)
                if sign=='-':
                    stack.append(-1*val)
                if sign=='*':
                    stack.append(stack.pop()*val)
                if sign=='/':
                    ele=stack.pop()
                    if ele<0:
                        ele=-1*ele
                        ele=ele/val
                        ele=-1*ele
                    else:
                        ele=ele/val
                    stack.append(ele)
                sign=s[i]
                val=0
            # print(stack,sign,val)
        while len(stack)>0:
            result=result+stack.pop()
        return result