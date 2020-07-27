// Time Complexity :O(1) // O(4*3)
// Space Complexity : O(1) // Every data structure useda auxillary one
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Balancing spaces was a bit difficult
// Your code here along with comments explaining your approach
//1. Crete string arrays to write unique number names
//2. Idea is to split the string in 3 equal parts and derive the relevant number.
//3. Add it to the relevant  "Thousand ", "Million ", "Billion " string

class Solution {
public:
    vector<string> below_20{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    vector<string> tens{"","Ten","Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    vector<string> level{"", "Thousand ", "Million ", "Billion "};
    string numberToWords(int num) {
        //edge
        if(num==0) return "Zero";
        
        //logic
        string result; int i=0;
        while(num>0){
            string temp = convert_string(num%1000);
            num = num/1000;
            if(temp=="") ;
            else if(temp !="") result = temp+" "+level[i]+result;
            i++;
        }
        while(result[result.size()-1] ==' ') result.pop_back();
        return result;
    }
    
    string convert_string(int num){
        if(num<20) return (below_20[num]);
        if(num<100) {
            int units_place = num%10;
            if(units_place > 0)  return(tens[num/10]+" "+below_20[units_place]);
            else return(tens[num/10]);
        }
        if(num>=100){
            int hundredth_place = num/100;  
            string hundredth_str = below_20[hundredth_place]+" Hundred";
            if(num%100 >0) return(hundredth_str +" "+ convert_string(num%100));
            else return(hundredth_str);
        } 
        
        return "aaaa";
    }
    
};
