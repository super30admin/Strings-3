//Time: O(1);
//Space: O(1)
//Did it run successfully on leetcode: Yes
class NumberToWords {
    
    
    
    String[] below_20 = {"", "One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = {"", "Thousand","Million", "Billion"};
    
    public String numberToWords(int num) {
        
        if(num==0) return "Zero";
        
        //initializing result string
        String res = "";
        //keeps track of thousands array
        int i = 0;
        
        //until num is not zero
        while(num>0){
            
            //value of last three number not zero
            if(num%1000!=0){
                //get string for last three number
                res = helper(num%1000) + thousands[i] + " " + res;
            }
            //update num
            num = num/1000;
            //update thousand pointer
            i++;
        }
        //remove extra space from the end if exists      
        return res.trim();
    }
    
    public String helper(int num){
        //if value of num is 0
        if(num==0) return "";
        else if(num<20){
            
            return below_20[num] + " ";
        }
        else if(num<100){
            return tens[num/10] + " " + helper(num%10);
        }
        else{
            return below_20[num/100] + " " + "Hundred" + " " + helper(num%100);
        }
    }
}