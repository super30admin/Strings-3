# Strings-3

## Problem1 
 Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)
 
# Time Complexity = O(N)
# Space Complexity = O(1)

 class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0:
            return 'Zero'
        tens=['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        below20=['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        suf=['','Thousand ','Million ','Billion ']
        def helper(num):
            if num==0:
                return ''
            if num<20:
                return below20[num]+' '
            elif num<100:
                return tens[num//10]+' '+helper(num%10)
            
            else:
                return below20[num//100]+' Hundred '+helper(num%100)
        
        place=0
        res=''
        while num>0:
            if num%1000!=0:
                res=helper(num%1000)+suf[place]+res
            num=num//1000
            place+=1
        return res[:-1]
            
            
            
## Problem2 

# Time Complexity = O(N)
# Space Complexity = O(n) 

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

class Solution:
    def calculate(self, s: str) -> int:
        sta=[]
        num=0
        last='+'
        for i in range(len(s)):
            if s[i].isnumeric():
                num=num*10+int(s[i])
            if s[i]=='*' or s[i]=='/' or s[i]=='+' or s[i]=='-' or i==len(s)-1:
                if last=='+':
                    sta.append(num)
                elif last=='-':
                    sta.append(num*-1)
                elif last=='*':
                    sta.append(sta.pop()*num)
                elif last=='/':
                    a=sta.pop()
                    if a<0:
                        b=abs(a)//num
                        b=b*-1
                        sta.append(b)
                    else:
                        sta.append(a//num)
                num=0
                last=s[i]
        num=0       
        while len(sta)!=0:
            num=num+sta.pop()
        return num
                    
                
        


