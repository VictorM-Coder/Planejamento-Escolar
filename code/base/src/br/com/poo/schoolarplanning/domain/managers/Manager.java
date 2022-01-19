package br.com.poo.schoolarplanning.domain.managers;

public abstract class Manager {
    protected abstract void order();
    protected abstract int FindItemIndexByName(String name);
}
