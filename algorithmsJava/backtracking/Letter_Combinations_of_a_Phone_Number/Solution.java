/* 
Problem :: Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



Example:

Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:

Although the above answer is in lexicographical order, your answer could be in any order you want.

For better descripton of problem visit link ::  https://leetcode.com/problems/letter-combinations-of-a-phone-number/

*/

/*
Analysis ::
Time Complexity :: O(n)
Space Complexity :: O(n)
*/

/*
Intuition :: Considering that you have have done below question Subsets and permutations question. You can easily think that we need to have two loops instead of one in this, as first loop will pick a value a single char say a from "abc"(2) and then it needs to make a combination with all char of "def"(3).

Below is a code which is better than 100% submissions in java but i got to it with few changes in my intial code.

Things i learnt from this question.

Since it involves concatenation use String Builder which is faster and better than String, beacuse everytime you concatenate a new String object will be created
Make a hashmap of Map<String,String> . Also note making an array should not be done as if the question is scaeled it is no viable.
Try to think about how would you include 1 and about cases when 1 is included in input string
*/

//Code :: 0ms

class Solution {
    
  /* initially made Map<Integer,String> */
    Map<String,String> store = new HashMap<>(); /* no conversion requuired now */
    
    private void helper(String digits, List<String> result, int pos, StringBuilder sb){
      if(sb.length()==digits.length()){
        result.add(new String(sb.toString()));
        return;
      }
      for(int i=pos; i< digits.length();i++){
        String temp = store.get(String.valueOf(digits.charAt(i)));
        for(int j=0;j<temp.length();j++){
          sb.append(temp.charAt(j));
          helper(digits,result, i+1,sb);
          sb.deleteCharAt(sb.length()-1);
        }
    }
  }
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if(digits.length() ==0 || digits == null){
        return result;
      }
      store.put("1","");
      store.put("2","abc");
      store.put("3","def");
      store.put("4","ghi");
      store.put("5","jkl");
      store.put("6","mno");
      store.put("7","pqrs");
      store.put("8","tuv");
      store.put("9","xyzw");
      helper(digits, result,0, new StringBuilder());
      return result;
    }
    
}
//Code intially :: 5ms

class Solution {
    
    Map<Integer,String> store = new HashMap<>();
    
    private void helper(String digits, List<String> result, int pos, String tempS){
      if(tempS.length()==digits.length()){
        result.add(new String(tempS));
        return;
      }
      for(int i=pos; i< digits.length();i++){
        char c = digits.charAt(i);
        String temp = store.get(Integer.parseInt(String.valueOf(c)));
        for(int j=0;j<temp.length();j++){
          tempS += temp.charAt(j);
          helper(digits,result, i+1,tempS);
          tempS = tempS.substring(0,tempS.length()-1);
        }
      
        }
    }
  
    public List<String> letterCombinations(String digits) {
      List<String> result = new ArrayList<>();
      if(digits.length() ==0 || digits == null){
        return result;
      }
      store.put(1,"");
      store.put(2,"abc");
      store.put(3,"def");
      store.put(4,"ghi");
      store.put(5,"jkl");
      store.put(6,"mno");
      store.put(7,"pqrs");
      store.put(8,"tuv");
      store.put(9,"xyzw");
      helper(digits, result,0, new String());
      return result;
    }
    
}
