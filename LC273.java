//Time Complexity: O(N)
//Space Complexity: O(1);

class Solution {
    public int calculate(String s) {
        if(s == null | s.length() == 0) {
            return 0;
        }
        s = s+"+";
        s = s.replace(" ","");
        int num=0;
        char operator ='+';
        int calc = 0;
        int tail = 0;
        for(int i=0;i<s.length();i++){
            if(Character.isDigit(s.charAt(i))){
                num = num * 10 + s.charAt(i) -'0';
            }else{
                if(operator == '+'){
                    calc += num;
                    tail = num;
                } else if(operator == '-'){
                    calc -= num;
                    tail = -1*num;
                } else if(operator == '*'){
                    calc = calc - tail + tail * num;
                    tail= tail * num;
                } else if(operator == '/'){
                    calc = calc - tail + tail / num;
                    tail= tail / num;
                }
                operator = s.charAt(i);
                num=0;
            }

        }

        return calc;
    }
}