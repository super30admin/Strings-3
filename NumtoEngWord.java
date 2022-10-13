public class NumtoEngWord {
    //tc = o(16)=>o(1)
    //sc=o(1)

        static String[] below_20 ={"","One","Two","Three","Four","Five","Six","Seven",
        "Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen",
        "Seventeen","Eighteen","Nineteen"};
    
        static String[] tens = {"", "Ten","Twenty","Thirty","Forty","Fifty","Sixty",
        "Seventy","Eighty","Ninety"};
    
        static String[] thousands ={"", "Thousand", "Million", "Billion"};

public static void main(String[] args)
{
    int num = 545;
    String res = numberToWords(num);
    System.out.println(res);
}


    
        public static String numberToWords(int num) {
            if(num == 0) return "Zero";
            int i=0;
            String result = "";
            while(num > 0)
            {
                if(num % 1000 != 0)
                {
                    result = helper(num % 1000) + thousands[i] + " " + result;
                }
                i++;
                num = num/1000;
            }
            return result.trim();
            
        }
    
        private static String helper(int num)
        {
            if(num == 0) return "";
            else if(num < 20) return below_20[num] +" ";
            else if(num < 100) return tens[num/10] + " " + helper(num%10);
            else return below_20[num/100] + " Hundred" + helper(num % 100);
        }
    
}
