// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

 //Fprmula: calc - tail + (tail *(last sign operator) curr)
public int Calculate(string s) {
    
    if(String.IsNullOrEmpty(s))
        return 0;
    
    char lastSign = '+';
    int calc = 0, tail = 0, curr = 0;
    
    for(int i = 0; i < s.Length; i++)
    {
        char c = s[i];
        if(Char.IsDigit(c)){
            curr = curr * 10 + (c - '0');
        }
        
        if((!Char.IsDigit(c) && c != ' ') || ( i == s.Length - 1))
        {
            if(lastSign == '+'){
                calc = calc + curr;
                tail = curr;
            }
            
            else if(lastSign == '-'){
                calc = calc - curr;
                tail = -curr;
            }
            
            else if(lastSign == '*'){
                calc = calc - tail + (tail * curr);
                tail = tail * curr;
            }
            
            else{
                calc = calc - tail + (tail / curr);
                tail = tail / curr;
            }
            
            lastSign = c;
            curr = 0;
            
        }
    }
    return calc;
}