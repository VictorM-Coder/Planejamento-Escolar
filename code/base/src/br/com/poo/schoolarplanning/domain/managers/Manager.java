package br.com.poo.schoolarplanning.domain.managers;

import java.util.Collections;
import java.util.List;

public abstract class Manager {
    protected static void order(List list){
        Collections.sort(list);
    }

    protected abstract int FindItemIndexByName(String name);
}
