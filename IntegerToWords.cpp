/*

Intuition: Divide the number into triplets. Process each triplet individually

Time Complexity: O(1)
Space Complexity: O(1)

*/

class Solution {
public:
string below20[20] = {"", "One ", "Two ", "Three ", "Four ", "Five ","Six " , "Seven ", "Eight ", "Nine ","Ten " , "Eleven ", "Twelve ", "Thirteen ","Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    string tens[10] = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ","Eighty ", "Ninety "};
    string thousands[4] = {"", "Thousand ","Million " ,"Billion " };
    string numberToWords(int num) {
        
        if(num == 0) return "Zero";
        int index = 0;
        string result;
        while(num > 0){
            int triplet = num % 1000;
            if(triplet != 0){
                result.insert(0, thousands[index]).insert(0, helper(triplet));
            }
            index++;
            num = num/1000;
        }
        return result.substr(0, result.size()-1);;
    }
    string helper(int num){
            
        if(num == 0) return "";
        else if(num < 20) return below20[num];
        else if(num < 100) return tens[num/10] + helper(num%10);
        else return below20[num/100] + "Hundred " + helper(num%100);
    
    }
};