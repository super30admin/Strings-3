// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
class Solution {
    
    String[] below20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven","Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] thoudsands= new String[]{"", "Thousand", "Million", "Billion"};
    String[] tens= new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String numberToWords(int num) { 
        if(num==0)
            return "Zero";
        
        int i=0;
        String word ="";
        while(num>0){
            if(num%1000 != 0 ){
                word = helper(num%1000) + thoudsands[i] + " " + word;
            }
            i++;
            num/=1000;
        }
        return word.trim();
    }
    
    public String helper(int num){
        if(num==0){
            return "";
        }else if(num<20){
            return below20[num] + " ";
        }else if(num<100){
            return tens[num/10] + " " + helper(num%10);
        }else if(num<1000){
            return below20[num/100] + " Hundred " + helper(num%100);
        }
        return "";
    }
}