public class BasicCalcII {

    //TC - O(n)
    //SC - O(1)

    public int calculate(String s) {
        if(s== null || s.length() ==0) return 0;
        s= s.trim();
        int calc=0, tail=0,num=0;
        char lastSign ='+';
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num*10 +(c-'0');
            if((!Character.isDigit(c) && c!=' ') ||(i==s.length()-1)){
                if(lastSign=='+'){
                    calc = calc+num;
                    tail = +num;
                }
                if(lastSign=='-'){
                    calc = calc - num;
                    tail = -num;
                }
                if(lastSign=='*'){
                    calc = calc - tail+ (tail*num);
                    tail = tail*num;
                }
                if(lastSign=='/'){
                    calc = calc - tail+ (tail/num);
                    tail = tail/num;
                }
                lastSign =c;
                num =0;

            }
        }
        return calc;
    }
    //TC - O(n)
    //SC - O(n)
    //Stack based approach
    /*
 public int calculate(String s) {
        if(s== null || s.length() ==0) return 0;
        s= s.trim();
        Stack <Integer>st = new Stack<>();
        int calc =0, num=0;
        char lastSign ='+';
        for(int i = 0; i<s.length();i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)) num = num*10 +(c-'0');
            if((!Character.isDigit(c) && c!=' ') ||(i==s.length()-1)){
                if(lastSign=='+'){
                  st.push(+num);
                }
                 if(lastSign=='-'){
                    st.push(-num);
                }
                 if(lastSign=='*'){
                   st.push(st.pop()*num);
                }
                 if(lastSign=='/'){
                    st.push(st.pop()/num);
                }
                lastSign =c;
                num =0;

            }
        }
while(!st.isEmpty()) calc =st.pop()+calc;

        return calc;
    }
    */



}
