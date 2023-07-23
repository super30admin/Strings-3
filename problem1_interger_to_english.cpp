#include<iostream>
#include<string>
#include<vector>

using namespace std;

//Time Complexity : O(N)
//Space Complexity: O(1)


class Solution {
    unordered_map<int,string> umap{
        {0,"Zero"},
        {1,"One"},
        {2,"Two"},
        {3,"Three"},
        {4,"Four"},
        {5,"Five"},
        {6,"Six"},
        {7,"Seven"},
        {8,"Eight"},
        {9,"Nine"},
        {10,"Ten"},
        {11,"Eleven"},
        {12,"Twelve"},
        {13,"Thirteen"},
        {14,"Fourteen"},
        {15,"Fifteen"},
        {16,"Sixteen"},
        {17,"Seventeen"},
        {18,"Eighteen"},
        {19,"Nineteen"},
        {20,"Twenty"},
        {30,"Thirty"},
        {40,"Forty"},
        {50,"Fifty"},
        {60,"Sixty"},
        {70,"Seventy"},
        {80,"Eighty"},
        {90,"Ninety"},
        {100,"Hundred"},
    };

    vector<string> th_map{
        "",
        "Thousand ",
        "Million ",
        "Billion "
    };

public:
    string helper(int num){
        if(num>=100){
            int x = num/100;
            return umap.at(x)+" Hundred "+helper(num%100);
        }
        else if(num>19){
            int x = num/10;
            return umap.at(x*10)+" "+helper(num%10);
        }
        else if(num>0){
            return umap.at(num)+" ";
        }
        return "";
    }
    string numberToWords(int num) {
        string op{};
        if (num == 0) return umap[num];
        int n = th_map.size();
        //cout<<num<<endl;
        for(int i{3};i>=0;--i){
            int x = pow(1000,i);
            int y = num/x;
            if(y>0){
                op = op + helper(y) + th_map.at(i);
            }
            num = num - (num/x)*x;
            //cout<<num<<endl;
        }
        int l = op.size();
        op = op.substr(0,l-1);
        return op;
    }
};