/*
  Time complexity: O(1)
  Space complexity: O(1)

*/

public class Solution {

    public String belowTwenty(int num){
        switch(num){
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
            case 10 : return "Ten";
            case 11 : return "Eleven";
            case 12 : return "Twelve";
            case 13 : return "Thirteen";
            case 14 : return "Fourteen";
            case 15 : return "Fifteen";
            case 16 : return "Sixteen";
            case 17 : return "Seventeen";
            case 18 : return "Eighteen";
            case 19 : return "Nineteen";
        }
        return "";
    }
    
    public String ten(int num){
        switch(num){
            case 2 : return "Twenty";
            case 3 : return "Thirty";
            case 4 : return "Forty";
            case 5 : return "Fifty";
            case 6 : return "Sixty";
            case 7 : return "Seventy";
            case 8 : return "Eighty";
            case 9 : return "Ninety";
        }
        return "";
    }

    public String thousands(int num){
        switch(num){
            case 0 : return "";
            case 1 : return "Thousand";
            case 2 : return "Million";
            case 3 : return "Billion";
        }
        return "";
    }
    public string NumberToWords(int num) {
        if(num==0)
            return "Zero";

        int i = 0;
        string result = "";
        while(num>0)
        {
            int triplet = num%1000;
            if(triplet!=0)
            {
                result = helper(triplet).Trim() + " " + thousands(i) + " " + result;
            }
            i++;
            num = num/1000;
        }
        return result.Trim();
    }

    private string helper(int num)
    {
        if(num==0) return "";

        if(num<20)
            return belowTwenty(num);
        else
        if(num<100)
            return ten(num/10) + " " + helper(num%10);
        else
            return belowTwenty(num/100) + " Hundred " + helper(num%100);
    }
}
