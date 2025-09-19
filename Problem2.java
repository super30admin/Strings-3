
// Time Complexity : O(n) where n is the length of the string
// Space Complexity : O(1) since the space used is independent of the input size

//We traverse the string once, building numbers and applying operations as we go.
//When we hit an operator, we apply the previous sign and adjust the result based on precedence using a tail tracker.
//This lets us handle * and / immediately without a stack, by reversing the last number and applying the new operation.
//This ensures correct order of operations in a single pass with constant space.

class Solution {
    public int calculate(String s) {
        s=s.trim();
        int cal=0,tail=0,currNum=0;
        char lastSign='+';
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                currNum=currNum*10+ch-'0';
            }
            if((!Character.isDigit(ch)&&ch!=' ')||i==s.length()-1){
                if(lastSign=='+'){
                    cal+=currNum;
                    tail=currNum;
                }else if(lastSign=='-'){
                    cal-=currNum;
                    tail=-currNum;
                }else if(lastSign=='*'){
                    cal=(cal-tail)+(tail*currNum);
                    tail=tail*currNum;
                }else{
                    cal=(cal-tail)+(tail/currNum);
                    tail=tail/currNum;
                }
                currNum=0;
                lastSign=ch;
            }
        }
        return cal;
    }
}