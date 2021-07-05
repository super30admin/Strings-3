// ## Problem1 
//  Integer to English Words (https://leetcode.com/problems/integer-to-english-words/)

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Approach: Check if number is in billion, if it is not in billion then check if it is in million.
// if it is not in million then check if it is in thousands and so on.

let lessThan20 = ["", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"];
let tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"];
let thousands = ["Billion", "Million", "Thousand", ""];
let radix = [1000000000, 1000000, 1000, 1];
const trans = function(num) {
    if(num == 0) return "";
    else if (num < 20) return lessThan20[num] + " ";
    else if (num < 100) return tens[Math.floor(num / 10)] + " " + trans( num % 10 );
    else return lessThan20[Math.floor(num / 100)] + " Hundred " + trans( num % 100 );
}
const numberToWords = function(num) {
    if(num === 0) return 'Zero';
    let str = '';
    for(let i = 0; i < radix.length; i++) {
        // current number is less than radix[i]
        if (Math.floor(num / radix[i]) === 0) continue;
        else {
            str = str + trans( Math.floor(num / radix[i]) ) + thousands[i] + ' ';
            num = num % radix[i];
        }
    }
    return str.trim();
};
