# Time Complexity : O(n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution:
    def numberToWords(self, num: int) -> str:
        
        lessthan20 =['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen','Twenty']
        tensLi = ['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        thousandsLi = ['','Thousand','Million','Billion']
        
        if num == 0:
            return 'Zero'
            
        def helper(num):
            if num==0:
                return ''
            elif num<20:
                return lessthan20[num] + ' '
            elif num<100:
                return tensLi[num//10] + ' '+ helper(num%10)
            else:
                return lessthan20[num//100] + " Hundred " + helper(num%100)



        res = ''
        i = 0 
        while num>0:
            if num%1000!=0:
                res = helper(num%1000) + thousandsLi[i] + ' ' + res
            num = num//1000
            i += 1
        return res.strip()
