//Time Complexity = O(N)+ O(N);
//Space complexity = O(N)
class Solution {
    public int calculate(String s) {
        Stack<Integer> stk = new Stack<>();
        int curr = 0;
        char prevsign = '+';
        for(int i =0; i< s.length() ; i++){
            char a = s.charAt(i);
            if(Character.isDigit(a)){
                curr = curr*10 + (a-'0');
            }
            if((!Character.isDigit(a) && a!= ' ') || i == s.length()-1){
                if(prevsign == '+'){
                    stk.push(curr);
                    
                }if(prevsign == '-'){
                    stk.push(-curr);
                }if(prevsign == '*'){
                    stk.push(stk.pop()*curr);
                }if(prevsign == '/'){
                    stk.push(stk.pop()/curr);
                }
                prevsign = a;
                curr =0;
            }
        }
        int result = 0;
        while(!stk.isEmpty()){
            result += stk.pop();
        }
        
        return result;
    }
}