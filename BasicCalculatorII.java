class Solution {

    //Time Complexity = 0(n) where n is the length of the string
    //Space Complexity 0(1)
    //Did it successfully run on leetcode: Yes
    //Did you face nay problem while coding: No

    public int calculate(String s) {
        char lastsign = '+';    //we take 4 variables, lastsign to keep a track of the last sign encountered in our string
        int calc = 0;   //calc to calulate the present value
        int curr = 0;   //to get the digit
        int tail = 0;   //keeps a track of the last value and its calculations
        for(int i = 0; i < s.length(); i++){    //the loop runs through the length of the string
            char c = s.charAt(i);   //extracting one character at a time
            if(Character.isDigit(c)){   //if it's a digit
                curr = curr * 10 + (c - '0');   //we alculate the no.
            }
            if((c != ' ' && !Character.isDigit(c)) || (i == s.length() - 1)){ //if its not a digit and a sign and if its the last character in our string, we perform the operations for the operators
                if(lastsign == '+'){    //for plus, we update the value of calc and tail. All are formulas that we use
                    calc = calc + curr;
                    tail = +curr;
                }
                else if(lastsign == '-' ){  //if the character is a minus, we do the following
                    calc = calc - curr;
                    tail = -curr;
                }
                else if(lastsign == '*'){   //same for the multiplication sign, we deduce the calc and tail
                    calc = calc - tail + (tail * curr);
                    tail = tail * curr;
                }
                else if(lastsign == '/') {  //similarly for division sign, we deduce the calc and tail
                    calc = (calc - tail) + (tail / curr);
                    tail = tail / curr;
                }
                curr = 0;   //after the operator is taken care of, we change the value of current to 0 as the current expression is calculaed
                lastsign = c;   //also we forward the last operator we encountered to the upcoming operations for further calculations
            }
        }
        return calc;
    }
}

//Stack Approach

class Solution {

    //Time Complexity = 0(n) where n is the length of the string
    //Space Complexity 0(n) where n is the elemments stored in stack
    //Did it successfully run on leetcode: Yes
    //Did you face nay problem while coding: No

    public int calculate(String s) {
        char lastsign = '+';
        int calc = 0;
        int curr = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                curr = curr * 10 + (c - '0');
            }
            if((c != ' ' && !Character.isDigit(c)) || (i == s.length() - 1)){
                if(lastsign == '+'){
                    st.push(curr);
                }
                else if(lastsign == '-' ){
                    st.push(-curr);
                }
                else if(lastsign == '*'){
                    st.push(st.pop() * curr );
                }
                else if(lastsign == '/') {
                    st.push(st.pop() / curr);
                }
                curr = 0;
                lastsign = c;
            }
        }
        while(!st.isEmpty()){
            calc = calc + st.pop();
        }
        return calc;
    }
}