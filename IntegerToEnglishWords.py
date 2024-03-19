'''
TC: O(1) - we have fixed number to go over with 0 <= num <= 2^(31) - 1 in triplets
SC: O(1) - We are dealing with fixed space for computation
'''
class Solution:
    def numberToWords(self, num: int) -> str:
        below20 = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"]
        tens = ["","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
        thousands = [""," Thousand "," Million "," Billion "]

        def myNumber(num):
            if num>=100:
                q = num//100
                return below20[q]+" Hundred "+myNumber(num%100)
            elif num>=20:
                q = num//10
                return tens[q]+" "+ myNumber(num%10)
            else:
                return below20[num]
        
        if num == 0:
            return "Zero"
        res = ""
        i=0
        while num!=0:
            q = num//1000
            r = num%1000
            if r!=0:
                res = myNumber(r).strip()+ thousands[i] + res
            i+=1
            num = q
        return res.strip()
s = Solution()
print(s.numberToWords(123))
print(s.numberToWords(12345))
print(s.numberToWords(1234567))
print(s.numberToWords(0))
print(s.numberToWords(20))
print(s.numberToWords(100))
print(s.numberToWords(50868))
print(s.numberToWords(1000000))
