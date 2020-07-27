class Solution:
    
    """
        Name : Shahreen Shahjahan Psyche
        Time : O(N) [Length of the string]
        Space: O(H) [Size of the Stack]

        Passed all Test cases in LC : Yes
    """
    
    
    def getNumber(self, s, index):
        val = 0
        while index<len(s) and ord(s[index]) - ord("0") < 10 and ord(s[index]) - ord("0") >= 0:
            val = val * 10 + ord(s[index]) - ord("0")
            index += 1
        return index, val
    
    def calculate(self, s: str) -> int:
        
        if not s:
            return float('inf')
        
        s = ''.join(s.split())
        i = 0
        curr_sign = "+"
        i, v = self.getNumber(s, i)
        track = []
        track.append(v)
        
        while(i<len(s)):
            ch = s[i]
            if ch == "*":
                index, val = self.getNumber(s, i+1)
                curr = track.pop()
                curr *= val
                track.append(curr)
            elif ch == "/":
                index, val = self.getNumber(s, i+1)
                curr = track.pop()
                curr /= val
                curr = int(curr)
                track.append(curr)
            elif ch == "-":
                index, val = self.getNumber(s, i+1)
                track.append(-val)
            else:
                index, val = self.getNumber(s, i+1)
                track.append(val)
            i = index
        
        return sum(track)
            
            
                
                
            
            
            
            
        
