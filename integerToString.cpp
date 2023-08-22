//time -O(n)
// space - O(1)
class Solution {
public:
    static inline std::string &ltrim(std::string &s) {
    s.erase(s.begin(), std::find_if(s.begin(), s.end(),
            std::not1(std::ptr_fun<int, int>(std::isspace))));
    return s;
}

// trim from end
static inline std::string &rtrim(std::string &s) {
    s.erase(std::find_if(s.rbegin(), s.rend(),
            std::not1(std::ptr_fun<int, int>(std::isspace))).base(), s.end());
    return s;
}

// trim from both ends
static inline std::string &trim(std::string &s) {
    return ltrim(rtrim(s));
}
    string belowTwenty[20] = {
        "", "One", "Two", "Three", "Four", "Five", 
        "Six", "Seven", "Eight", "Nine", "Ten", 
        "Eleven", "Twelve", "Thirteen", "Fourteen", 
        "Fifteen", "Sixteen", "Seventeen", "Eighteen", 
        "Nineteen"
    };

    string tens[10] = {
        "", "", "Twenty", "Thirty", "Forty", "Fifty", 
        "Sixty", "Seventy", "Eighty", "Ninety"
    };

    string thousands[4] = {"", "Thousand", "Million", "Billion"};
        
    
    string numberToWords(int num) {
        string s = "";
        int i=0;

        if(num==0){
            return "Zero";
        }

        while(num>0){
            int triplet = num%1000;
            if(triplet !=0 ){
                s = helper(triplet)+" "+thousands[i]+" "+s;



            }
            num=num/1000;
            i++;
        }
        
        return trim(s);
        
    }

    string helper(int num){
        

        if(num<20){
             return trim(belowTwenty[num])+" ";


        }
        else if(num<100){
             return trim(tens[num / 10]) + " " + helper(num % 10);


        }
        else{
            return trim(belowTwenty[num / 100]) + " Hundred " + helper(num % 100);


        }
    }
    
};
