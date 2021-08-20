//Time complexity: O(n), where n is the length of s.
//Space complexity: O(1)

class Solution2 {
    public int calculate(String s) {
        //base case
        if(s == null || s.length() == 0) return 0;
        //remove spaces
        s = s.replace(" ",""); 
        //add extra char
        s = s + "+"; 
                
        char lastSign = '+';
        int num = 0;
        int tail = 0;
        int calc = 0; 
        for(char c: s.toCharArray()) {
            if(c >= '0' && c <= '9') {
                num = num*10 + Character.getNumericValue(c);
            } else {
                //case 1 - +
                if(lastSign == '+') {
                    calc = calc + num; 
                    tail = num;
                }
                //case 2 - -
                else if(lastSign == '-') {
                    calc = calc - num; 
                    tail = -num;
                }
                //case 3 - *
                else if(lastSign == '*') {
                    calc = calc - tail + (tail * num); 
                    tail = tail * num;
                }
                //case 4 - /
                else if(lastSign == '/') {
                    calc = calc - tail + (tail / num); 
                    tail = tail / num;
                }
                lastSign = c;
                num = 0;
            }
        }
        return calc; 
    }
}