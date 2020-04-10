/* 
Problem :: 

Design a data structure that supports all following operations in average O(1) time.

insert(val): Inserts an item val to the set if not already present.
remove(val): Removes an item val from the set if present.
getRandom: Returns a random element from current set of elements. Each element must have the same probability of being returned.
Example:

// Init an empty set.
RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
randomSet.insert(1);

// Returns false as 2 does not exist in the set.
randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
randomSet.remove(1);

// 2 was already in the set, so return false.
randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
randomSet.getRandom();

*/

/*
Analysis ::
Time Complexity :: O(1)
Space Complexity :: O()
*/


class RandomizedSet {
    
    Map<Integer,Integer> map;
    List<Integer> list;
    Random rand;
    
    /* constructor */
    public RandomizedSet() {
      this.map = new HashMap<>();
      this.list = new ArrayList<>();
      this.rand = new Random();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val))
          return false; /* since the value already exists */
        
        list.add(val);
        map.put(val,list.size()-1); 
        /* list.size()-1 will be the index where new element is added */
        return true;
    }
    
    /* Main logic of the entire question lies here*/
    /* Steps if val is not present return false 
       If present then find the index from map
       Replace that index's value with last index value,
       Update the last index value of the Map.
    */
    public boolean remove(int val) {
        if(map.containsKey(val)){
          Integer indexOfVal = map.get(val);
      
          Integer lastVal = list.get(list.size()-1); /* syntax :: list.get(index,element) */
          list.set(indexOfVal, lastVal); 
          map.put(lastVal,indexOfVal);
          
          list.remove(list.size()-1);
          map.remove(val);
          return true;
        }
      return false;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
      Integer index = rand.nextInt(list.size());
      return list.get(index);
        
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int pa
