class Solution:
    ones = ["", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten "]
    
    ninteen = ["Twenty ", "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen ", "Twenty "]
    
    tens = [" ", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety ", "Hundred "]
    
    thousands = [" ", "Thousand ", "Million ", "Billion "]
    
    def helper(self, x):
        
        h = x // 100
        r = x % 100
        result = ""
        
        if h != 0:
            result = result + self.ones[h] + "Hundred "
        
        #print(r)
        if r <= 20:
            if r >= 0 and r <= 10:
                result = result + self.ones[r]
            
            elif r >= 11 and r <= 20:
                result = result + self.ninteen[r % 10]
        else:
            t = r // 10
            new_r = r % 10
            
            #print(t, new_r)
            result = result + self.tens[t]
            result = result + self.ones[new_r]
        #print(result)
        return result
        
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        temp_list = []
        result = ""
        while num > 0:
            temp_list.append(num % 1000)
            num = num // 1000
        
        print(temp_list)
        while len(temp_list) > 0:
            i = temp_list.pop()
            a = self.helper(i)
            #print(a)
            if a!= "":
                result = result + a + self.thousands[len(temp_list)]
            #print(result)
        #print(result)
        #self.helper(570)
        return result.strip()
