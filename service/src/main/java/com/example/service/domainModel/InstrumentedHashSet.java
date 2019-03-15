package com.example.service.domainModel;

import java.util.Collection;
import java.util.HashSet;

/**
 * title：InstrumentedHashSet
 * description:
 *
 * @author yumengjie
 * @date 2019/2/26 9:12
 */

public class InstrumentedHashSet<E> extends HashSet<E> {

    private int addCount=0;

    public InstrumentedHashSet(){
    }
    public InstrumentedHashSet(int initCap,float loadFactor){
        super(initCap,loadFactor);
    }

    @Override
    public boolean add(E e) {
        addCount++;
        return super.add(e);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        addCount+=c.size();
        return super.addAll(c);
    }

    public int getAddCount() {
        return addCount;
    }
}