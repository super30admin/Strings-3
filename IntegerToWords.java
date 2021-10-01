
// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach


/*Approach
1) in this question, we need to compute the sum based on concept of triplets
2) we will have 3 determination points
-> 1) less than 20 (to have all the teens)
-> 2) less than 100 (to get the numbers suffix of 100)
-> 3) more than 100 (to get the suffix of 1000)
3) we first check for the numer if its 0 we just return "zero"
4) we take the mod of number by 1000 to get the first triplet
5) if the triplet exists -> remainder is not equal to 0 we need to move ahead
6) result = helper(num % 1000) + thousands[i] + " " + result;
-> we call the helper function to get the number when we divide by 1000 and i is index of thousand array
7) then we divide the number to get the quotient used while dividing by 10000
8) we check if the number is below 20 we just search in the array and provide the o/p
9) if number is <100 then we check the 10's array by using modulus and division operator
10) if output is > 100 then we check the twentys array to get the teens and add a suffix of 100  and continue with the helper function

*/

class IntegerToWords {
    
    //  having a below 20 array to store all the numbers from 0 to 19 (in total 20 numbers)
    
    String below_20[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    // have a tens array to store the tens
    String tensArr[] ={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    // having a thousands array to store the million, billion notations depending on the cycles
    String thousands[] ={"","Thousand","Million","Billion"};
    
    
    
    public String numberToWords(int num) {
        
        if(num==0)
        {
            return "Zero";
        }
        
        int i=0; // iterating over thousands array
        String result="";
        
        while(num>0)
        {
            if((num % 1000) !=0) // remainder is not equal to 0
            {
                result = helper(num % 1000) + thousands[i] + " " + result;
            }
            
            num = num/1000;
            i++;
            
            
        }
        
        return result.trim();
    }
    
    public String helper(int num)
    {
     
        if(num==0)
        {
            return "";
        }
        else if(num<20)
        {
            return below_20[num]+ " ";
            
        }
        else if(num<100)
        {
            return tensArr[num/10] +" "+helper(num % 10);
        }
        else // when number is >100
        {
            return below_20[num/100] + " Hundred " + helper(num%100);
        }
            
        
        
    }
    
}