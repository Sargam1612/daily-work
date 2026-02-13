package com.zeta;

public class MyKey implements Comparable<MyKey> {
    int id;

    public MyKey(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return id;
    }

//    @Override
//    public boolean equals(MyKey otherKey) {
//        return this.id == otherKey.id;
//    }

    @Override
    public int compareTo(MyKey otherKey) {
        return this.id - otherKey.id;
     }

}
