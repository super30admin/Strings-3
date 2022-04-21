//Time Complexity : O(1)
//Space Complexity : O(1)
public class IntegerToEnglishWords {		
	String[] belowTwenty= {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",
            "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
	String[] tens= {"","Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
	String[] thousands= {"","Thousand","Million","Billion"};	
		
	public String numberToWords(int num) {        
        if(num==0) return "Zero";        
        String result="";
        int i=0;//pointer on thousands array
        while(num>0){
            //get the triplets
            if(num % 1000 !=0){
                result= helper(num%1000) + thousands[i]+" "+result;
            }
            i++;
            num= num/1000;
        }
        return result.trim();
    }
    private String helper(int num){
        if(num == 0) return "";
        else if (num < 20){
            return belowTwenty[num]+ " ";
        } else if (num < 100){
            return tens[num/10] + " " + helper(num%10);
        } else {
            return belowTwenty[num/100] + " Hundred " + helper(num%100);
        }        
    }
	
	// Driver code to test above
	public static void main (String[] args) {
		IntegerToEnglishWords ob = new IntegerToEnglishWords();	
		int num = 1234567;
		
		System.out.println(ob.numberToWords(num));      
	}	
}
