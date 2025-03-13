class IntegerToEnglishWords {
    // Words for numbers below 20
String[] below_20 = {
    "", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", 
    "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", 
    "Seventeen", "Eighteen", "Nineteen"
};

// Words for tens
String[] tens = {
    "", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"
};

// Words for larger units like hundred and thousand
String[] thousands = {
    "", "Thousand", "Million", "Billion"
};

    public String numberToWords(int num) {
        
        if(num==0)
        return "Zero";
        String res="";
        int i=0;
        while(num>0)
        {
            int triplet = num%1000;
            if(triplet!=0)
            {
                res = convertTripletToWord(triplet).trim()+" "+thousands[i]+" "+res;
            }
            num = num/1000;
            i++;
        }
        return res.trim();
    }

    private String convertTripletToWord(int cur)
    {
        if(cur<20)
        {
            return below_20[cur];
        }
        else if(cur < 100)
        {
            return tens[cur/10]+" "+convertTripletToWord(cur%10);
        }
        else{
            return below_20[cur/100]+" Hundred " +convertTripletToWord(cur%100);
        }
    }
}

//Time Complexity (TC): O(n), where n is the number of triplets (groups of 3 digits).
//Space Complexity (SC): O(n)