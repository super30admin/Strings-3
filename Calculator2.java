// O(n) time: n length of s
// O(1) space

class Solution {
    public int calculate(String s) {
        if (s == null || s.isEmpty()) return 0;
        
        int length = s.length();
        int currNumber = 0, lastNumber = 0, result = 0;
        char operation = '+';
        
        for (int i = 0; i < length; i++){
            char currentChar = s.charAt(i);
            if (Character.isDigit(currentChar)){
                currNumber = (currNumber * 10) + (currentChar - '0');
            }
            
            if (!Character.isDigit(currentChar) && !Character.isWhitespace(currentChar) || i == length - 1){
                if (operation == '+' || operation == '-'){
                    result += lastNumber;
                    lastNumber = (operation == '+') ? currNumber : -currNumber;
                }
                else if (operation =='*'){
                    lastNumber = lastNumber * currNumber;
                }
                else if (operation == '/'){
                    lastNumber = lastNumber / currNumber;
                }
                operation = currentChar;
                currNumber = 0;
            }
        }
        result += lastNumber; // BEDMAS : addition and subtraction are always at end (adding positive, or adding negative, ie substraction)
        return result;
    }
}