class Solution {
public:
    int calc(int a,int b,char c)
    {
        int n3=0;
        
        if(c=='+')
        {
            n3=a+b;
        }
        else if(c=='-')
        {
            n3=a-b;
        }
        else if(c=='*')
        {
            n3=a*b;
        }
        else if(c=='/')
        {
            n3=a/b;
        }
        
        return n3;
    }
    
    int calculate(string s) 
    {
    
        stack<int> numbers;
        stack<char> operators;
        
        for(int i=0;i<s.length();i++)
        {
            if(s[i]==' ' || s[i]=='\t')
            {
                continue;
            }
            
            else if(isdigit(s[i]))
            {
                int num=0;
                while(i<s.length() && isdigit(s[i]))
                {
                    num=num*10+(s[i]-'0');
                    i++;
                }
                i--;
                numbers.push(num);
            }
            
            else if(!operators.empty() && (s[i]=='+' || s[i]=='-') && (operators.top()=='*' || operators.top()=='/'))
            {
                while(!operators.empty())
                {
                    int n2=numbers.top();
                    numbers.pop();
                    int n1=numbers.top();
                    numbers.pop();
                    
                    int n3=calc(n1,n2,operators.top());
                    
                    operators.pop();
                    numbers.push(n3);          
                }
                 operators.push(s[i]);
            }
            else if(!operators.empty() && (s[i]=='*' || s[i]=='/') && (operators.top()=='+' || operators.top()=='-'))
            {
                operators.push(s[i]);
            }
            else 
            {
                if(!operators.empty())
                {
                    int n2=numbers.top();
                    numbers.pop();
                    int n1=numbers.top();
                    numbers.pop();
                    
                    int n3=calc(n1,n2,operators.top());

                    operators.pop();
                    numbers.push(n3); 
                    operators.push(s[i]);
                }
                else 
                {
                operators.push(s[i]);
                }
            }
        }
        
        while(!operators.empty())
        {
                    int n2=numbers.top();
                    numbers.pop();
                    int n1=numbers.top();
                    numbers.pop();
                    
                    int n3=calc(n1,n2,operators.top());
                    
                    operators.pop();
                    numbers.push(n3); 
        }
        return numbers.top();
    }
};