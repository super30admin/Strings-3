// Time Complexity : O(n) 
// Space Complexity : O(1); 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 1. Create arrays of elements below 20, all tens and all thousands. Process elements in groups of 3
// 2. Create a function which gives english word for a 3 digit number and call it recursively for groups of 3 of original number
// 3. Remove whitespaces from the end and return the string

class Solution {
public:
    vector<string> below20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    
    vector<string> tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    vector<string> thousands = {"", "Thousand", "Million", "Billion"};
    
    string numberToWords(int num) {
        if(num==0)
            return "Zero";
        string result; int i=0;
        while(num>0){
            if(num%1000 != 0){ // 12345
                result = helper(num%1000) + thousands[i] + " " + result;
            }
            i++; 
            num/=1000;
        }
        i = result.size()-1;
        char c = result[i];
        while(isspace(c)){
            result.pop_back();
            i = result.size()-1;
            c = result[i];       
        }
            
        return result;
    }
    
    string helper(int num){
        if(num==0)
            return "";
        if(num<20)
            return below20[num] + " ";
        if(num<100) // 43
            return tens[num/10] + " " + helper(num%10);
        else // 543
            return below20[num/100] + " Hundred " + helper(num%100);
        return "";
    }
};