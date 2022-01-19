# Leetoce Execution: YES
# Space Complxity: O(1)
# Time Complexity: O(n)
class Solution:
    def numberToWords(self, num: int) -> str:
        if num==0: 
            return "Zero"
        # we have text string  for the places, once and tens
        places=["","Thousand","Million","Billion"]
        once = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
        tens = ["", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
        n=num
        re=""
        counter=0
        # we loop through the number given we do %1000 every time and opearte on the those numbers 
        # we do //1000 to move forward in the loop and keep a counter to know where we are in the number lets say we have number as 123456
        # now we computer 456 as normal like check hundreads check tens adn then check onces
        # we do this for all the  combinations
        # since counter is 0 we happen to get nothing from places 
        # for next set 123 we get one hungread and twenty three but now the counter is 1 so we get thousand from places.
        
        while(n>0):
            three=n%1000
            n=n//1000
            s=""
            two=three%100
            if two<20:
                s=f" {once[two]}"
            else:
                ten=tens[two//10]
                one=once[two%10]
                s=f" {ten} {one}"
            s=s.rstrip()
            if three>=100:
                s=f" {once[three//100]} Hundred"+s
            if s!="":
                s=s+f" {places[counter]}"
            re=s+re
            counter+=1
        re=re.strip()
        return re
                
            