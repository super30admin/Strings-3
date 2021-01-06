class Solution {
public:
 string below20[20] ={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    
    string tens[10]={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    string thousands[4]={"","Thousand","Million", "Billion"};
    
    string helper(int num) {
        if (num==0) {
          return "";  
        } else if (num<20) {
           return below20[num]+" ";
        } else if (num<100) {
            return tens[num/10]+" "+ helper(num%10);//below20[num%10];   
        } else {
            return below20[num/100]+" Hundred "+ helper(num%100);
        }
    }
    string numberToWords(int num) {
        if (num==0)
            return "Zero";
        
        int idx=0;
        string answer;
        while (num>0) {
            if (num%1000!=0) {
                answer=helper(num%1000)+thousands[idx]+" "+answer;
            }
            num=num/1000;
            idx++;
        }
        while (answer[answer.length()-1]==' ')
        answer.erase(answer.begin()+answer.length()-1);
        return answer;
    }
};