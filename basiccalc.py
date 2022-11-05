'''
Time Complexity: O(N)
Space Complexity: O(N)
'''
class Solution:
    def calculate(self, s: str) -> int:
        s = s+"#"
        operator = "+"
        nums = 0
        tail = 0
        calc = 0
        for i in s:
            if(i.isdigit()):
                nums = nums*10 + int(i)
            elif(i in ["+","-","*","/","#"]):
                if(operator=="+"):
                    calc = calc+nums
                    tail = nums
                elif(operator=="-"):
                    calc = calc-nums
                    tail = -nums
                elif(operator=="*"):
                    calc = (calc-tail)+(tail*nums)
                    tail = (tail*nums)
                elif(operator=="/"):
                    calc = (calc-tail)+(int(tail/nums))
                    tail = int(tail/nums)
                nums = 0
                operator = i
            # print(operator)
            # print(nums)
            # print(tail)
            # print(calc)
            # print("_________________")
        return calc
                    
                    
                
        