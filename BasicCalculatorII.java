


/*
//TC: O(n)
//Sc: O(n)
class Solution {
 public int calculate(String s) {
     Stack<Integer> stk=new Stack<>();
     int currNum=0;
     char lastsign='+';
     for(int i=0;i<s.length();i++){
         char ch=s.charAt(i);
         if(Character.isDigit(ch)){
             currNum=currNum*10+ch-'0';
         }
         if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
             if(lastsign=='+'){
                 stk.push(currNum);
             }else if(lastsign == '-'){
                 stk.push(-currNum);
             }else if(lastsign=='*'){
                 int v=stk.pop();
                 stk.push(v*currNum);
             }else if(lastsign=='/'){
                 int v=stk.pop();
                 stk.push(v/currNum);
             }
             lastsign=ch;
             currNum=0;
         }
     }


     int curr=0;
     while(!stk.isEmpty()){
         curr=curr+stk.pop();
     }
     return curr;
 }
}
*/

//TC: O(N)
//SC: O(1)
class BasicCalculatorII {
 public int calculate(String s) {
     int n=s.length();
     char lastsign='+';
     int currnum=0;
     int tail=0;
     int cal=0;
     for(int i=0;i<n;i++){
         char ch=s.charAt(i);
         if(Character.isDigit(ch)){
             currnum=currnum*10+ch-'0';
         }
         if((!Character.isDigit(ch) && ch!=' ') || i==s.length()-1){
             if(lastsign=='+'){
                 cal=cal+currnum;
                 tail=currnum;
             }else if(lastsign == '-'){
                 cal=cal-currnum;
                 tail=-currnum;
             }else if(lastsign=='*'){
                 cal=cal-tail+(tail*currnum);
                 tail=tail*currnum;
             }else if(lastsign=='/'){
                 cal=cal-tail+(tail/currnum);
                 tail=tail/currnum;
             }
             lastsign=ch;
             currnum=0;
         }
     }
     return cal;
 }
}
