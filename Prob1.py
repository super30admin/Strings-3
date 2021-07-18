class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        #Time: O(1)
        #Space: O(1)
        less20 =['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen','Twenty']
        tensLi = ['','Ten','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        thousandsLi = ['','Thousand','Million','Billion']
        # we are looking at triplets and handling them using the helper function. for rest of the cases, we are looking up in the while loop
        if num == 0:
            return 'Zero'
        def helper(num):
            if num==0:
                return ''
            elif num<20:
                return less20[num] + ' '
            elif num<100:
                return tensLi[num/10] + ' '+ helper(num%10)
            else:
                return less20[num/100] + " Hundred " + helper(num%100)
            
            
            
        res = ''
        i = 0 # parse through thousands array char by char
        while num>0:
            if num%1000!=0:
                res = helper(num%1000) + thousandsLi[i] + ' ' + res
            num = num/1000
            i += 1
        return res.strip()
        
