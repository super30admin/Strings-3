class Solution {
public:
    string ones(int num)
    {
        switch(num)
        {
            case 1:
                return "One";
            case 2:
                return "Two";
            case 3:
                return "Three";
            case 4:
                return "Four";
            case 5:
                return "Five";
            case 6:
                return "Six";
            case 7:
                return "Seven";
            case 8:
                return "Eight";
            case 9:
                return "Nine";
        }
        return "";
    }
    string teens(int num)
    {
        switch(num)
        {
            case 10:
                return "Ten";
            case 11:
                return "Eleven";
            case 12:
                return "Twelve";
            case 13:
                return "Thirteen";
            case 14:
                return "Fourteen";
            case 15:
                return "Fifteen";
            case 16:
                return "Sixteen";
            case 17:
                return "Seventeen";
            case 18:
                return "Eighteen";
            case 19:
                return "Nineteen";
        }
        return "";
    }
    string tens(int num)
    {
        switch(num)
        {
            case 20:
                return "Twenty";
            case 30:
                return "Thirty";
            case 40:
                return "Forty";
            case 50:
                return "Fifty";
            case 60:
                return "Sixty";
            case 70:
                return "Seventy";
            case 80:
                return "Eighty";
            case 90:
                return "Ninety";
        }
        return "";
    }
    
    string size_two(int num)
    {
        if(num<10)
            return ones(num);
        if(num<20)
            return teens(num);
        int ten = num / 10;
        int rem = num%10;
        if(ten!=0 && rem!=0)
        {
            return tens(ten*10) + " " + ones(rem);
        }else
            return tens(ten*10);
    }
    string size_three(int num)
    {
        if(num/100==0)
            return size_two(num);
        int hundred = num/100;
        int rest = num%100;
        if(hundred!=0 && rest!=0)
        {
            return ones(hundred) + " Hundred " + size_two(rest);
        }else
            return ones(hundred) + " Hundred";
    }
    
    string numberToWords(int num) {
        if(num==0)
            return "Zero";
        int billion = num/1000000000;
        num = num%1000000000;
        int million = num/1000000;
        num = num%1000000;
        int thousand = num/1000;
        num = num%1000;
        string res = "";
        if(billion!=0)
        {
            res = res + ones(billion) + " Billion";
        }
        if(million!=0)
        {
            res = res +" "+size_three(million) + " Million";
        }
        if(thousand!=0)
        {
            res = res +" "+size_three(thousand) + " Thousand";
        }
        if(num!=0)
        {
            res = res +" "+size_three(num);
        }
        int ind = 0;

        return res;
    }
};