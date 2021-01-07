"""
Approach:

At first if we observe entire number can be broken down into different number of triplets. Each triplet has its own value.

ex: 7,123,456,789

123: One hundred twenty three (million)
456: Four hundred fifty six  (thousand)
789: Seven hundred eighty nine

So we need to process string value of each individual triplet
Now these triplets have four cases:
1) Number is 0
2) Number is < 20
3) Number is between 20-99 inclusive
4) NUmber > 99

So at first we need to maintain three arrays for 3 of the above cases. 

Now we continuosly do n%1000 for last three digits and n/1000 to get remaining digits.
In n%1000 all the digits will be processed one by one according to the above cases.
So we will process the every triplet and concate their result to each other.

If we take above example, we first process 789-> Seven hundred eighty nine
then 456: Four hundred fifty six  (thousand). We add thousand because its our second triplet
123: One hundred twenty three (million). We add million because its our third triplet
We add billion its our 4th triplet if present

TC: O(n) or O(1)
SC: O(1)

TC can also be O(1) because overall its just one number we are processing
SC is O(1) because our all of our space even our recursive stack space are constant
"""

class Solution:
    def numberToWords(self, num: int) -> str:
        self.below20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"] # below 20  
    
        self.tens = ["", "Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"] # 20-99
        self.thousands = ["", "Thousand","Million", "Billion"]
        
        if num == 0:
            return "Zero"
        
        result = ""
        i = 0
        
        # n/3 times
        while num > 0:
            if num % 1000 > 0:
                result = self.helper(num%1000) + self.thousands[i] + " " + result # 3 times
                
            num = int(num / 1000)
            i += 1
        
        return result.strip()
            
    def helper(self, num):
        if num == 0:
            return ""
        
        elif num < 20:
            return self.below20[num] + " "
        
        elif num < 100:
            return self.tens[int(num / 10)] + " " + self.helper(num % 10)
        
        else:
            return self.below20[int(num / 100)] + " Hundred " + self.helper(num % 100)