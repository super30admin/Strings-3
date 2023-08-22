//time -O(n)
// space - O(1)

class Solution {
public:
    int calculate(string s) {
        int n = s.size();
        
        int curr = 0, calc = 0, tail = 0;
        char lastSign = '+';

        for(int i=0; i<n; i++){
            char ch = s[i];
            if(isdigit(ch)){
                curr = curr * 10 + (ch - '0');
            }

            if((!isdigit(ch) && ch != ' ') || i == n-1){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }else if(lastSign == '*'){
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }else {
                    if(curr>0){
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                    }
                }

                lastSign = ch;
                curr = 0;
            }
        }

        return calc;
        
    }
};