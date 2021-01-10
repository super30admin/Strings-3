// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    vector<string> below20;
    vector<string> tens;
    vector<string> thousands;
public:
    string numberToWords(int num) {
        below20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        tens = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        thousands = {"","Thousand","Million","Billion"};
        if(num==0){
            return "Zero";
        }
        string result = "";
        int i = 0;
        while(num>0){
            if(num%1000>0){
                result = helper(num%1000)+thousands[i]+" "+result;
            }
            num = num/1000;
            i++;
        }
        while(result.size()){
            if(result[result.size()-1]<33){
                result.erase(result.size()-1);
            }
            else{
                break;
            }
        }
        return result;
    }
    string helper(int num){
        if(num==0){
            return "";
        }
        else if(num<20){
            return below20[num]+" ";
        }
        else if(num<100){
            return tens[num/10]+" "+helper(num%10);
        }
        else{
            return below20[num/100]+" Hundred "+helper(num%100);
        }
    }
};
