// Time Complexity : O(1)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
public:
    vector<string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
    vector<string> tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    vector<string> array = {"", "Thousand", "Million", "Billion"};
    
    string numberToWords(int num) {
        if(num == 0)
            return "Zero";
        string result = "";
        int i=0;
        while(num>0){
            if(num % 1000 != 0)
                result = helper(num % 1000) + array[i] + " " + result;
            num = num/1000;
            i++;
        }
        //remove(result.begin(), result.end(), ' ');
       return result.erase(result.find_last_not_of(" \t\n\r\f\v") + 1);
    }
    
    string helper(int num){
        if(num == 0)
            return "";
        else if(num < 20)
            return below_20[num] + " ";
        else if(num < 100)
            return tens[num/10] + " " + helper(num % 10);
        else
            return below_20[num / 100] + " Hundred " + helper(num % 100);
    }
};
