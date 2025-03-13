// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
#include <iostream>
#include <vector>

using namespace std;
class Solution {
public:
        vector<string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

        vector<string> below_100 =  {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        vector<string> suffix =  {"", "Thousand", "Million", "Billion"};
    string magic( int num) {
        if (num<20) return below_20[num];
        else if (num < 100) {
            return below_100[num/10] + " " + magic(num%10);
        }
        else return below_20[num/100] + " Hundred " + magic(num%100);
    }
    string numberToWords(int num) {
        if (num==0) return "Zero";
        string res="";
        int i =0; //suffix index
        while (num >0) {
            int triplet = num%1000;
            if (triplet != 0) {
                res = magic(triplet) + " " + suffix[i] + " " + res;
            }
            num=num/1000;
            i++;
        }
        return res.substr(0, res.find_last_not_of(" ") + 1); 
    }

}u;