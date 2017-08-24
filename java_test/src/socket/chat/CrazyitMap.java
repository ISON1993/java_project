package socket.chat;

import java.util.*;

/**
 * Created by tuzhenyu on 17-8-24.
 * @author tuzhenyu
 */
public class CrazyitMap<K,V> {
    public Map<K,V> map = Collections.synchronizedMap(new HashMap<K, V>());

    public void put(K key,V value){
        map.put(key,value);
    }

    public K getKeyByValue(V val){
        for (K key : map.keySet()){
            if (map.get(key) == val || map.get(key).equals(val)){
                return key;
            }
        }

        return null;
    }

    public Set<V> valueSet(){
        Set<V> set = new HashSet<V>();
        for (K key : map.keySet()){
            set.add(map.get(key));
        }
        return set;
    }

}
