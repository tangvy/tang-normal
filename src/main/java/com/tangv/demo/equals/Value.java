package com.tangv.demo.equals;

import java.util.Objects;

/**
 * Description:
 * Author:      TangWei
 * Date:        2020/5/9 10:35 上午
 */
public class Value {
    int i;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Value value = (Value) o;
        return i == value.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i);
    }
}
