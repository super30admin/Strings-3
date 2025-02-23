class Solution {
    //Time Complexity:O(n)
    //Space Complexity:O(1)
    public int calculate(String s) {
       if (s == null) {
        return 0;
       }
       int calc = 0, tail =0; 
       int num = 0;
       char lastSign = '+';
       Stack<Integer> st = new Stack<>();
       for (int i = 0;i < s.length();i++){
        char c = s.charAt (i);
        if (Character.isDigit(c)){
        num = num * 10 +c- '0';
        }
        if (!Character.isDigit(c) && c != ' ' || (i == s.length()-1)){
            if (lastSign == '+'){
                st.push (num);
                num =0;
            }
            if (lastSign == '-'){
                st.push (-num);
                num =0;
            }
            if (lastSign == '*'){
                st.push(st.pop()*num);
            }
            if (lastSign == '/'){
                st.push(st.pop()/num);
            }
            lastSign = c;
            num = 0;
       }
    }
    while (!st.isEmpty()){
        calc = calc +st.pop();
    }
    return calc;
}

}
