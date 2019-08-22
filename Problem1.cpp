//
// Created by shazm on 8/22/2019.
//

#include <iostream>
#include <algorithm>
#include <vector>
#include <string>

using namespace std;

class Solution {
private:
    vector<string> below20{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    vector<string> below100{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    vector<string> above100{"", "Thousand", "Million", "Billion"};

    string recurr(int num){
        if(num == 0){
            return "";
        }else if(num<20){
            return below20[num]+" ";
        }else if(num<100){
            return below100[num/10]+" "+recurr(num%10);
        }else{
            return below20[num/100]+" Hundred "+ recurr(num%100);
        }
    }
public:
    string numberToWords(int num) {
        if(num == 0){return "Zero";}

        int i = 0;
        string retVal = "";

        while(num>0){
            if(num%1000 != 0){
                retVal = recurr(num%1000) + above100[i] + " " + retVal;
            }
            num = num/1000; i++;
        }
        int x = retVal.size()-1;
        while(retVal[x]==' '){
            retVal.erase(x,1); x--;
        }
        return retVal;
    }
};