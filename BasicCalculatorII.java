//TC = O(N)
//SC = O(1)

public class BasicCalculatorII {
    

    public static int calculate(String s)
    {
        if(s == null || s.length()==0) return 0;
        
        char lastSign = '+';
        int curr = 0;
        int tail = 0;
        int calc = 0;
        
        for(int i=0;i<s.length();i++)
        {
            char c = s.charAt(i);
            
            if(Character.isDigit(c))
            {
                curr = curr * 10 + (c-'0');
            }
            
            if((!Character.isDigit(c) && c!= ' ') || i == s.length() -1)
            {
                if(lastSign == '+')
                {
                    calc = calc + curr;
                    tail= + curr;
                }
                else if(lastSign == '-')
                {
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*')
                {
                    calc = calc - tail + (tail*curr);
                    tail = tail * curr;
                }
                else if(lastSign == '/')
                {
                    calc = calc - tail + (tail/curr);
                    tail = tail/curr;
                }
                curr = 0;
                lastSign = c;
            }
        }

        return calc;
    }

    public static void main(String args[])
    {
        System.out.println(calculate("3*2+2"));
    }
}
