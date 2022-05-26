// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

string[] thousands = {"", "Thousand", "Million", "Billion"};
string[] below_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", 
                                "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
string[] tens = {"", "Ten", "Twenty",  "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
public string NumberToWords(int num) {
    
    if(num == 0)
        return "Zero";
    
    string result = "";
    int i = 0;
    
    while(num > 0)
    {
        if(num % 1000 != 0){
            result = helper(num % 1000) + thousands[i] + " " + result;
        }
        i++;
        num = num / 1000;            
    }
    
    return result.Trim();
}

private string helper(int num){
    if(num == 0)
        return "";
    else if(num < 20)
        return below_20[num] + " ";
    else if(num < 100)
        return tens[num / 10] + " " + helper(num % 10);
    else
        //OR helper(num/100);
        return below_20[num /100] + " Hundred " + helper(num % 100);
}