// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


class Solution {
    String[] below20 = {"", " One", " Two", " Three", " Four", " Five", " Six", " Seven", " Eight", " Nine", " Ten", " Eleven", " Twelve", " Thirteen", " Fourteen", " Fifteen", " Sixteen", " Seventeen", " Eighteen", " Nineteen"};
    
    String[] tens = {""," Ten"," Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"," Hundred"};
    
    String[] thousands = {" "," Thousand"," Million"," Billion"};
    
    public String numberToWords(int num) {
        String result = "";
        
        if(num==0)
            return "Zero";
        
        int i=0;
        while(num > 0) {
            int rem = num%1000;
            if(rem!=0)
                result = convertToEnglish(rem) + thousands[i] + result;
            num = num/1000;
            i++;
        }
        
        return result.trim();
    }
    
    private String convertToEnglish(int num) {
        //System.out.println(num);
        if(num<20)
            return below20[num%20];
        else if(num<100)
            return tens[num/10] + convertToEnglish(num%10);
        else
            return below20[num/100] + " Hundred" + convertToEnglish(num%100);
    
    }
}
