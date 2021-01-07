//Time - O(num of digits)
//Space - O(1)

class Solution {
public:
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        unordered_map<int, string> ones {{0,""},{1," One"},{2," Two"},{3," Three"},{4," Four"},{5," Five"},{6," Six"},{7," Seven"},{8," Eight"},{9," Nine"}};
        unordered_map<int, string> teens {{11," Eleven"}, {12," Twelve"}, {13," Thirteen"}, {14, " Fourteen"}, {15," Fifteen"}, {16," Sixteen"}, {17," Seventeen"},{18," Eighteen"},{19," Nineteen"}};
        unordered_map<int, string> tens {{0,""}, {1," Ten"}, {2," Twenty"}, {3," Thirty"}, {4, " Forty"}, {5," Fifty"}, {6," Sixty"}, {7," Seventy"},{8," Eighty"},{9," Ninety"}};
        unordered_map<int, string> cluster {{0,""}, {1," Thousand"}, {2," Million"}, {3," Billion"}};
        
        
        string ans = "";
        int cnt = 0;
        while(num>0){
            
            string ret = ""; 
            int currNum = num%1000;
            num = num/1000;
            
            int units = currNum%10;
            currNum = currNum/10;
            int ten = currNum%10;
            currNum = currNum/10;
            int hundreds = currNum%10;
            
            if(hundreds > 0 ){
                ret = ret + ones[hundreds] + " Hundred";
            }
            
            if(ten == 0 && units == 0){
                ret = ret + "";    
            }else if(ten>1){//467
                ret = ret + tens[ten] + ones[units];
            }else if(units == 0){//430
                ret = ret + tens[ten];
            }else if(ten == 1){ //412,416
                ret = ret + teens[ten*10+units]; 
            }else if(ten == 0){ //405
                ret = ret + ones[units];   
            }
            
            if(hundreds || units || ten){
                ret = ret + cluster[cnt];
            }
            ans = ret + ans;
            cnt++;  
        } 

        return ans.substr(1);
        
    }
};