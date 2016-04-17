package com.test;

import java.util.Iterator;

/**
 * 一个简单的逆序输出增强for循环
 *
 * @author
 */
public class ReverIterableClass<T> implements Iterable<T> {
    protected T[] elements;

    public ReverIterableClass(T... elems) {
        this.elements = elems;
        //this.object=(T[])new Object[ts.length];
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current = elements.length - 1;

            public boolean hasNext() {
                return current > -1;
            }


            public T next() {
                return elements[current--];
            }


            public void remove() {
                throw new UnsupportedOperationException("目前不支持删除操作");
            }
        };
    }

    public static void main(String[] args) {
        ReverIterableClass<String> iterableClass = new ReverIterableClass<String>("a", "b", "c", "d");
        for (String s : iterableClass) {
            System.out.println(s);
        }
    }


}