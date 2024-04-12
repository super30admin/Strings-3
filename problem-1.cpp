// t-c: log(num)
// s-c: log(num)
class Solution {
public:
    vector<string> below_20 = {"", "One ", "Two " , "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
                                    "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    vector<string> tens = {"", "Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "}; 
    vector<string> hundreds = {"", "Thousand ", "Million ", "Billion "};
    string numberToWords(int num) {
        if(num == 0)
            return "Zero";
        int k = 0;
        string result = "";
        while(num % 1000 != num)
        {
            if(num%1000 != 0)
                result = helper(num % 1000, k) + result;
            k+=1;
            num = num/1000;
        }
        result = helper(num % 1000, k) + result;
        result.pop_back();
        return result;
    }
    string helper(int num, int k)
    {
        string result = "";
        if(num < 20)
            result = below_20[num] + hundreds[k];
        else if(num < 100)
            result = tens[num/10] + helper(num % 10, k); 
        else
            result = below_20[num/100] + "Hundred " + helper(num % 100, k);
        return result;
    } 
};
