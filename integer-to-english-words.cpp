// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

#include <iostream>
#include <string>
#include <vector>

class IntegertoEnglishWords {
private:
    std::vector<std::string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    std::vector<std::string> hundreds = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    std::vector<std::string> thousands = {"", "Thousand", "Million", "Billion"};

public:
    std::string numberToWords(int num) {
        if (num == 0)
            return "Zero";

        std::string word = "";
        int i = 0;

        while (num > 0) {
            if (num % 1000 != 0)
                word = helper(num % 1000) + thousands[i] + " " + word;

            num /= 1000;
            i++;
        }

        return word;
    }

    std::string helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return below_20[num % 20] + " ";
        else if (num < 100)
            return hundreds[num / 10] + " " + helper(num % 10);
        else
            return below_20[num / 100] + " Hundred " + helper(num % 100);
    }
};