#integer to english words


# // Time Complexity :  O(1) - as we are always splitting the numbers into 1000s, so max we'll run 3 times
# // Space Complexity : O(1)
# // Did this code successfully run on Leetcode :yes
# // Any problem you faced while coding this :no

def numberToWords(self, num: int) -> str:
    if num==0:
        return "Zero"
    below_20 = [ " ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
    tens = 'Twenty Thirty Forty Fifty Sixty Seventy Eighty Ninety'.split()
    thousand = 'Thousand Million Billion'.split()
    def word(num, idx):
        if num == 0:
            return []
        if num < 20:                                    #if below 20, just return from the list
            return [below_20[num]]
        if num < 100:                                   #if below 100, just return from the tens list and recurse again
            return [tens[num//10-2]] + word(num%10, idx)
        if num < 1000:                                      #if below 1000, just return from the below 20 and hundred+ recurse again
            return [below_20[num//100]] + ['Hundred'] + word(num%100,idx)

        p= num//1000
        r = num%1000
        if p % 1000 !=0:                                #if divisible by 1000, then add the specific word
            mid = [thousand[idx]]       
        else:
            mid=[]
        return  word(p, idx+1) + mid + word(r, idx)             
    return ' '.join(word(num,0))