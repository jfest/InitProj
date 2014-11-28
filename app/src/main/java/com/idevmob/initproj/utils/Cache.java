package com.idevmob.initproj.utils;

public interface Cache<T> {

    public T get(int key);
    public void put(int key, T element);

}
