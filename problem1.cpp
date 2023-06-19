// Time Complexity : O(1) (n is 32 bit integer)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

class Solution {
public:
    vector<string>Below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    vector<string>Tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    vector<string>Thousands = {"","Thousand","Million","Billion"};
    string numberToWords(int num) {
        if(num==0) return "Zero";
        string ans;
        int cnt = 0;
        while(num>0)
        {
            if(num%1000!=0)
            {
                string p = f(num%1000);
                ans = p + Thousands[cnt] +" "+ ans;
            }
            num = num/1000;
            cnt++;
        }
        while (!ans.empty() && ans[ans.length() - 1] == ' ') {
            ans.pop_back(); 
        }
        return ans ;
    }
    string f(int n)
    {
        if(n==0) return "";
        else if(n<20) return Below_20[n] + " ";
        else if(n<100) return Tens[n/10] +" "+ f(n%10);
        else{
            return Below_20[n/100] + " Hundred "+ f(n%100);
        }
    }
};