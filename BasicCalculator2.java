import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(1)
public class BasicCalculator2 {	
	/**Approach2: Without Stack**/	
    public int calculate(String s) {
        int curr=0; 
        int calc=0;
        int tail=0;
        char lastSign= '+';   
        
        for(int i=0; i<s.length(); i++){
            char c= s.charAt(i);
            //If character is digit
            if(Character.isDigit(c)){
                curr= curr * 10 + c-'0';
            }
            //If last char or expression, evaluate and add to stack
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(lastSign == '+'){
                    calc += curr;
                    tail= curr;
                }
                else if (lastSign == '-'){
                    calc -= curr;
                    tail= -curr;
                }
                else if (lastSign == '*'){
                    calc = calc-tail + tail*curr;
                    tail= tail*curr;
                }
                else if (lastSign == '/'){
                    calc = calc-tail + tail/curr;
                    tail= tail/curr;
                }                
                curr=0;
                lastSign= c;
            }
        }
                
        return calc;
    }
    
	// Driver code to test above
	public static void main (String[] args) {
		BasicCalculator2 ob = new BasicCalculator2();	
		String s ="3-2*2";
		
		System.out.println("Calculated value of given string: "+ob.calculate(s));      
	}	
}
