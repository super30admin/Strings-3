'''
time complexity: O(n)
space complexity: O(n)
'''
class Solution:
    def calculate(self, s: str) -> int:
        s= s.strip()
        lastSign = "+"
        curr = 0
        stack = []
        for i in range(len(s)):
            if(s[i].isdigit()):
                print(s[i])
                curr = curr*10+int(s[i])
            if(s[i]!=' ' and ( s[i].isdigit()!=True or i==len(s)-1)):
                if(lastSign=="+"):
                    print("===",curr)
                    stack.append(curr)
                elif(lastSign=="-"):
                    stack.append(-curr)
                elif(lastSign=="*"):
                    stack.append(stack.pop()*curr)
                elif(lastSign=="/"):
                    print(curr)
                    print(stack[-1])
                    stack.append(int((stack.pop())/(curr)))
                curr = 0
                lastSign = s[i]
        ans = 0  
        while(len(stack)!=0):
            print(stack[-1])
            ans+=stack.pop()
        return ans