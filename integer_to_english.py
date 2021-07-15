# Time Complexity: O(n)
# Space Complexity: O(1)
class Solution:
    lessThanTwenty = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven",
                      "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    less_than_hundred = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
    greater_than_hundred = ["", "Thousand", "Million", "Billion"]

    # In helper function, we will chekc these 3 cases and accordingly we will get its corresponding letter from the defined array and call function recursively for further number
    def getValue(self, num):
        if num == 0:
            return ""
        elif num < 20:
            return self.lessThanTwenty[num] + " "
        elif num < 100:
            return self.less_than_hundred[int(num // 10)] + " " + self.getValue(int(num % 10))
        else:
            return self.lessThanTwenty[int(num // 100)] + " Hundred " + self.getValue(int(num % 100))

    #   CHeck the num in 3 ranges
    #  if less than 20
    #  if less than 100
    #  if greater than 100
    # We will take mod of numbber with 1000 and we wil call helper function for getting correct translation i.e. we divide the number in three words and we will iterate over case 3 array after each iteration

    def numberToWords(self, num):
        if num == 0:
            return "Zero"
        i = 0
        result = ""

        while num > 0:
            if int(num % 1000) != 0:
                result = self.getValue(int(num % 1000)) + self.greater_than_hundred[i] + " " + result
            num = int(num // 1000)
            i += 1
        return result.strip()


