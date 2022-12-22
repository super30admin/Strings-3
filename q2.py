# Time Complexity : O(n), Where n is number of characters in string s
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : Nothing specific

class Solution:
    def calculate(self, s: str) -> int:
        res=0
        last_sign="+"
        tail=0
        num=0
        for i in s:
            if(i == " "):
                #When it is space
                continue
            if(i.isdigit()):
                #When it is number
                num=num*10+int(i)
            else:
                #When it is operator
                if(last_sign=="+"):
                    res=res+num    
                    tail=+num
                    
                if(last_sign=="-"):
                    res=res-num
                    tail=-num
                    
                if(last_sign=="*"):
                    res=res-tail+(tail*num)
                    tail=tail*num
                if(last_sign=="/"):
                    res=res-tail+(int(tail/num))
                    tail=int(tail/num)
                    
                num=0
                last_sign=i
        #print(last_sign)
        #print(tail)
        #print(num)
        #print(res)
        #Once we reach the end we need do the final calculation
        if(last_sign=="+"):
            res=res+num    
            tail=+num
                    
        if(last_sign=="-"):
            res=res-num
            tail=-num
                    
        if(last_sign=="*"):
            res=res-tail+(tail*num)
            tail=tail*num
        
        if(last_sign=="/"):
            res=res-tail+(int(tail/num))
            tail=int(tail/num)
        #print(res)
        return res
        