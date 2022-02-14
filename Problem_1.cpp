/**
 * Time Complexity:
 * O(N) where N is the number of digits in the number
 * 
 */


/**
 * Space Complexity:
 * O(1)
 */

/**
 * Approach:
 * We will divide the number in three digits like 123,456,789.
 * To convert the digits to english we have to maintain three types
 * of array. First, for numbers below 20 as they can not be used to make
 * another numbers. Second, for numbers below 100 and greater than or equal
 * to 20. Third, for thousands, million and billions. 
 * 
 * Now we take modulus with 1000 of the given number which will give us the
 * last three digits, which we break down further with a helper function
 * to get the values at hundred, tens and ones places.
 * 
 */


//The code ran perfectly on leetcode

class Solution {
        vector<string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven",
                                   "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen",
                                   "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        vector<string> tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        vector<string> thousands = {"", "Thousand", "Million", "Billion"};
public:
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        string result = "";
        int i = 0;
        while(num>0){
            if(num%1000 != 0){
                result = helper(num%1000) + thousands[i] + " " + result;
            }
            num = num/1000;
            i++;
        }
        return result.erase(result.find_last_not_of(" ") + 1);
        
        
        
    }
    private:
    string helper(int num){
        if(num == 0) return "";
        else if (num < 20) return below_20[num] + " ";
        else if (num < 100) return tens[num/10] + " " + helper(num%10);
        else return below_20[num/100] + " Hundred " + helper(num%100);
    }
};