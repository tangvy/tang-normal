package com.tangv.demo.compare;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/5/9 10:49 上午
 */
public class Student implements Comparable<Student> {

    private Long id;

    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Student(Long id, Integer age) {
        this.id = id;
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age > o.age) {
            return 1;
        }else if (this.age < o.age) {
            return -1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                '}';
    }
}
