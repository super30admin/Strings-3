def numberToWords(num: int) -> str:
    if num == 0:
        return "Zero"
    
    def helper(num):
        if num == 0:
            return ""
        elif num < 20:
            return below20[num]
        elif num < 100:
            return tens[num // 10] + (" " + helper(num % 10) if num % 10 != 0 else "")
        else:
            return below20[num // 100] + " Hundred" + (" " + helper(num % 100) if num % 100 != 0 else "")
    
    below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
               "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
               "Seventeen", "Eighteen", "Nineteen"]
    
    tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    
    thousands = ["", "Thousand", "Million", "Billion"]
    
    def processChunk(num, index):
        if num == 0:
            return ""
        return helper(num) + (" " + thousands[index] if thousands[index] else "")
    
    res = ""
    for i in range(len(thousands)):
        if num % 1000 != 0:
            res = processChunk(num % 1000, i) + (" " + res if res else "")
        num //= 1000
    
    return res.strip()


# Time Complexity: O(log n), where n is the input integer.
# Space Complexity: O(log n), where n is the input integer.