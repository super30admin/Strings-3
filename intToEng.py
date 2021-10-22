class Solution:
    def numberToWords(self, num: int) -> str:
        # TC = O(1) => Iterating Finite set of no
        # SC = O(1) => Wont go beyong below20, tens and ths array . In recursion also under hood stack is also finite
        below20 = ["","One","Two", "Three", "Four","Five", "Six","Seven","Eight", "Nine", "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens =["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        ths = ["","Thousand", "Million","Billion"]
        if num == 0:
            return "Zero"
        res = ""
        def helper(num):
            if num == 0:
                return ""
            elif num < 20:
                return below20[num]+ " "
            elif num < 100:
                return tens[int(num/10)] + " " + helper(int(num % 10))
            else:
                return below20[int(num/100)] + " Hundred " +helper(int(num % 100))
        i = 0
        # helper(num)
        while(num > 0):
            modth = int(num % 1000)
            if ( modth!=0):
                res = helper(modth) + ths[i]+ " "+ res
            num = int(num/1000)
            i += 1
        return res.strip()
