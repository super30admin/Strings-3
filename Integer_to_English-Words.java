// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


//TC : O(1) (since max number 2^31-1 and we run the while loop max 2^31-1/1000 times)
//SP : O(1) (no extra spaced used)

//The numbers are written in set of 3 (words are formed in set of 3 digits)
//The three string are used to fetch the words for a particular number (all words specified)
//to get the thousand/million/billion word, we append it after forming the words for the three numbers
class Solution {
    //declare the Strings
    private String[] oneToNineteen;
    private String[] tens;
    private String[] thousMilBil;
    public String numberToWords(int num) {
        //if number is 0
        if(num == 0) {
            return "Zero";
        }
        //initialize the strings
        oneToNineteen = new String[] {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        tens = new String[] {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        thousMilBil = new String[] {"", "Thousand", "Million", "Billion"};
        
        //index position to keep track of thousMilBil (first for 1-3 numbers, we dont need any string) (0)
        //for 4-6 we need thousand (1)
        //7-9, we need million (2)
        //9-11, we need billion (3)
        //used String array to get the word based on thousMilBilindex
        int thousMilBilindex = 0;
        //result string
        StringBuilder result = new StringBuilder();
        
        //if number is greater than 0
        //find the 3 number triplet 
        //if triplet != 0 (!= 1000, 1000000 etc) 
        while(num > 0) {
            if(num % 1000 != 0) {
                //insert the triplet word to position 0 then add the associated thousMilBil word, 
                //append with " ", if next triplet formed
                //trim used to remove extra tail and front space
                result.insert(0, helperBelow1000(num%1000) + thousMilBil[thousMilBilindex] + " ");
            }
            //get the next triplet at last 3 positions
            num = num/1000;
            //increment thousMilBil to fetch the correct Big word associated 
            thousMilBilindex++;
        }
        
        //convert result to string and trim extra space
        return result.toString().trim();
    }
    
    //helperBelow1000 (to form words from 0-999)
    private String helperBelow1000(int num) {
        //base case : if number is 0 (return empty (no extra space, otherwise we get two extra space))
        if(num == 0) {
            return "";
        }
        //if 0 < num < 20, directly return the num position string append with extra space
        else if(num < 20) {
            return oneToNineteen[num] + " ";
        }
        //if, 21 < num < 100, find the word in tens position and call helper for units digit
        else if(num < 100) {
            return tens[num/10] + " " + helperBelow1000(num%10);
        }
        //if, 100 < num < 1000, find word of Hundreth position, append hundred to it and call helper for tens and unit digit
        else {
            return oneToNineteen[num/100] + " Hundred " + helperBelow1000(num%100);
        }
    }
}