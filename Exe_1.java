class Solution {
    public int calculate(String s) {
        int r=0, t=0, c=0;
        char o ='+';

        for(int i=0; i<s.length(); ++i){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                c = c*10+(ch-'0');
            }
            if(i == s.length()-1 || (ch != ' ' && !Character.isDigit(ch))){
                if(o == '+'){
                    r = r+c;
                    t = c;
                }else if(o == '-'){
                    r = r-c;
                    t = -c;
                }else if(o=='*'){
                    r = r-t+t*c;
                    t=t*c;
                }else{
                    r =r-t+t/c;
                    t=t/c;
                }
                c=0;
                o=ch;
            }
        }
        return r;
    }
}

//tc=O(r)
//sc=O(1)
