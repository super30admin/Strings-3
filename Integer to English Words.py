class Solution:
    def numberToWords(self, num: int) -> str:
        #Time Complexity: O(1)  // max len of num is constant
        #Space Complexity: O(1)
        if num == 0:
            return 'Zero'
        
        result = ''
        i = 0
        while num:
            if num % 1000 != 0:
                result = self.helper(num % 1000) + ' ' + thousands[i] + ' ' + result
            num //= 1000
            i += 1
            
        return result.rstrip()
    
    def helper(self, num):
        if num < 20:
            return (below20[num]).rstrip()
        elif num < 100:
            return (tens[num // 10] + ' ' + self.helper(num % 10)).rstrip()
        else:
            return (below20[num // 100] + ' Hundred ' + self.helper(num % 100)).rstrip()
        
below20 = ['', 'One', 'Two', 'Three', 'Four',
           'Five', 'Six', 'Seven', 'Eight', 'Nine',
           'Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen',
           'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
        
tens = ['', 'Ten', 'Twenty', 'Thirty', 'Forty',
        'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

thousands = ['', 'Thousand', 'Million', 'Billion']