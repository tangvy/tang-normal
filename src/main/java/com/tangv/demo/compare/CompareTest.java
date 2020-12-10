package com.tangv.demo.compare;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/5/9 10:46 上午
 */
public class CompareTest {

    public static void main(String[] args) {
        Student s1 = new Student(1L,28);
        Student s2 = new Student(2L,13);
        Student s3 = new Student(3L,45);
        Student s4 = new Student(4L,94);
        Student s5 = new Student(5L,28);
        List<Student> list = new ArrayList<>();
        list.add(s1);
        list.add(s2);
        list.add(s3);
        list.add(s4);
        list.add(s5);
        /*List<Student> collect = list.stream().sorted(Student::compareTo).collect(Collectors.toList());*/
        List<Student> collect = list.stream().sorted(Comparator.comparing(Student::getAge).reversed()
                .thenComparing(Student::getId)).collect(Collectors.toList());
        System.out.println(collect.toString());
    }

}
