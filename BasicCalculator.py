"""
Approach: Using stack

We would do just traverse through the string and we would see two cases:
1) a digit: If a digit is encountered then start buiding your digit
2) a sign: Just keep track of the last sign encountered.

Now we need to do different operations depending upon last sign we encounterd.
+: If last digit is + then we just add the next number into stack
-: If last digit is - then we just add the negative value of next number into stack
*: If last digit is * then we just add the product of the next value and value currently on top stack into the stack
/: If last digit is / then we just add the division of the next value and value currently on top stack into the stack

After we have reached the end of the string, all that remains next is to add the numbers present right now in the stack.

Ex: 12-8/4*2+2 = 6
[12] lastSign = none . Add currently formed number to the stack.
[12,-8] lastSign = - . Add negative value of next number to stack.
[12, -4] lastSign = /. Here we do -8/4 and add it to top of my stack.
[12, -8] lastSign = *. Here we do -4*2 and add it to top of my stack.
[12, -8, 2] lastSign = +. Here we just add next number to the stack.

Now if we add the elements of stack we get 6.

TC: O(n)
SC: O(n)

where n = length of the string

"""

class Solution:
    def calculate(self, s: str) -> int:
        if s == None or len(s) == 0:
            return 0
        
        stack = []
        num = 0
        answer = 0
        lastSign = "+"
        
        
        for i in range(len(s)):
            c = s[i]
            if c.isdigit():
                num = num * 10 + int(c)
                
            if (not c.isdigit() and c!= ' ') or (i == len(s) - 1):
                if lastSign == "+":
                    stack.append(num)
                elif lastSign == "-":
                    stack.append(num * -1)
                elif lastSign == "*":
                    stack.append(stack.pop() * num)
                elif lastSign == "/":
                    stack.append(int(stack.pop() / num))
                    
                num = 0
                lastSign = c
                
        return sum(stack)
            
        
        
        
        
        
        
        
        