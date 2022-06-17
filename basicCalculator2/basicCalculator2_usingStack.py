'''
Time Complexity: 0(n)
Space Complexity : 0(n) --> stack
Run on leetcode: Yes
'''

class Solution:
    
    def sumAndOperand(self,arr,index):
        
        # 1. initialize 'currentVal' and 'prevOperand'
        currentVal = 0
        prevOperand = '+'
        
        # 2. initialize the 'result' stack
        result = []
        
        # 3. iterate the arr
        while index != len(arr):
            print("\n")
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
                    # inStack(+currentVal) and update prevOperand
                    result.append(currentVal)
                
                # case-2.2. is - operand
                elif prevOperand == "-":
                    # inStack(-currentVal) and update prevOperand
                    result.append(-1*currentVal)
                
                # case-2.3. is * operand
                elif prevOperand == "*":
                    '''
                    1. Pop from the 'result' and set to 'top'
                    2. Multiply (top*currentVal)
                    3. Push the product into 'result'
                    4. Update the prevOperand
                    5. Set 'currentVal' to 0 (default)
                    '''
                    top = result.pop()
                    result.append((top*currentVal))
                
                # case-2.4. is / operand
                elif prevOperand == "/":
                    '''
                    1. Pop from the 'result' and set to 'top'
                    2. Multiply (top/currentVal)
                    3. Push the division into 'result'
                    4. Update the prevOperand
                    5. Set 'currentVal' to 0 (default)
                    '''
                    top = result.pop()
                    result.append(int(top/currentVal))
                
                # reset currentVal
                #print(f"Result is {result}")
                currentVal = 0
                prevOperand = arr[index]
                
            # update the index
            index+=1
            
        '''end of while loop'''
        
        # last minute take-care
        if prevOperand == "+":
            result.append(currentVal)
        
        elif prevOperand == "-":
            result.append(-1*currentVal)
        
        elif prevOperand == "*":
            top = result.pop()
            result.append((top*currentVal))
        
        elif prevOperand == "/":
            top = result.pop()
            result.append(int(top/currentVal))
            
        # return the stack
        #print("Result is:\t",result)
        
        return result
    
    def calculate(self, s: str) -> int:
        
        output = 0
        resultStack = self.sumAndOperand(s,0)
        
        # iterate the resultStack and return the output
        while len(resultStack)!= 0:
            output += resultStack.pop()
        
        return output