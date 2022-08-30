//Time Complexity:O(n)where n is the length of the string.
//Space Complexity:O(1)
//Amazon
//Greedy approach
class Solution {
    public int calculate(String s) {
        if(s== null || s.length()==0) return 0;
        s=s.trim();
        char lastSign ='+';
        int calc = 0,tail=0,num=0;
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                num = num*10+c-'0';
            }
            if((!Character.isDigit(c) && c != ' ') || (i == s.length()-1)){
                if(lastSign == '+'){
                    calc = calc+num;
                    tail =+ num;
                }
                else if(lastSign == '-'){
                    calc = calc-num;
                    tail =- num;
                }
                else if(lastSign == '*'){
                    calc = calc-tail+tail*num;
                    tail = tail*num;
                }
                else{
                    calc = calc-tail + tail/num;
                    tail = tail/num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calc;
        
    }
}