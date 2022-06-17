class Solution {
    public int calculate(String s) {
        Stack<Integer> stack=new Stack<>();
        int len=s.length();
        int num=0;
        int sign=1;
        char dm=' ';
        for(int i=0;i<len;i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)){
                int temp=0;
                while(i<len && Character.isDigit(s.charAt(i))){
                    temp=temp*10+s.charAt(i)-'0';
                    i++;
                }
                i--;
                if(dm=='*')num=num*temp;
                else if(dm=='/')num=num/temp;
                else num=temp;
                dm=' ';
            }
            else if(c=='*') dm='*';
            else if(c=='/')dm='/';
            else if(c=='+'){stack.push(sign*num);sign=1;}
            else if(c=='-'){stack.push(sign*num);sign=-1;}
        }
        num*=sign;
        while(!stack.isEmpty()){
            num+=stack.pop();
        }
        return num;
    }
}
