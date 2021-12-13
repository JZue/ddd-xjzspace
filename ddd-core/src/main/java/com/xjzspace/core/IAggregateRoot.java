package com.xjzspace.core;

public interface IAggregateRoot<T> {

    default boolean sameAs(IAggregateRoot<T> other){
        return this.getIdentity().equals(other.getIdentity());
    }

    T getIdentity();
}
