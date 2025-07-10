#include<iostream>
#include<vector>
using namespace std;
#include <iostream>
#include <vector>
#include <string>
using namespace std;
class Solution {
public:
    vector<string> thousands = {"", "Thousand", "Million", "Billion"};
    vector<string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", 
                               "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
                               "Seventeen", "Eighteen", "Nineteen"};
    vector<string> tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    string numberToWords(int num) {
        if (num == 0) return "Zero";
        string ans = "";
        int i = 0;
        while (num > 0) {
            int tri = num % 1000;
            if (tri != 0) {
                string part = helper(tri);
                if (!thousands[i].empty()) part += " " + thousands[i];
                if (!ans.empty()) part += " ";
                ans = part + ans;
            }
            i++;
            num = num / 1000;
        }
        return ans;
    }

    string helper(int curr) {
        if (curr == 0) return "";
        else if (curr < 20) {
            return below_20[curr];
        } else if (curr < 100) {
            return tens[curr / 10] + (curr % 10 ? " " + helper(curr % 10) : "");
        } else {
            return below_20[curr / 100] + " Hundred" + (curr % 100 ? " " + helper(curr % 100) : "");
        }
    }
};
