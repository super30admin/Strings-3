class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        ones = ['','One','Two','Three','Four','Five','Six','Seven','Eight','Nine','Ten','Eleven','Twelve','Thirteen','Fourteen','Fifteen','Sixteen','Seventeen','Eighteen','Nineteen']
        tens= ['','','Twenty','Thirty','Forty','Fifty','Sixty','Seventy','Eighty','Ninety']
        thousands = ['', 'Thousand','Million','Billion']
        
        def recur(temp):
            if temp==0:
                return '';
            elif temp<20:
                return ones[temp] + ' '
            elif temp<100:
                return tens[temp/10] +' ' + recur(temp%10)
            else:
                return ones[temp/100] +' Hundred ' + recur(temp%100)


        idx = 0
        word = ''
        if num==0:
            return 'Zero'
        while num>0:
            if num%1000!=0:
                word = recur(num%1000)+thousands[idx] +' '+ word
            num=num/1000
            idx+=1
            word = word.strip()
        return word