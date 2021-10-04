class IntegerToWords {
    int [] nos = new int[] {-1,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,30,40,50,60,70,80,90,100,1000,1000000,1000000000};
    
    String[] words = new String[] {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven","Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety", "Hundred", "Thousand", "Million", "Billion"};
    
    String[] tens = new String[] {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) {
            return "Zero";
        }
        
        StringBuilder sb = new StringBuilder();
        numToWords(num, sb);
        
        return sb.toString().trim();
    }
    
    public void numToWords(int num, StringBuilder sb) {
        
        if (num >= 1000000000) {
            int value = num/1000000000;
            if (value > 0) {
                threeNums(value, sb);
                sb.append("Billion ");
            }
            num %= 1000000000;
        }
        
        if (num >= 1000000) {
            int value = num/1000000;
            if (value > 0) {
                threeNums(value, sb);
                sb.append("Million ");
            }
            num %= 1000000;
        }
        
        if (num >= 1000) {
            int value = num/1000;
            if (value > 0) {
                threeNums(value, sb);
                sb.append("Thousand ");
            }
            num %= 1000;
        }
        threeNums(num, sb);
        
    }
    
    public void threeNums(int count, StringBuilder sb) {
        if (count >= 100) {
            int h = count/100;
            sb.append(words[h]).append(" Hundred ");
            count = count % 100;
        }
        
        if (count > 20 && count < 100) {
            int h = count/10;
            sb.append(tens[h]).append(" ");
            count = count%10;
        }
        
        if (count > 0) {
            sb.append(words[count]).append(" ");
        }
    }
}