package br.com.poo.schoolarplanning.domain.managers;

/**
 * This class models an interface
 * @author Victor Martins 
 * @author Higor Santiago
 */
public interface Editable<E>{
    void add(E e);
    void remove(E e);
    void update(E oldE, E newE);
}
