// Time Complexity :O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach

class Solution {
    String[] tens ={"", "One","Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine","Ten", "Eleven", "Twelve", "Thriteen", "Forteen","Fifteen","Sixteen","Seventeen", "Eighteen", "Ninteen"};
        String[] hundreds= {"","", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninty"};
        String[] thousands = {"","Thousand","Million", "Billion"};
        
    public String numberToWords(int num) {
        int i=0;
        StringBuilder sb = new StringBuilder();
        String words = "";
        while(num>0){
           if(num%1000 != 0)
               words = helper(num%1000) + " " +thousands[i] + " "+ words;
            num = num/1000;
            i++;
        }
        return words.trim();
    }
    
    private String helper(int nums){
        //524
        if(nums == 0)
            return "";
        if(nums <20){
            return tens[nums];
        }
        //45
        if(nums<100)
            return hundreds[nums/10] + " " + helper(nums%10);
        
       //524
            return  tens[nums/100]+" Hundred "+ helper(nums%100);
        
    }
}
