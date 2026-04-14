//
//  IntegerToEnglish.swift
//  DSA-Practice
//
//  Created by Paridhi Malviya on 4/12/26.
//

/*
 just decode chunk of 3  digits.
 if (num < 20 ) return from below twenty array
 //if number is 374
 for 374 - divide by 100 -  we will get 3 - get english from below_twienty[num/100] + hundred
 now, mode by 100 -> left with 74. helper(num % 100)
 74 -> divide by 10. -> for answer - 7. pick from tens array
 mod by 10 -> 4  from below twenty array
 
 391000374 - three hundred ninty one million three hundred seventy four.
 If a chunk is zero then 
 
chunking and recursion pattern
 time complexity - O(1) limited no of digits
 */

class IntegerToEnglishWords {
        var thousands = ["", "Thousand", "Million", "Billion"]
        var below_20 = ["", "One", "Two", "Three", "Four", "Five", "Six","Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"]
        var tens = ["", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"]

    func numberToWords(_ num: Int) -> String {
        if (num == 0) {
            return "Zero"
        }
        var result = ""
        var idx = 0 //indx on triplet suffix
        var num = num
        while (num > 0) {
            var triplet = num % 1000
            if (triplet != 0) {
                //decode triplet and add suffix
                //result - earlier result
                let words = helper(triplet)
                let suffix = thousands[idx]
                result = words + (suffix.isEmpty ? "": " " + suffix) + (result.isEmpty ? "" : " " + result)
            }
            num = num / 1000
            idx += 1
        }
        return result
    }

    //it will decode triplet
     private func helper(_ num: Int) -> String {
        if (num == 0) {
            return ""
        } else if (num < 20) {
            return below_20[num]
        } else if (num < 100) {
            return tens[num / 10] + (num % 10 == 0 ? "" : " " + helper(num % 10))
        } else {
            //still a triplet
            return below_20[num / 100] + " Hundred" + (num % 100 == 0 ? "" : " " + helper(num % 100))
        }
    }

}
