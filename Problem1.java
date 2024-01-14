// Time Complexity : O(1) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :no


class Solution {
    String[] under20 = {""," One"," Two"," Three"," Four"," Five"," Six"," Seven"," Eight"," Nine"," Ten"," Eleven"," Twelve"," Thirteen"," Fourteen"," Fifteen"," Sixteen"," Seventeen"," Eighteen"," Nineteen"};
    String[] tens = {" Twenty"," Thirty"," Forty"," Fifty"," Sixty"," Seventy"," Eighty"," Ninety"};
    String[] triplets = {"","Thousand","Million","Billion"};
    int ptr =0; // ptr for triplets
    public String numberToWords(int num) {
        //edge case
        if(num == 0) return "Zero";    
        String result = "";
        while(num > 0){
            int triplet = num %1000; // getting the first triplet from right
            String str = getWord(triplet); // only if the output is returned we will check otherwise we will move , so that we dont print empty values of triplets
            if(!str.isEmpty()){
                 result = str + " " + triplets[ptr] + result;
            }
           ptr++;
            num = num /1000;// removing the right triplet from number
        }

        return result.trim();
    }
    // It will recieve triplets
    private String getWord(int num){
        String result = "";
        if(num<100){ // for two digit numbers
            int left = num / 10;
            if(num < 20)
            {
            result = under20[num];
            }else{
            result = tens[left-2];
            int right = num % 10; 
            if(right > 0) result = result + under20[right];
            }
            return result;
        }
        // for three digit numbers
        int left = num / 100; 
        result = under20[left] + " Hundred" + getWord(num%100);
        return result;
    }
}