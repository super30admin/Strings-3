"""
TC: O(1) only 4 triplets
Sc: O(n) considering the recusrive stack

"""

class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0:
            return "Zero"
        thousands=["", "Thousand", "Million", "Billion"]
        i=0
        result=""
        while num > 0:
                mod=num%1000
                if num%1000>0:
                    result=self.helper(mod)+ thousands[i] + " "+ result
                i+=1
                num=num//1000

        print(result)
        return result.strip(" ")

    def helper (self, tripletnumber):
        belowTwenty=["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen", "Twenty"]
        twenty=["Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]
        """in this helper function we will be checking if the string is
        0 -> " "
        1-19 -> refer belowtwenty array
        20-99-> twenty[]+ helper(num%10) 
        100-999-> helper(num/100)+ " hundred "+ helper(num%100)
        """
        print(tripletnumber)
        if tripletnumber==0:
            print("inside")
            return ""
        elif tripletnumber<=19:
            return belowTwenty[tripletnumber] + " "
        elif tripletnumber<=99:
            return twenty[(tripletnumber//10)-2] + " "+ self.helper(tripletnumber%10)
        elif tripletnumber<=999:
            return self.helper(tripletnumber//100) + "Hundred " + self.helper(tripletnumber%100)









