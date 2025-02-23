
//TC => O(logn)
//SC => O(1)
public class Solution
{
    string[] thousands = [" ", "Thousand", "Million", "Billion"];
    string[] tens = [" ", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
    // string hundred = "Hundred";
    string[] below20 = [" ", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
    public string NumberToWords(int num)
    {
        if (num == 0)
        {
            return "Zero";
        }

        string result = "";
        int i = 0;
        while (num > 0)
        {
            if (num % 1000 != 0)
            {
                result = Recurse(num % 1000).Trim() + " " + thousands[i] + " " + result;
            }
            i++;
            num = num / 1000;
        }

        return result.Trim();
    }

    public string Recurse(int num)
    {
        if (num == 0)
        {
            return "";
        }
        else if (num < 20)
        {
            return below20[num];
        }
        else if (num < 100)
        {
            return tens[num / 10] + " " + Recurse(num % 10);
        }
        else
        {
            return below20[num / 100] + " Hundred " + Recurse(num % 100);
        }
        return "";
    }
}