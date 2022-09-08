//SC: o(1);
//TC : o(1);
class Solution {
    //write unique numbers

    String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = {"","Thousand","Million","Billion"};
    
    public String numberToWords(int num) {
        
        
        if(num == 0) return "Zero";
        //index to itertrate over 3 character in nums
        
        //every 3 digit the vaue changes like 
        int i =0;
        //result string
        String result = "";
        //iterate while num is greater than zero
        while(num >0){
            //num %1000 will segregate the triplets process every thriplets with helper function
            if(num %1000 !=0){
                // append the result array with helper funtion
                result = helper(num%1000) +thousands[i] + " "+ result;
            }
            //increment the i
            i++;
            num = num/1000;
                
        }
        
        return result.trim();
        
    }
    private String helper(int num){
        if(num==0) return "";
        //evaluate the three conditions 
        //if num less than 20 then get the value in below_20 array;
        else if(num < 20) return below_20[num] + " ";
        //if num <100 then go to tens array to get the tens value and pass the value to helper to get unit digit;
        else if(num<100) return tens[num/10] + " " + helper(num%10);
        else return below_20[num/100] +" Hundred "+ helper(num%100);
    }
}
