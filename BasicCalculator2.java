package week8.day1;
//TC - O(n)
//SC - O(1)
//TC - O(n)
//SC - O(1)
class Solution {
  public int calculate(String s) {
      s = s.trim();
      char lastSign ='+'; 
      int curr =0; 
      int cal =0;
      int tail =0;
      for(int i=0;i<s.length();i++){
          char ch= s.charAt(i);
          if(ch==' ')
              continue;
          if(Character.isDigit(ch)){
              curr = curr*10 + ch-'0';
          }
         if(!Character.isDigit(ch) || i==s.length()-1){
              //operator
              if(lastSign=='+')
              {
                  tail = curr;
                  cal = curr+cal;
              }
              else if(lastSign=='-'){
                  tail = -curr;
                  cal = cal-curr;
              }
              else if(lastSign=='*'){
                  cal = cal-tail+tail*curr;
                  tail = tail*curr;
              }
              else if(lastSign=='/'){
                  cal = cal-tail+tail/curr;
                  tail = tail/curr;
              }
              curr = 0;
              lastSign = ch;
          }
      }
      return cal;
  }

}
public class BasicCalculator2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "3+2*2";
		Solution ob = new Solution();
		System.out.println(ob.calculate(s));

	}

}
