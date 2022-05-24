/* 
    Time Complexity                              :  O(N) where N is the total number of digits in the number
    Space Complexity                             :  O(1) to store fixed size values in the arrays.
    Did this code successfully run on Leetcode   :  Yes
    Any problem you faced while coding this      :  No
*/

#include <bits/stdc++.h> 
using namespace std;  


class Solution {
private: 
    unordered_map<int, string> mp;
    
public:
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        
        vector<string> ons = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        vector<string> tns = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        vector<string> eles = {"Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        vector<string> bigs = {"","Thousand","Million","Billion","Trillion"};
        
        
        string ans = "";
        int i=0;
        
        while(num > 0) {
            
            int ones=0, tens=0, huds=0;
            string temp = "";
            
            ones = num%10;num=num/10;
            tens = num%10;num=num/10;
            
            if(tens == 1) {
                temp = eles[ones] + " " + temp;
            } else {
                if(ones > 0) temp = ons[ones] + " " + temp;
                if(tens > 0) temp = tns[tens] + " " + temp;
            }
            
            huds = num%10;num = num/10;
            if(huds > 0) temp = ons[huds] + " Hundred" + " " + temp;
            
            if(i > 0 and temp.size() > 0) {
                ans = temp + bigs[i] + " " + ans;
            } else {
                ans = temp + ans;
            }
            
            i++;
        }
        
        
        return ans.substr(0,ans.size()-1);
        
    }
};