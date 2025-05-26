// Time Complexity : O(1), because the number of digits is fixed (max 10 digits for int)
// Space Complexity : O(1) extra space, but O(k) for the output string (k = number of characters in the result)


public class IntegerToString {
    String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};
    public String three(int num)
    {
        StringBuilder st = new StringBuilder();
        while(num >0)
        {
            if(num >=100)
            {
                int temp = num /100;
                st.append(LESS_THAN_20[temp]).append(" Hundred").append(" ");
                num = num%100;
            }
            else if(num >= 20)
            {
                int temp = num /10;
                st.append(TENS[temp]).append(" ");
                num = num%10;
            }
            else if(num<20)
            {
                st.append(LESS_THAN_20[num]);
                return st.toString();
            }
        }
        return st.toString().trim();
    }
    public String numberToWords(int num) 
    {
        if(num ==0)
        {
            return "Zero";
        }
        int op = 0;
        StringBuilder s = new StringBuilder();
        while(num>0)
        {
            if(op > 0)
            {
                if(num%1000 == 0)
                {
                    s.insert(0, three(num%1000));
                }
                else
                {
                    s.insert(0, three(num%1000) +" "+ THOUSANDS[op] +" ");
                }
                num = num/1000;
                op++;

            }
            else
            {
                s.append(three(num%1000));
                num = num/1000;
                op++;
            }
        }
        return s.toString().trim();
    }
}
