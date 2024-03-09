//1. Number to English
//Time Complexity - > O(n)
//Space Complexity - > O(1)
class Solution {
    String[] below_20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] tens = {"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    String[] thousands = {"","Thousand","Million","Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String result = "";
        int i = 0;
        while(num > 0){
            int triplet = num%1000;
            if(triplet!=0){
                result = helper(triplet).trim() +" " + thousands[i] + " " + result;
            }
            num = num / 1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num){
        if(num < 20){
            return below_20[num] + " ";
        }
        else if( num < 100){
            return tens[num/10] + " " + below_20[num%10]; 

        }else{
            return below_20[num/100] + " Hundred " + helper(num%100);

        }

    }
}

//2nd Basic Calculator 2
//Time Complexity -> O(n)
//Space Complexity -> O(1)
class Solution {
    // Using tail concept
    // Time Complexity - > O(n)
    // Space Complexity - > O(1)
    public int calculate(String s) {
        if (s == null || s.length() == 0)
            return 0;
        // Trim the string for any extra spaces
         System.out.println(s.length());
        s = s.trim();
         System.out.println(s.length());
        int n = s.length();
        int curr = 0;
        char lastSign = '+';
        int calc = 0;
        int tail = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                curr = curr * 10 + (ch - '0');

            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == n - 1) {
                // now check for operation
                if (lastSign == '+') {
                    calc = calc + curr;
                    tail = +curr;

                } else if (lastSign == '-') {
                    calc = calc - curr;
                    tail = -curr;

                } else if (lastSign == '*') {
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;

                } else {
                    calc = calc - tail + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;
                lastSign = ch;
            }
        }

        return calc;
    }
}

//3rd basic Calculator 1
//Time Complexity -> O(n)
//Space Complexity - O(1)
class Solution {
    public int calculate(String s) {
        if(s == null || s.length() == 0) return 0;
        System.out.println(s.length());
       s =  s.trim();
         System.out.println(s.length());
        int n = s.length();
        int curr = 0;
        char lastSign = '+';
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n;i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                curr = curr*10 + (ch-'0');
                if(i == s.length() - 1){ //if we are at the last sign
                    if(lastSign == '+') st.push(curr);
                    else st.push(-curr);
                }
            }else if(ch == '+' || ch == '-' ){
                if(lastSign == '+'){
                    st.push(+curr);
                }else{
                    st.push(-curr);
                }
                curr = 0; lastSign = ch;
            }else if(ch == '('){
                if(lastSign == '+') st.push(1);
                else st.push(-1);
                st.push(Integer.MAX_VALUE);
                curr = 0; lastSign = '+';
            }else if(ch == ')'){
                if(lastSign == '+') st.push(curr);
                else st.push(-curr);
                int intRes = 0;
                while(st.peek() != Integer.MAX_VALUE){
                    intRes+=st.pop();
                }
                st.pop(); //Remove the Integer.max value basically it is removing the opening bracket
                intRes = intRes * st.pop();
                st.push(intRes);
                curr = 0; lastSign = '+';

            }
            
        }
        int result = 0;
            while(!st.isEmpty()){
                result+=st.pop();
            }

            return result;
        
    }
}
