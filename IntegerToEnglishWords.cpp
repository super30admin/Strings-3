// Time COmplexity -> O(1)
// Space Complexity -> O(1)
// Problems Faced - No!
// It runs on Leetcode!
class Solution {
    string below20[20] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
        
        string tens[10] = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
        
        string thousands[4] = {"", "Thousand", "Million", "Billion"};
    private: 
    string helper(int num){
        if(num == 0)
            return "";
        else if(num < 20)
            return below20[num] + " ";
        else if(num < 100)
            return tens[num/10] + " " + helper(num%10);
        else
            return below20[num/100] + " Hundred " + helper(num%100);
    }
public:
    string numberToWords(int num) {
        if(num == 0) return "Zero";
        string answer;
        int i = 0;
        while(num > 0){
            int curr = num%1000;
            if(curr != 0){
                answer = helper(curr) + thousands[i] + " " + answer;
            }
            i++;
            num = num/1000;
        }
        
        for(int i = 0; i < 3; i++){
            int l = answer.length();
            if(answer[l-1] != ' ')
                break;
            else{
                answer.resize(l-1);
            }
        }
        return answer;
    }
};