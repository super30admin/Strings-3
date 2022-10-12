
Integer to English Words

public class Solution {
  public String numberToWords(int num) {
	 if(num==0) return "Zero";
        String res="";
        res=helper(num%1000);
        num/=1000;
       if(num!=0){
          String tmp=helper(num);
           if(tmp.length()!=0) res=tmp+"Thousand "+res;
           else res=tmp+res;
    	   num/=1000;
    	   if(num!=0){
    	   tmp=helper(num);
           if(tmp.length()!=0) res=tmp+"Million "+res;
           else res=tmp+res;
	    	   num/=1000;
	    	   if(num!=0){
	    		   res=helper(num)+"Billion "+res;
		    	  
	    	   }
    	   }
    	 
       }
       return res.charAt(res.length()-1)==' '?res.substring(0,res.length()-1):res;
    }
private String helper(int num){

	if(num==10) return "Ten ";
    String res="";
    if(num==0){
        return "";
    }
    if(num%100==10) res="Ten ";
    else res=""+itos(num%10);
    num/=10;
    if(num!=0){
       if(num%10==1){
    	 if(res.equals("One ")) res="Eleven ";
    	   if(res.equals("Two ")) res="Twelve "; 
    	   if(res.equals("Three ")) res="Thirteen ";
           if(res.equals("Four ")) res="Fourteen ";
    	   if(res.equals("Five ")) res="Fifteen ";
    	   if(res.equals("Six ")) res="Sixteen ";
    	   if(res.equals("Seven ")) res="Seventeen ";
    	   if(res.equals("Eight ")) res="Eighteen ";
    	   if(res.equals("Nine ")) res="Nineteen ";	   
       }
       if(num%10==2) res="Twenty "+res;
       if(num%10==3) res="Thirty "+res;
       if(num%10==4) res="Forty "+res;
       if(num%10==5) res="Fifty "+res;
       if(num%10==6) res="Sixty "+res;
       if(num%10==7) res="Seventy "+res;
       if(num%10==8) res="Eighty "+res;
       if(num%10==9) res="Ninety "+res;
       
       
       
        num/=10;
        if(num!=0){
        	if(num%10!=0)  res=itos(num%10)+"Hundred "+res;
        }
    }
    
    return res;
}
private String itos(int i){
    
    if(i==1) return "One ";
    if(i==2) return "Two ";
    if(i==3) return "Three ";
    if(i==4) return "Four ";
    if(i==5) return "Five ";
    if(i==6) return "Six ";
    if(i==7) return "Seven ";
    if(i==8) return "Eight ";
    if(i==9) return "Nine ";
    return "";
}


Basic Calculator II

public int calculate(String s) {
    int pre = 0, curr = 0, sign = 1, num = 0;
    char op = '+';
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (Character.isDigit(c)) {
            num = num * 10 + (c - '0');
            if (i == s.length() - 1 || !Character.isDigit(s.charAt(i + 1))) {
                switch(op){
                    case '+' : curr = num; break;
                    case '-' : curr = num; break;
                    case '*' : curr = curr * num; break;
                    case '/' : curr = curr / num; break;
                }
            }
        } else if(c == '+' || c == '-' || c == '*' || c == '/'){
            op = c;
            num = 0;
            if(c == '+' || c == '-'){
                pre += sign * curr;
                sign = c == '+' ? 1 : -1;
            } 
        }
    }
    return pre + sign * curr;
}


