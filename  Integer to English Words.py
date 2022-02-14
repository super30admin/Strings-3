# TC: O(1) --> Three calls for each triplet in helper function and there can be 4 triplet at max
#               which will be called from main function so maximum TC: 4*3
# SC: O(1)


class Solution:
    
    # TC: O(1) --> Three calls for each triplet in helper function and there can be 4 triplet at max
    #               which will be called from main function so maximum TC: 4*3
    # SC: O(1)
    
    belowTwenty = ["","One" ,"Two","Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    
    tens = ["","Ten" ,"Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    
    thousands = ["", "Thousand", "Million", "Billion"]
        
    def numberToWords(self, num: int) -> str: # 234,121,343,543
        
        result = ""
        
        if (num == 0):
            return "Zero"
        
        i = 0 # index on my suffixes(thousands)
        while (num > 0):
            if (num % 1000 != 0): # Using for dealing with spaces
                if (i == 0):
                    result = self.helper(num % 1000) + " " + self.thousands[i] + result
                else:
                    result = self.helper(num % 1000) + " " + self.thousands[i] + " " + result
            num = num//1000
            i += 1
                
        return result[:-1]
        
    def helper(self, num): # 225 Two Hundred Twenty Five --
        
        if (num == 0): return ""
        elif (num < 20): return self.belowTwenty[num]
        elif (num < 100):
            if (num%10 == 0): # Using for dealing with spaces
                return self.tens[num//10] + self.helper(num%10)
            else:
                return self.tens[num//10] + " " + self.helper(num%10)
        else:
            if (num%100 == 0): # Using for dealing with spaces
                return self.belowTwenty[num//100] + " " + "Hundred" + self.helper(num%100)
            else:
                return self.belowTwenty[num//100] + " " + "Hundred" + " " + self.helper(num%100)