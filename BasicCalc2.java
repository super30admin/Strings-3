// Time Complexity : O(N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No.

// Your code here along with comments explaining your approach
/*
Use variables curr, calc, tail and lastSign
Based on last sign vary the formula to calculate the result.
* */
public class BasicCalc2 {
    public int calculate(String s) {

        if(s.length()==0 || s==null) return 0;

        int curr=0, calc=0, tail=0;
        char lastSign='+';

        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);

            if(Character.isDigit(ch)){
                curr= curr*10+(ch-'0');
            }

            if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
                if(lastSign=='+'){
                    calc+=curr;
                    tail=curr;
                }else if(lastSign=='-'){
                    calc-= curr;
                    tail= -1*curr;
                }else if(lastSign=='*'){
                    calc= (calc-tail)+(tail*curr);
                    tail=tail*curr;
                }else if(lastSign=='/'){
                    calc= (calc-tail)+(tail/curr);
                    tail=tail/curr;
                }

                curr=0;
                lastSign=ch;
            }
        }

        return calc;
    }
}
