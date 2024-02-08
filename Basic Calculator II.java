// Time Complexity : O(n)
// Space Complexity : O(1)

class Solution {
    public int calculate(String s) {
        
        char lastSign = '+';
        int num = 0, calc = 0, tail = 0;

        // Trim the string if it has spaces at beginning and the end. But this won't eliminate the spaces in between 
        // anyway
        s = s.trim();

        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);

            // c is digit so convert it to number
            if(Character.isDigit(c))
            {
                num = num * 10 + c - '0';
            }
            
            // If my character is not a digit and it is also not a space (or) I might be standing at last character
            // When I am at last index that will definetly be a digit and we have to consider that to our calc
            // But the below if statement will execute if it's not a digit. That's the reason we also check if 
            // i is at last index so we have to continue the calculation.
            if( (!Character.isDigit(c) && c != ' ') || (i == s.length() - 1))
            {
                // Check c is what kind of operator

                if(lastSign == '+')
                {
                    calc = calc + num;
                    tail = +num;
                }

                else if(lastSign == '-')
                {
                    calc = calc - num;
                    tail = -num;
                }

                else if(lastSign == '*')
                {
                    calc = calc - tail + (tail * num);
                    tail = tail * num;
                }

                else
                {
                    calc = calc - tail + (tail / num);
                    tail = tail / num;
                }

                lastSign = c;
                num = 0;
            }
        }

        return calc;
    }
}