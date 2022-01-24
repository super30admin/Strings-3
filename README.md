# Strings-3

## Problem1

Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

T.C O(1)
S.C O(1)

class Solution {

     String[] below_20  = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
     String[] below_100  = {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
     String[] thousands = {"","Thousand","Million","Billion"};

    public String numberToWords(int num) {

      if ( num == 0) return "zero";
       int i =0;
       String result="";
      while ( num > 0)
      {
      if( num % 1000 != 0)
      {

         result= helper(num%1000)+" "+thousands[i]+" "+result;

      }

      num = num /1000;
      i++;
      }

     return result.trim();
    }

     private String helper( int num )

{
if ( num < 20 )
{
return below_20[num];
}
else if ( num < 100)
{
return below_100[num/10]+" "+helper(num%10);
}
else
{
return below_20[num/100]+" Hundred "+ helper(num%100);
}

}
}

## Problem2

Basic Calculator || (https://leetcode.com/problems/basic-calculator-ii/)

S.C asymptotically O(n)
T.C o(n)

class Solution {
public int calculate(String s) {

        if (s.length() == 0 || s == null) return 0;
        int curr=0,calc=0;
        Stack<Integer> st= new Stack<>();
        char lastSign='+';
        for(int i=0; i<s.length(); i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                curr= curr * 10 + c -'0';
            }
            if( !Character.isDigit(c) && c != ' '|| i == s.length() - 1)
            {
                if ( lastSign == '+')
                {
                    st.push(curr);
                }
                else if ( lastSign == '-')
                {
                    st.push(-curr);
                }
                else if ( lastSign == '*')
                {
                    st.push(st.pop() * curr);
                }
                else
                {
                    st.push( st.pop() / curr);
                }

                lastSign = c;
                curr = 0;
            }

        }

        while(!st.isEmpty())
        {
            calc = calc + st.pop();
        }

      return calc;
    }

}

space optimized
T.C O(n)
S.C O(1)

class Solution {
public int calculate(String s) {

        if (s.length() == 0 || s == null) return 0;
        int curr=0,calc=0,tail=0;
        char lastSign='+';
        for(int i=0; i<s.length(); i++)
        {
            char c=s.charAt(i);
            if(Character.isDigit(c))
            {
                curr= curr * 10 + c -'0';
            }
            if( !Character.isDigit(c) && c != ' ' || i == s.length() - 1)
            {
                if ( lastSign == '+')
                {
                    calc = calc + curr;
                    tail = curr;
                }
                else if ( lastSign == '-')
                {
                    calc = calc - curr;
                    tail = -curr;
                }
                else if ( lastSign == '*')
                {
                    calc = calc - tail + tail * curr;
                    tail = tail * curr;
                }
                else
                {
                    calc = calc - tail + tail / curr;
                    tail = tail /  curr;
                }

                lastSign = c;
                curr = 0;
            }

        }

             return calc;
    }

}
