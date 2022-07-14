//Time complexity : O(n)
//Space Complexity : O(1)
//Did it run on leetcode : yes

public class BasicCalculator2 {

    public int calculate(String s) {

        //base
        if(s == null || s.length() == 0) return 0;

        s= s.trim();
        int calc = 0 ,curr = 0, tail = 0;
        char lastSign = '+';

        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);

            if(Character.isDigit(c)){ //Ex: "13"
                curr = curr * 10 + c - '0';
            } //i == s.length() - 1 coz calculate even when we hit last index
            if((!Character.isDigit(c) || i == s.length()-1) && c != ' '){
                if(lastSign == '+'){
                    calc = calc + curr;
                    tail = curr;
                }
                else if(lastSign == '-'){
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastSign == '*'){
                    calc = calc - tail +(tail * curr);
                    tail = tail * curr;
                }else if(lastSign == '/'){
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                lastSign = c;
                curr = 0;//reset it after every calculation
            }
        }
        return calc;
    }

}