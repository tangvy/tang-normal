package com.tangv.demo.Lambda;

import com.tangv.demo.model.Tag;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/3/19 5:18 下午
 */
public class LambdaA {

    public static void main(String[] args) {
        List<Tag> list = new ArrayList<>();
        list.add(new Tag(2, "A", "a"));
        list.add(new Tag(10, "B", "b"));
        list.add(new Tag(58, "C", "c"));
        list.add(new Tag(10, "D", "d"));
        list.add(new Tag(25, "E", "e"));
        list.sort((o1, o2) -> o2.getTagId() - o1.getTagId());
        System.out.println(list);

        Set<Tag> set = new TreeSet<>((o1, o2) -> {
            if (o1.getTagId() >= o2.getTagId()) {
                return -1;
            } else {
                return 1;
            }
        });
        set.add(new Tag(2, "A", "a"));
        set.add(new Tag(10, "B", "b"));
        set.add(new Tag(58, "C", "c"));
        set.add(new Tag(11, "D", "d"));
        set.add(new Tag(25, "E", "e"));
        System.out.println(set);
        //Comparator
        //ToLongFunction
        //Function
        Predicate pre = new Predicate() {
            @Override
            public boolean test(Object o) {
                if (o.equals(58)) {
                    return false;
                }
                return true;
            }
        };
        List<Integer> collect = list.stream().map(Tag::getTagId).filter(tag -> tag > 40).collect(Collectors.toList());
        List<Tag> collect1 = list.stream().filter(tag -> tag.getTagId() < 10).collect(Collectors.toList());
        //BinaryOperator
        list.stream().map(tag -> tag.getTagId()).reduce((tag, tag2) -> tag + tag2).get();
        //IntFunction
        String objects = list.stream().map(Tag::getTagId).toArray(Integer[]::new).toString();
        System.out.println("数组" + objects);
        System.out.println(collect);
        collect.removeIf(pre);
        Integer reduce = list.stream().map(Tag::getTagId).filter(i -> i > 5 && i < 30).reduce((i1, a2) -> {
            System.out.println("i1 : " + i1);
            System.out.println("a2 : " + a2);
            return i1 / a2;
        }).get();
        List is = new ArrayList();
        Integer i = list.stream().map(Tag::getTagId).findAny().get();
        System.out.println("findAny："+i);
        //ToDoubleFunction
        //Supplier
        DoubleStream asDouble = list.stream().mapToDouble(Tag::getTagId);
        System.out.println("double："+asDouble);
        System.out.println("reduce" + reduce);
        System.out.println("result" + collect);
        System.out.println(collect1);
        System.out.println(list);
        System.out.println("hello" + list);
        Optional<List<Tag>> list2 = Optional.ofNullable(list);

        List<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0);
        list1.forEach(ele -> {
            if (ele % 2 == 0) {
                System.out.println(ele);
            }
        });

        List<String> params = new ArrayList<>();
        params.add("仙本那,,,,,,");
        params.add("你猜呀,");
        params.add("tangv,,,");
        System.out.println(params);
        String result = params.stream().collect(Collectors.joining());
        System.out.println(result);
        String o = result.replace(',', '，').replace(';', '，').replace('.', '，');
        System.out.println(o);
        params.stream().collect(Collectors.joining()).replace(',', '，');
        char[] chars = o.toCharArray();
        List list3 = CollectionUtils.arrayToList(chars);
        System.out.println(list3);
        Iterator<Character> iterator = list3.iterator();
        List<Character> newList = new ArrayList<>();
        while (iterator.hasNext()){
            Character next = iterator.next();
            if (!next.equals('，')){
                newList.add(next);
            }
        }
        System.out.println(newList);
        List<String> collect2 = params.stream().collect(Collectors.toList());
        System.out.println(collect2);
    }
}
