// Time Complexity : O(n)
// Space Complexity :O(1)
class Solution {
    public int calculate(String s) {
        if(s.length()==0 || s==null) return 0;
        s=s.trim();
        int num=0, tail=0,calc=0;
        char lastsign='+';
        for(int i=0;i<s.length();i++){
            char c= s.charAt(i);
             if(Character.isDigit(c)){
                 num=num*10 + (c-'0');
             }
             if((!Character.isDigit(c) && c!= ' ') || (i==s.length()-1)){
                 if(lastsign=='+'){
                     calc=calc+num;
                     tail= +num;
                 }
                 if(lastsign=='-'){
                     calc=calc-num;
                     tail= -num;
                 }
                 if(lastsign=='*'){
                     calc=calc-tail+(tail*num);
                     tail= tail*num;
                 }
                 if(lastsign=='/'){
                     calc=calc-tail+(tail/num);
                     tail= tail/num;
                 }
                 lastsign=c;
                 num=0;                    
             }
        }
        return calc;
    }
}