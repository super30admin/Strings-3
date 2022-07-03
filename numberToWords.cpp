// Time Complexity : O(n) where n < 2^31 - 1  
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes

// Three line explanation of solution in plain english
/* Process the numbers in the triplets. While processing triplets handle 3 cases :- 
 *      a) Number is less than 20
 *      b) Number is less than 100
 *      c) Number is greater than or equal to hundred.
 * Append the Thousand, Million or billion to triplets based on index of triplets.
 */
class Solution {
    vector<string> thousands = {"", "Thousand", "Million", "Billion"};
    vector<string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
                              "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen",
                               "Eighteen", "Nineteen"};
    vector<string> below_100 = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
public:
    string numberToWords(int num) {
        if (num == 0)
            return "Zero";
        
        int i = 0;
        string result = "";
        
        while (num > 0)
        {
            if (num % 1000 != 0)
            {
                string temp_string = helper(num % 1000); 
                rtrim(temp_string);
                result = temp_string + " " + thousands[i] + " " + result;
            }
           
            num = num / 1000;
            i++;
        }
        
        rtrim(result);
        return result;
    }
    
    string helper(int num)
    {
        if (num < 20)
            return below_20[num];
        if (num < 100)
            return below_100[num / 10] + " " + helper(num % 10);
        return helper(num / 100) + " Hundred " + helper(num % 100);
    }
    
    inline void rtrim(std::string &s) {
        s.erase(std::find_if(s.rbegin(), s.rend(), [](unsigned char ch) {
            return !std::isspace(ch);
        }).base(), s.end());
    }
};