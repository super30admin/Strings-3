# Time Complexity :
# O(1) - We will need at max 12 steps for any number in the given range of numbers

# Space Complexity :
# O(1) - Even the stack depth is number of digits at max (12)

# Did this code successfully run on Leetcode :
#Yes

#We process every 3 digits separately. After processing 3 digits, we add the appropriate suffix
#For processung 3 digits, we check if the number is less than 20, then we just return the string corresponding to it
#If it's less than 100, we need to the find the correct 10s and last digit's string
#If it's greater than 100, we process the number in the 100s place and call our function for num%100 (it will behave the same as above case)

class Solution:
    def numberToWords(self, num: int) -> str:
        self.digit_to_english = {0:'',1:'One',2:'Two',3:'Three',4:'Four',5:'Five',6:'Six',7:'Seven',8:'Eight',9:'Nine',
                                10:'Ten',11:'Eleven',12:'Twelve',13:'Thirteen',14:'Fourteen',15:'Fifteen',16:'Sixteen',17:'Seventeen',18:'Eighteen',19:'Nineteen'}
        self.pos_to_english = {0:'',1:{2:'Twenty',3:'Thirty',4:'Forty',5:'Fifty',6:'Sixty',7:'Seventy',8:'Eighty',9:'Ninety'}, 2:'Hundred',3:'Thousand',6:'Million',9:'Billion'}

        return_str = ''
        result_string = ''
        if num == 0 :
            return "Zero"

        i = 0
        while num > 0 :
            triplet = num %1000
            if triplet != 0 :
                curr_str = self.helper(triplet)
                if curr_str[-1] == ' ':
                    result_string = curr_str + self.pos_to_english[i * 3] + " " +  result_string
                else :
                    result_string = curr_str + " " + self.pos_to_english[i * 3] + " " +  result_string
            i += 1
            num = int(num/1000)
        return result_string.strip()

    def helper(self,triplet):
        if triplet < 20 :
            return self.digit_to_english[triplet] 
        if triplet < 100 :
            return self.pos_to_english[1][int(triplet/10)] + " " + self.helper(triplet%10)
        else :
            return self.digit_to_english[int(triplet/100)] + " " +  self.pos_to_english[2] + " "+ self.helper(triplet%100)
