package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerExceptions;

public interface Editable<E>{
    void add(E e);
    void remove(E e);
    void removeByName(String name) throws ManagerExceptions;//pode ser removido?
    void update(E oldE, E newE);
}
