'''
if prevSign = *
    1. currentSum = (currentSum-tail) + (tail*currentSum)
    2. tail = tail*currentSum

if prevSign = /
    1. currentSum = (currentSum-tail) + (tail/currentSum)
    2. tail = tail/currentSum

'''

'''
Time Complexity: 0(n)
Space Complexity : 0(1)
Run on leetcode: Yes
'''
class Solution:
    def sumAndOperand(self,arr,index=0):

            # 1. initialize 'currentVal','prevOperand','calculatedValue','tail'
            currentVal = 0
            prevOperand = '+'
            calc = 0
            tail = 0

            # 2. initialize the 'result' stack
            """no need for stack"""

            # 3. iterate the arr
            while index != len(arr):
                
                # base-case: chk for space
                if arr[index].isspace():
                    # do-nothing
                    pass

                # case-1 not an operand
                elif ord(arr[index]) != ord('+') and ord(arr[index]) != ord('-') and ord(arr[index])!= ord('*') and ord(arr[index]) != ord('/'):

                    # get num 
                    num = ord(arr[index])-ord('0') #eg:--ascii('1')-ascii('0')
                    currentVal = (currentVal*10)+num
                    '''no changes to the prevOperand'''

                # case-2 is an operand
                else:

                    # case-2.1. is + operand
                    if prevOperand == "+":
                        calc = calc+currentVal
                        tail = currentVal
                        
                    # case-2.2. is - operand
                    elif prevOperand == "-":
                        calc = calc-currentVal
                        tail = -1*currentVal

                    # case-2.3. is * operand
                    elif prevOperand == "*":
                        calc = (calc-tail) + (tail*currentVal)
                        tail = (tail*currentVal)

                    # case-2.4. is / operand
                    elif prevOperand == "/":
                        print(f"calc {calc} \t curr")
                        calc = (calc-tail) + int(tail/currentVal)
                        tail = int(tail/currentVal)

                    # set currentVal to 0
                    currentVal = 0
                    # make changes to the operand as well
                    prevOperand = arr[index]
                
                # update the index
                index+=1

            '''end of while loop'''

            # last minute take-care
            if prevOperand == "+":
                calc = calc+currentVal
                tail = currentVal

            elif prevOperand == "-":
                calc = calc-currentVal
                tail = -1*currentVal

            elif prevOperand == "*":
                calc = (calc-tail) + (tail*currentVal)
                tail = (tail*currentVal)

            elif prevOperand == "/":
                calc = (calc-tail) + int(tail/currentVal)
                tail = int(tail/currentVal)
            
            currentVal = 0
            
            # return the stack
            #print("Result is:\t",result)

            return calc
    
    def calculate(self, s: str) -> int:

            output = self.sumAndOperand(s)
            return output