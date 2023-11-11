import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


class RandomizedSet {
    Random random;
    HashMap<Integer, Integer> dict;
    ArrayList<Integer> list;

    public RandomizedSet() {
        dict = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if (dict.containsKey(val)) return false;
        dict.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if (!dict.containsKey(val)) return false;
        int index = dict.get(val);
        int last = list.get(list.size() - 1);
        dict.put(last, index);
        list.set(index, last);
        dict.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
