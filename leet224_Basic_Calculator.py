# Solution

# // Time Complexity : O(2N) 
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : None


# // Your code here along with comments explaining your approach
# Approach is keep adding each value to stack, when we come across "(" I can add math.inf along with the sign before the bracket
# to stack. Now we can continue adding next values, when we get ")" we pop and add till we get math.inf and also the sign before it,
# so that we can perform the calcualtion within the brackets and then add that result to stack. Finally we can go through the entire
# stack and sum to get the result.
import math
def calculate(s):
    inStr = s.strip()
    lv_curr = 0
    lv_op = "+"
    valStack = []
    n = len(inStr)
    result = 0
    for i in range(0,n):
        if inStr[i] == " ":
            continue
        if inStr[i].isdigit():
            lv_curr = lv_curr*10 + int(lv_op+inStr[i])
        elif inStr[i] == "(":
            valStack.append(int(lv_op+"1"))
            valStack.append(math.inf)
            lv_op = "+"
            lv_curr = 0
        elif inStr[i] == ")":
            temp = lv_curr
            sum = 0
            while temp != math.inf:
                sum += temp
                temp = valStack.pop()
            temp = valStack.pop()
            sum *= temp
            valStack.append(sum)
            lv_op = "+"
            lv_curr = 0
        elif lv_op == "-":
            valStack.append(lv_curr)
            lv_op = inStr[i]
            lv_curr = 0
        elif lv_op == "+":
            valStack.append(lv_curr)
            lv_op = inStr[i]
            lv_curr = 0
    
    while valStack:
        result += valStack.pop()
    
    return result+lv_curr

if __name__ == "__main__":
    s = "(1+(4+5+2)-3)+(6+8)"
    print(calculate(s))
