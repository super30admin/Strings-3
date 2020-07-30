// Time Complexity : O(1)
// Space Complexity : O(1) not considering output String
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : none


// Your code here along with comments explaining your approach

class Solution {
    String[] ten = new String[]{"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] below20 = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] thousand = new String[]{"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num==0) return "Zero";
        
        int i=0;
        StringBuilder result = new StringBuilder();
        
        while(num>0){
            StringBuilder temp = new StringBuilder();
            if(num%1000 > 0){
                temp.append(helper(num%1000)).append(thousand[i]).append(" ");
                result.insert(0, temp);
            }
            num = num/1000;
            i++;
        }
        
        return result.toString().trim();
    }
    
    private String helper(int num){
        if(num == 0) return "";
        else if(num<20) return below20[num] + " ";
        else if(num<100) return ten[num/10] + " " + helper(num%10);
        else return below20[num/100] + " Hundred " + helper(num%100);
    }
}