// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
        func calculate(_ s: String) -> Int {
        var stack = [Int]()
        var sArray = Array(s)
        var i = 0
        var sign = "+"
        var num = 0
        var output = 0
        while i < sArray.count {
            
            var ch = sArray[i]
            
            if ch.isNumber {
                num = num * 10 + (ch.wholeNumberValue ?? 0)
            }
            if (ch != " " && !ch.isNumber) || i == sArray.count - 1  {
                
                if sign == "+" {
                    stack.append(num)
                } else if sign == "-" {
                    stack.append(-num)
                } else if sign == "*" {
                    var ans = stack.removeLast() * num
                    stack.append(ans)
                } else if sign == "/" {
                    var ans = stack.removeLast() / num
                    stack.append(ans)
                }
                sign = String(ch)
                num = 0
            }
            i += 1
        }
        
        for value in stack {
            output += value
        } 
        return output
    }