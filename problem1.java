public class problem1 {
    String[] thousands= new String[]{"","Thousand ", "Million ","Billion "};
    String[] below20= new String[]{"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ",
            "Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ",
            "Nineteen " };
    String[] tens=new String[] {"","","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy "," Eighty ","Ninety "};

    public String numberToWords(int num) {

        if (num==0)
        {
            return "Zero";
        }
        String result="";
        int i=0;

        while (num>0)
        {
            int triplet= num%1000;
            if (triplet>0)
            {
                result = helper(triplet) + thousands[i] + result;

            }
            num/=1000;
            i++;
        }
        return result.trim();
    }

    private String helper(int num){
        if (num==0)
        {
            return "";
        }
        else if (num<20)
        {
            return below20[num];
        } else if (num<100) {
            return tens[num/10] + below20[num%10];
            
        }
        else {return below20[num/100] +"Hundred "+ helper(num%100);
        }
    }

}
