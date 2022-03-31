class Solution {
    public int calculate(String s) {
        int curr = 0, tail = 0, res = 0;
        char lastOp = '+';
        
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            
            if(Character.isDigit(ch)){
                curr = curr * 10 + (ch - '0');
            }
            
            if(!Character.isDigit(ch) && ch!=' ' || i==s.length() - 1){
                if(lastOp == '+'){
                    res += curr;
                    tail = curr;
                }else if(lastOp == '-'){
                    res -= curr;
                    tail = -curr;
                }else if(lastOp == '*'){
                    res = res - tail + tail * curr;
                    tail = tail * curr;
                }else if(lastOp == '/'){
                    res = res - tail + tail / curr;
                    tail = tail / curr;
                }
                
                curr = 0;
                lastOp = ch;
            }
            
        }
        
        return res;
    }
}
