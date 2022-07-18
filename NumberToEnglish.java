public class NumberToEnglish {
    // TC is O(1)
    // SC is O(1)
    String[] below20 = {"","One ","Two ","Three ","Four ","Five ","Six ","Seven ","Eight ","Nine ","Ten ","Eleven ","Twelve ","Thirteen ","Fourteen ","Fifteen ","Sixteen ","Seventeen ","Eighteen ","Nineteen "};
        String[] tens = {"","Ten ","Twenty ","Thirty ","Forty ","Fifty ","Sixty ","Seventy ","Eighty ","Ninety "};
        String[] hundreds = {"","Thousand ","Million ","Billion "};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        int temp = num;
        String str = new String();
        int i=0;
        while(temp > 0){
            int partition = temp%1000;
            temp = temp/1000;
            String intermid = formWords(partition);
            if(!intermid.equals("")){
                str = intermid+hundreds[i]+str;
            }
            
            i++;
        }
        return str.trim();
    }
    
    private String formWords(int partition){
        //base
        if(partition == 0) return "";
        if(partition < 20){
            return below20[partition];
        }else if(partition >= 20 && partition < 100){
            return tens[partition/10]+below20[partition%10];
        }else{
            String sb = new String();
            sb = below20[partition/100]+ "Hundred "+formWords(partition%100);
            return sb;
        }
    }
}
