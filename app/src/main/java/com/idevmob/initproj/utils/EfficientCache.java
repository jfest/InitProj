package com.idevmob.initproj.utils;

import android.util.SparseArray;

import java.lang.ref.SoftReference;

public class EfficientCache<T> implements Cache<T> {

    private SparseArray<SoftReference<T>> mCache;

    public EfficientCache(int cacheSize) {
        mCache = new SparseArray<SoftReference<T>>(cacheSize);
    }

    public T get(int key) {
        final SoftReference<T> softRef = mCache.get(key);
        return (softRef == null) ? null : softRef.get();
    }

    public void put(int key, T element) {
        mCache.put(key, new SoftReference<T>(element));
    }

}