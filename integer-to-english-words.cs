public class Solution {
    
        private static Dictionary<int, string> trials;
    
            public Solution() {
        trials = new Dictionary<int, string> {
            {1000000000, "{0} Billion {1}"},
            {1000000, "{0} Million {1}"},
            {1000, "{0} Thousand {1}"},
            {100, "{0} Hundred {1}"},
            {90, "Ninety {1}"},
            {80, "Eighty {1}"},
            {70, "Seventy {1}"},
            {60, "Sixty {1}"},
            {50, "Fifty {1}"},
            {40, "Forty {1}"},
            {30, "Thirty {1}"},
            {20, "Twenty {1}"},
            {19, "Nineteen"},
            {18, "Eighteen"},
            {17, "Seventeen"},
            {16, "Sixteen"},
            {15, "Fifteen"},
            {14, "Fourteen"},
            {13, "Thirteen"},            
            {12, "Twelve"},
            {11, "Eleven"},
            {10, "Ten"},
            {9, "Nine"},
            {8, "Eight"},
            {7, "Seven"},
            {6, "Six"},
            {5, "Five"},
            {4, "Four"},
            {3, "Three"},
            {2, "Two"},
            {1, "One"},
            {0, "Zero"}
        };
    }


    public string NumberToWords(int num) {
        
foreach(var pair in trials)
{
    if(num <=10 && num==pair.Key)
    {
        return pair.Value;
    }
    
    int n = num / pair.Key;
    num = num % pair.Key;
    if(n >=1)
    {
        if(num==0)
        {
            return String.Format(pair.Value,NumberToWords(n),"").Trim();
        }
        else
        {
            return String.Format(pair.Value,NumberToWords(n),NumberToWords(num));
        }
    }
}
        return "";
        
        
        
        
        
        
    }
}