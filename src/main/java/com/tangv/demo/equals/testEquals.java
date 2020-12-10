package com.tangv.demo.equals;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/5/9 10:22 上午
 */
public class testEquals {

    public static void main(String[] args) {
        String a = "fgh";
        String b = "fgh";
        StringBuffer c = new StringBuffer("sdf");
        StringBuffer d = new StringBuffer("sdf");
        System.out.println(c.equals(d));
        System.out.println(a.equals(b));
        Value v1 = new Value();
        Value v2 = new Value();
        v1.i=v2.i=100;
        System.out.println(v1.equals(v2));
        System.out.println(v1==v2);
    }

}
