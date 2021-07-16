class Solution:
    def __init__(self):
        self.below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",                                      "Thirteen","Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]

        self.tens = ["","","Twenty","Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

        self.thousands = ["", "Thousand", "Million", "Billion"]
        
    
    def numberToWords(self, num: int) -> str:
        # d1={1:'one', 2:'two',3:'three',4:'four', 5:'five', 6:'six', 7:'seven', 8:'eight', 9:'nine',10:'ten'}
        # d2 ={11:'eleven', 12:'twelve',13:'thirteen',14:'forteen', 15:'fifteen', 16:'sixteen', 17:'seventeen', 18:'eighteen', 19:'nineteen'}
        # d3={20:'twenty', 30:'thirty', 40:'forty', 50:'fifty',60:'sixty',70:'seventy',80:'eighty', 90:'ninety',100:'hundred'}
        
        
        """
        keyIdea : 
        Get triplets ---> suppose 521,890,231 ---> first decipher 231, then 890 + earlier res, then 521 + earlier res
        num<20 -----> return below_20[num] //13
        num<100 -----> return tens[num/10] + " " + helper(num%10)
        num>100 -----> return below_20[num/100] + "Hundred" + helper(num%100)

        and then take next triplets
        
        TC:O(num of triplets)=O(const)
        SC: O(const), max size of recursive stack
        """
    
        if num==0: return "Zero"
        
        # 121,455,543
        
        res=""
        # index on thousand array to get suffix
        i=0
        while num>0:
            if num % 1000 !=0:
                res=self.helper(num%1000) + self.thousands[i]  + " " + res
                # print(res)
            num=num//1000 # 121,455
            i=i+1
        # just to create spaces.. not necessary though
        # word = re.split('(?=[A-Z])', res)
        # wordd=""
        # for w in word:
        #     wordd=wordd+w+" "
        
        # strip to remove extra space at the ends
        return res.strip()
    
    def helper(self, num):
        if num==0:
            return " "
        elif num<20:
            return self.below_20[num] + " "
        elif num<100:
            return self.tens[num//10]  +" "+ self.helper(num%10)
        elif num>=100:
            return self.below_20[num//100] + " Hundred " + self.helper(num%100)
        
        