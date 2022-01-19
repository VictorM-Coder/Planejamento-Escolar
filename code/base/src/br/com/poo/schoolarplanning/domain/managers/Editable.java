package br.com.poo.schoolarplanning.domain.managers;

public interface Editable<E>{
    void add(E e);
    void remove(E e);
    void update(E oldE, E newE);
}
