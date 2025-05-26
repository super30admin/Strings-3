// Time Complexity : O(n), where n is the length of the input string
// Space Complexity : O(1)

public class basicCalculator_2 {
    public int calculate(String s) {
        char ch[] = s.toCharArray();
        int prev = 0;
        char lastsign = '+';
        int current = 0;
        for(int i=0;i<ch.length;i++)
        {
            if(ch[i]=='+')
            {
                lastsign = '+';
            }
            else if(ch[i]=='-')
            {
                lastsign = '-';
            }
            else if(ch[i]=='*' || ch[i] == '/')
            {
                char symb = ch[i];
                int x = 0;
                i=i+1;
                while(i<ch.length && ch[i]==' ')
                {
                    i=i+1;
                }
                while(i+1<ch.length && ch[i+1] >= '0' && ch[i+1] <= '9')
                {
                
                    x = (x*10) + ch[i] - '0';
                    i=i+1;
                }
                x = (x*10) + ch[i] - '0';
                current = current-prev;
                if(symb=='*')
                {
                    current = (current*x)+prev;
                }
                else
                {
                        current = (current/x)+prev;
                }
                lastsign='+';
            }
            else if(ch[i] >= '0' && ch[i] <= '9')
            {
                prev = current;
                int x = 0;
                while(i+1<ch.length && ch[i+1] >= '0' && ch[i+1] <= '9')
                {
                    x = (x*10) + ch[i] - '0';
                    i=i+1;
                }
                x = (x*10) + ch[i] - '0';
                if(lastsign == '+')
                {
                    current = current+x;
                }
                else if(lastsign == '-')
                {
                    current = current-x;
                }
            }
        }
        return current;
    }
}