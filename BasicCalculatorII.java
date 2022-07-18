public class BasicCalculatorII {
    // TC is O(n) where n is the number of characters
    // SC os constant
    public int calculate(String s) {
        int currSum = 0;
        char lastSign = '+';
        int tail = 0;
        int sum = 0;
        for(int i=0; i< s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                currSum = currSum*10+c-'0';
            }
            if((!Character.isDigit(c) && c != ' ')|| i == s.length()-1){
                if(lastSign == '+') {
                    sum = sum+currSum;
                    tail = currSum;
                }
                else if(lastSign == '-'){
                    sum = sum-currSum;
                    tail = -currSum;
                } 
                else if(lastSign == '*') {
                    sum = sum-tail+tail*currSum;
                    tail = tail*currSum;
                }else{
                    sum = sum-tail+tail/currSum;
                    tail = tail/currSum;
                }
                currSum = 0;
                lastSign = c;
            }
            
        }
        return sum;
    }
}
