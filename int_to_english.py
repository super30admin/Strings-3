"""
Approach:
- Use recursion to convert numbers into English words.
- Divide the number in groups of 3 digits (thousands).
- For each group, convert using a helper function:
    - If < 20 → direct map
    - If < 100 → tens + units
    - If ≥ 100 → hundreds + remaining
- Append appropriate scale: '', 'Thousand', 'Million', 'Billion'
- Trim and join the results.

Time Complexity: O(log₁₀(n)) → At most ~4 segments for billions (since each step processes 3 digits)
Space Complexity: O(1) → Constant extra space (excluding output string)
"""
class Solution:
    ones = ["","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"]
    tens = ["", "Ten","Twenty","Thirty", "Forty","Fifty","Sixty","Seventy","Eighty","Ninety"]
    thousands = ["","Thousand","Million","Billion"]
    def numberToWords(self, num: int) -> str:
        if num == 0:
            return "Zero" 
        word = ""
        i = 0
        while num > 0:
            if num%1000 != 0:
                word = self.helper(num%1000) + self.thousands[i] + " " + word
            i += 1
            num = num//1000
        return word.strip()

    def helper(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.ones[num] + " "
        elif num < 100:
            return self.tens[num//10] + " " + self.helper(num%10)
        else:
            return self.ones[num//100]+" Hundred " + self.helper(num%100)

def main():
    sol = Solution()
    test_cases = [
        (0, "Zero"),
        (5, "Five"),
        (13, "Thirteen"),
        (100, "One Hundred"),
        (123, "One Hundred Twenty Three"),
        (12345, "Twelve Thousand Three Hundred Forty Five"),
        (1234567, "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"),
        (1000010, "One Million Ten"),
        (1000000000, "One Billion"),
    ]
    
    for num, expected in test_cases:
        result = sol.numberToWords(num)
        print(f"Input: {num} => Output: '{result}' | Expected: '{expected}' | {'PASS' if result == expected else 'FAIL'}")


if __name__ == "__main__":
    main()