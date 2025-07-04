# Time complexity - o(n)
# Space complexity - o(1)

class Solution:
    def numberToWords(self, num: int) -> str:
        
        below20 = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        hundreds = ['','Thousand','Million','Billion']
        below100 = ['','','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']

        res = ''
        if num == 0:
            return 'Zero'

        def helper(curr):
            if curr <20:
                return below20[curr]
            elif curr<100:
                return below100[curr//10] + ' ' + helper(curr%10)
            else:
                return below20[curr//100] +' Hundred '+ helper(curr%100)

        i = 0
        while num>0:
            triplet = num%1000
            if triplet !=0:
                res = helper(triplet).strip() + ' ' +hundreds[i] + ' '+ res
            i+=1
            num//=1000
        

        return res.strip() 





