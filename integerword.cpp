
#include<iostream>
using namespace std;

class Solution {
public:

   string below_20[20] = { "","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve",
                         "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

    string tens[10] = { "","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy", "Eighty", "Ninety"};

    string thous[4] = {"","Thousand", "Million","Billion"};

    string numberToWords(int num) {
        
            if(num==0) return "Zero";
            string result = "";



            int i = 0;
            while(num > 0){
                int triplate = num%1000;
                if(triplate!=0){
                    result = trim(helper(triplate)) + " " + thous[i] + " " + result;
                }
                i++;
                num = num/1000;
            }
            return trim(result);
    }


    private:
    string helper(int num){
        if(num<20){
            return below_20[num] ;
        }else if(num<100){
            return tens[num/10] + " " + helper(num%10);
        }else{
            return below_20[num/100] + " Hundred " + helper(num%100);
        }
    }

    private:
    string trim(string s)
    {
    while (!s.empty() && s.front() == ' ')
        s.erase(s.begin());

    while (!s.empty() && s.back() == ' ')
        s.pop_back();

    return s;
    }
};