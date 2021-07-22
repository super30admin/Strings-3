//O(1) TC + O(1)SC
//bloody hell
class Solution {
public:
    string numberToWords(int num) {
        if (num == 0) return "Zero";
        string res, str[4], words[4] = {"", "Thousand", "Million", "Billion"};
        for (int i = 0; i < 4 && num != 0; i++) {
            if (num % 1000 != 0)
                itow(num % 1000, words[i], str[i]);
            num /= 1000;
        }
        for (int i = 0; i < 4; i++) {
            if (res == "")
                res = str[i];
            else if(str[i] != "")
                res = str[i] + ' ' + res;
        }
        return res;
    }
    
    string digits[19] = {"One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    string second[8] = {"Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    void itow(int num, string word, string& str) {
        if (num / 100 != 0)
            str = digits[num/100 - 1] + " Hundred ";
        num %= 100;
        if (num >= 20) {
            str += second[num/10 - 2] + ' ';
            num %= 10;
            if (num > 0)
                str += digits[num-1] + ' ';
        } else if (num > 0)
            str += digits[num-1] + ' ';
        str = (word == "") ? str.substr(0, str.size()-1) : str+word;
    }
};
