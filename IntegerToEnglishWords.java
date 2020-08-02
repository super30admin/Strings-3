

//Time Complexity : O(N)
//Space Complexity : O(1)
// Did it run on leet code : yes
class Solution {
    String[] ones; 
    String[] tens; 
    String[] thousands;
    public String numberToWords(int num) {
        
         ones = new String[]{" ","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
                       "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen"
                        ,"Eighteen","Nineteen"};
          
        tens = new String[]{"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty"
                        ,"Ninety","Hundered"};
        thousands  = new String[]{"","Thousand","Million","Billion"};
        
        if(num == 0)
            return "Zero";
        int index = 0 ;
        String result ="";
       
            
        while(num > 0){
   
            if(num % 1000!=0){
                result =  helper(num%1000)+ thousands[index] +" "+ result;
            }
            num = num/1000;
            index++;   
            
        }
        return result.trim();
        
    }
    
    
    private String helper(int num){
        
        if(num == 0)
            return "";
        else if(num < 20){
            
            return ones[num] + " ";
        }
        else if(num < 100)
        {
            return tens[num/10] + " " + helper(num%10);
        }
        else{
            
            return ones[num/100] + " Hundred "+ helper(num%100);
        }
        
    }
}