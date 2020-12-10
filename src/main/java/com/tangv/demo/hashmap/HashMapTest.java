package com.tangv.demo.hashmap;

import java.util.*;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/6/10 3:57 下午
 */
public class HashMapTest {

    public static void main(String[] args) {

        Map<Integer,String> hashMap = new HashMap<>();
        hashMap.put(3,"商家");
        hashMap.put(1,"主播");
        hashMap.put(2,"机构");
        hashMap.put(4,"店铺");
        Set<Map.Entry<Integer, String>> entrySet = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> next = iterator.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println("key:"+key+",value:"+value);
        }
        System.out.println("---------------------------");

        LinkedHashMap<Integer,String> linkedHashMap = new LinkedHashMap<>(16,0.75f,true);
        linkedHashMap.put(1,"主播");
        linkedHashMap.put(2,"机构");
        linkedHashMap.put(3,"商家");
        linkedHashMap.put(4,"店铺");
        linkedHashMap.get(1);
        Set<Map.Entry<Integer, String>> entries = linkedHashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iteratorLink = entries.iterator();
        while (iteratorLink.hasNext()) {
            Map.Entry<Integer, String> next = iteratorLink.next();
            Integer key = next.getKey();
            String value = next.getValue();
            System.out.println("key:"+key+",value:"+value);
        }

    }

}
