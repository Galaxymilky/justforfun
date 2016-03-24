package com.test;

import java.util.Iterator;

/**
 * һ���򵥵����������ǿforѭ��
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
                throw new UnsupportedOperationException("Ŀǰ��֧��ɾ������");
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