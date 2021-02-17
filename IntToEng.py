class Solution:
    
    def helper(self, num):
        if num == 0:
            return ""
        
        if num < 20:
            return (self.below20[num]).rstrip()
        elif num < 100:
            return (self.tens[num // 10] + ' ' + self.helper(num % 10)).rstrip()
        else:
            return (self.below20[num // 100] + ' Hundred ' + self.helper(num % 100)).rstrip()
        
    
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero"
        
        self.below20 = ['', 'One', 'Two', 'Three', 'Four',
           'Five', 'Six', 'Seven', 'Eight', 'Nine',
           'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
           'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']

        self.tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty',
        'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

        self.thousands = ['', 'Thousand', 'Million', 'Billion'] 
        
        result = ''
        i = 0
        
        while num:
            if num % 1000 != 0: #By 1000 to get a triplet
                result = self.helper(num%1000) + " " + self.thousands[i] + " "+ result
            num = num//1000
            i = i + 1
                
         
        
        return result.rstrip()
