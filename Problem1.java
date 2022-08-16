//Time Complexity: O(1)
//Space Complexity: O(1)
//Code run successfully on LeetCode.

public class Problem1 {

    String[] thousands = {"", "Thousand", "Million", "Billion"};
    String[] below_20 = {"", "One", "Two","Three","Four","Five","Six",
                         "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve",
                         "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                         "Eighteen", "Nineteen"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", 
                     "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        
        if(num == 0)
            return "Zero";
        
        String result = "";
        int i = 0;
        
        while(num > 0){
            
            if(num%1000 != 0)
            {
                result = helper(num%1000) +" "+ thousands[i]  + " " + result;
            }
            
            num = num/1000;
            i++;
        }
        return result.trim();
    }
    
    private String helper(int num){
        
        if(num == 0)
            return "";
        
        else if(num < 20)
            return below_20[num];
        
        else if(num < 100){
            
            String result = tens[num/10]  + " " + below_20[num%10];
            return result.trim();
        }
        
        else{
            
            String result = below_20[num/100] + " " + "Hundred" + " " + helper(num%100);
            return result.trim();
        }
    }
}
