'''
TC: O(n)
SC: O(1)
'''
class Solution(object):
    def numberToWords(self, num):
        """
        :type num: int
        :rtype: str
        """
        
        hmap = {
            0 : "zero",
            1 : "one",
            2 : "two",
            3 : "three",
            4 : "four",
            5 : "five",
            6 : "six",
            7 : "seven",
            8 : "eight",
            9 : "nine",
            10 : "ten",
            11 : "eleven",
            12 : "twelve",
            13 : "thirteen",
            14 : "fourteen",
            15 : "fifteen",
            16 : "sixteen",
            17 : "seventeen",
            18 : "eighteen",
            19 : "nineteen",
            20 : "twenty",
            30 : "thirty",
            40 : "forty",
            50 : "fifty",
            60 : "sixty",
            70 : "seventy",
            80 : "eighty",
            90 : "ninety"
        }
        
        for i in hmap:
            hmap[i] = hmap[i].capitalize()
        
        def ntoh(n):
            if (n / 10) == 0:
                if n % 10 == 0:
                    return ""
                return hmap[n]
            words = ""
            
            if (n % 100) < 10 and (n % 100) > 0:
                words = hmap[n%10]
            elif (n % 100) > 0:
                if (n%100) <= 20:
                    words = hmap[n%100]
                else:
                    newn = n % 100
                    # print((n/10)*10, n%10)
                    words += hmap[(newn/10)*10] + (" " + hmap[newn%10] if (newn%10) > 0 else "")
            n /= 100   
            if n > 0:
                words = hmap[n] + " Hundred" + (" " + words if words != "" else "")
            return words
        
        # print(ntoh(1), ntoh(12), ntoh(21), ntoh(44), ntoh(88))
        
        final = ""
        next = ""
        bignums = ["", "Thousand", "Million", "Billion"]
        i = 0
        rem = 0
        
        while num:
            next = bignums[i]
            rem = num % 1000
            num = num / 1000
            next_final = ntoh(rem)
            if next_final != "":
                final = next_final + (" " + next if next != "" else "") + (" " + final if final != "" else "")
            i += 1
            
        if final == "" and rem == 0 and num == 0:
            return "Zero"
        
        return final