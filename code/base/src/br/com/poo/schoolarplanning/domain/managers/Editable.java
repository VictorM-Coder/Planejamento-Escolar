package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerException;

public interface Editable<E>{
    void add(E e);
    void remove(E e);
    void removeByName(String name) throws ManagerException;//pode ser removido?
    void update(E oldE, E newE);
}
