#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We split the number into 3-digit chunks from right to left and process each chunk separately.
Each chunk is converted into words using simple rules—handle small numbers directly, combine tens and ones, or add “Hundred” if needed.
Then we join the word parts with proper labels like "Thousand" or "Million", clean up spaces, and that's our final sentence.
*/
class Solution{
vector<string> thousands = {"", " Thousand ", " Million ", " Billion "};
    vector<string> below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
                                    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", 
                                    "Eighteen", "Nineteen" };
    vector<string> tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    string helper(int num){
        string result;
        if(num < 20) result += below_20[num];
        else if(num < 100) result += tens[num/10] + " " + below_20[num%10];
        else result += below_20[num/100] + " Hundred " + helper(num%100);
        return result;
    }
public:
    string numberToWords(int num) {
        if(num == 0) return "Zero";

        int i = 0;
        string result;

        while(num > 0){
            int triplet = num%1000;

            if(triplet > 0){
                string part = helper(triplet);
                part.erase(part.find_last_not_of(' ')+1); //right-trim
                result = part + thousands[i] + result;
            }

            num = num/1000;
            i++;
        }

        if(!result.empty() && result.back() == ' ') result.pop_back(); //final trim
        return result;
    }
};
