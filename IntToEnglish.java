//T: O(N)
//S: O(1)
class Solution {
           
 String[] units={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten" };
        
String [] tens={"","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"} ;  
String [] places={"","Thousand ","Million ","Billion "};    
 
    String[] tees={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"}; 
    
    public String numberToWords(int num) {
        if(num==0){return "Zero";}
       int feed=num;
        String ans="";
        int pl=0;
        while(feed!=0 ){
            
            String ret=helper(feed%1000);
            
            feed=feed/1000;
            if(!ret.equals("")){
              ans=ret+" "+places[pl]+ans;
                
            }
            pl++;
        }
        
        
        return ans.trim();
    }
    
    public String helper(int num){
        
        if(num<=10){
            
            return units[num];
        }else if(num<20){
            return tens[num%10];
            
        }else if(num<=99){
            if(num%10==0){ return tees[num/10];}
            return tees[num/10] +" "+helper(num%10);
        }else{
            
           if(num%100==0){return units[num/100]+" Hundred";}
            
        return units[num/100]+" Hundred "+helper(num%100);
        }
         
        
    }
    
    
    
}
