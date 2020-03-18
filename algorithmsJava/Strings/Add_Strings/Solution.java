/* 
Problem :: 
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:
1) The length of both num1 and num2 is < 5100.
2) Both num1 and num2 contains only digits 0-9.
3) Both num1 and num2 does not contain any leading zero.
4) You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/

/*
Analysis ::
Time Complexity :: O(m+n) where m,n are the sizes of the array.
Space Complexity :: O(m+n)
*/

/* cleaner approach to write a code */
class Solution {
    public String addStrings(String num1, String num2) {
        if(num1 == null || num1.length() == 0) {
            return num2;
        }
        if(num2 == null || num2.length() == 0) {
            return num1;
        }
        int carry = 0;
        StringBuilder result = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1;
        while(i >= 0 || j >= 0) {
            int n1 = (i >= 0 ? num1.charAt(i) - '0' : 0);
            int n2 = (j >= 0 ? num2.charAt(j) - '0' : 0);
            int num = n1 + n2 + carry;
            carry = num/10;
            result.append(num % 10);
            i--;
            j--;
        }
        if(carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}


class Solution {
    public String addStrings(String num1, String num2) {
    
        int l1 = num1.length()-1;
        int l2 = num2.length()-1;
        StringBuilder result = new StringBuilder();
        int carry = 0;
        
        while(l1>=0 && l2>=0){
            int temp1 =  Integer.parseInt( String.valueOf(num1.charAt(l1)) );
            int temp2 =  Integer.parseInt( String.valueOf(num2.charAt(l2)) );
            
            result.append((temp1 +temp2+ carry)%10);
            carry = (temp1+temp2+carry)/10;
            l1--; l2--;
        }
            
        while(l1>=0){
            int temp1 = Integer.parseInt( String.valueOf(num1.charAt(l1))  );
            result.append((temp1 + carry)%10);
            carry = (temp1+carry)/10;
            l1--;
        }
        
        while(l2>=0){
            int temp1 =  Integer.parseInt( String.valueOf(num2.charAt(l2)) );
            result.append((temp1 + carry)%10); 
            carry = (temp1+carry)/10;
            l2--;
              
        }
        
    if(carry!=0){
        result.append(carry);
    }
        
    result.reverse();
    return  result.toString();
    }
}