//Time Complexity O(n)
// Space Complexity O(n)
//Problem successfully executed on leetcode
//No problems faced while coading this.


#include<iostream>
#include<vector>
#include<queue>
#include<map>
#include<stack>
using namespace std;






class Solution {
public:
        vector<string> under_20= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen", "Sixteen", "Seventeen","Eighteen","Nineteen"};
        
        vector<string> under_100={"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    
    
        string numberToWords(int num) {
        
        if(num==0)
        {
            return "Zero";
        }
        string result="";
        
        
        vector<string> thousands={"","Thousand","Million","Billion"};
        
        int i=0;
        while(num!=0)
        {
            if(num % 1000 !=0)
            {
                result=helper(num%1000)+" "+thousands[i]+" "+result;
            }
            i++;
            num=num/1000;
        }

        result =rightTrim(result,' ');
        return result;
    }
    
    string rightTrim(string str, char chars)
    {
        str.erase(str.find_last_not_of(chars) + 1);
        return str;
    }
    string helper(int num)
    {
        string result="";
        if(num/100 !=0)
        {
            if(num%100==0)
            {
                result=result+ under_20[num/100]+" Hundred"; 
            }
            else
            {
                result=result+ under_20[num/100]+" Hundred ";
            }
        }
        
        int temp=num%100;
        if(temp >= 20)
        {
            if(temp%10 == 0)
            {
                result = result + under_100[temp/10];
            }
            else
            {
                result = result + under_100[temp/10]+" " + under_20[temp%10];
            }
        }
        else
        {
            result=result+ under_20[temp];
        }
        
        result =rightTrim(result,' ');
        return result;
    }
};