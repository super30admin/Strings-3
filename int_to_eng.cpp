//TC: O(n) where n is the number of digits in the input
//SC: O(1) since there is no extra space being consumed.

class Solution {
public:
    
    
    
    
    string numberToWords(int num) {
        unordered_map<int, string> firstmap;
        firstmap[0] = "Zero";
        firstmap[1] = "One";
        firstmap[2] = "Two";
        firstmap[3] = "Three";
        firstmap[4] = "Four";
        firstmap[5] = "Five";
        firstmap[6] = "Six";
        firstmap[7] = "Seven";
        firstmap[8] = "Eight";
        firstmap[9] = "Nine";
        firstmap[10] = "Ten";
        firstmap[11] = "Eleven";
        firstmap[12] = "Twelve";
        firstmap[13] = "Thirteen";
        firstmap[14] = "Fourteen";
        firstmap[15] = "Fifteen";
        firstmap[16] = "Sixteen";
        firstmap[17] = "Seventeen";
        firstmap[18] = "Eighteen";
        firstmap[19] = "Nineteen";

        unordered_map<int, string> secmap;
        secmap[20] = "Twenty";
        secmap[30] = "Thirty";
        secmap[40] = "Forty";
        secmap[50] = "Fifty";
        secmap[60] = "Sixty";
        secmap[70] = "Seventy";
        secmap[80] = "Eighty";
        secmap[90] = "Ninety";
        
        
        int setno = 0;
        string result = "";
        
        if(num == 0)
            return "Zero";
        
        //iterate until number becomes 0
        while(num > 0){
            
            //get three numbers in every set
            int tempnum = num%1000;
            
            //for the next iteration, get the next three numbers
            num = num/1000;
            
            //if the current three numbers are 0, then just increment the set and continue
            if(tempnum == 0){
                setno += 1;
                continue;
            }
            
            //if this is the first set of 3, then dont add any suffix
            if(setno == 0){
                //cout<<"first set"<<endl;
            } else if(setno == 1){
                //cout<<"Second set"<<endl;
                //if this is the second set of three, then add thousand before evaluating what the set will be. eg, 123456 will be 123 Thousand 456 where we evaluate 123 later
                result = " Thousand " + result;
            } else if(setno == 2){
                //similarly for million and billion
                //cout<<"Third set"<<endl;
                result = " Million " + result;
            } else if(setno == 3){
                //cout<<"Fourth set"<<endl;
                result = " Billion " + result;
            }




            //each 3 digit set

            //now in each three digit set, consider each pair and then the hundreds place
            int eachpair = tempnum%100;
            int hundpos = tempnum/100;
            bool isHund = false;
            
            //if the pair is less than 20, then directly get values from the first map
            if(eachpair < 20){
                //cout<<"pair less than 20"<<endl;
                if(eachpair != 0){
                    result = firstmap[eachpair] + result;                    
                } else {
                    isHund = true;
                }
            } else{
                //if the pair is greater than 20, then isolate each value and check
                int firstpos = eachpair%10;
                int secpos = eachpair%100;
                
                if(firstpos == 0){
                    //if the units place is 0, then just look up the pair from the second map. Eg. 20, 30, 40
                    result = secmap[eachpair] + result;
                } else{
                    //pair iterator
                    //pair iterator here is to check if we are in units place or tens place
                    int pairnum = 0;                    

                    while(eachpair > 0){
                        int eachnum = eachpair%10;
                        //if we are in units place, then just simply get the units place value from first map and add to the result
                        if(pairnum == 0){
                            result = firstmap[eachnum]  + result;
                        } else{
                            //if we are in tens place then multiply the tens place value with 10 and get the new value from the second map.
                            result = secmap[eachnum*10] +  " " + result;
                        }
                        pairnum++;
                        eachpair = eachpair/10;
                    }
                    
                }
                
                
            }

            //after we are done with the pair check, then look at the hundreds position. If this is 0, then skip. If not then get the value from the first map and append to "Hundred"
            
            if(hundpos != 0){
                    result = firstmap[hundpos] + " Hundred " + result;
            }
        
                        
            //increment set number at the end of the while loop    
            setno += 1;
        }
        
        
        //remove all extra spaces in the middle
        for(int i=0; i<result.size()-1; i++){
            if(result[i] == ' ' && result[i+1] == ' '){
                //erase format: erase(position to erase from, characters to erase)
                result.erase(i+1, 1);
            }
        }
        
        //if there is a trailing space, then trim this.
        if(result[result.size()-1] == ' ')
            result.pop_back();
        
        return result;
        
    }
};