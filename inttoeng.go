// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
/*
set s as length of num
v = ""
c = 0
loop over length of number in 3s
get n1, n2, n3 digits
append to temp c3(n3, 1)
if all 3 are 0 then just increment c and continue
if n2 is 1 then use c1 with n2*10+n1
else append temp to c2(n2) and c3(n1, 0)

if c is 0 then v = temp else v = temp + denom[c+1] + v
increment c
return trimmed v

c1 returns 10 to 19 in string
c2 returns 20 to 90 in string
c3 returns 0 to 9 along with denomination
*/
package main

import (
	"fmt"
	"strconv"
	"strings"
)

var denom []string
func numberToWords(num int) string {
	denom = []string{"", "Hundred ", "Thousand ", "Million ", "Billion "}
	if num == 0 {
		return "Zero"
	}
	s := len(strconv.Itoa(num))
	v := ""
	c := 0


	for i:=0;i<s;i=i+3 {
		temp := ""
		n1 := num%10
		num = num/10
		n2 := num%10
		num = num/10
		n3 := num%10
		num = num/10
		temp += c3(n3, 1)
		if n1 ==0 && n2 ==0 && n3== 0 {
			c++
			continue
		}
		if n2 == 1 {
			temp += c1(n2*10+n1)
		} else {
			temp += c2(n2)
			temp += c3(n1, 0)
		}
		if c == 0 {
			v = temp
		} else {
			v = temp + denom[c+1] + v
		}
		c++
	}
	return strings.TrimSpace(v)
}

func c3(x int, d int) string {
	switch(x) {
	case 0: return ""
	case 1: return "One " + denom[d]
	case 2: return "Two " + denom[d]
	case 3: return "Three " + denom[d]
	case 4: return "Four " + denom[d]
	case 5: return "Five " + denom[d]
	case 6: return "Six " + denom[d]
	case 7: return "Seven " + denom[d]
	case 8: return "Eight " + denom[d]
	case 9: return "Nine " + denom[d]
	}
	return ""
}

func c1(x int) string {
	switch(x) {
	case 10: return "Ten "
	case 11: return "Eleven "
	case 12: return "Twelve "
	case 13: return "Thirteen "
	case 14: return "Fourteen "
	case 15: return "Fifteen "
	case 16: return "Sixteen "
	case 17: return "Seventeen "
	case 18: return "Eighteen "
	case 19: return "Nineteen "
	}
	return ""
}

func c2(x int) string {
	switch(x) {
	case 0: return ""
	case 2: return "Twenty "
	case 3: return "Thirty "
	case 4: return "Forty "
	case 5: return "Fifty "
	case 6: return "Sixty "
	case 7: return "Seventy "
	case 8: return "Eighty "
	case 9: return "Ninety "
	}
	return ""
}

func MainIntToEng() {
	fmt.Println(numberToWords(1234567891)) //expected One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One
}