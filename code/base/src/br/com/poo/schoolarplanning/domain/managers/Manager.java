package br.com.poo.schoolarplanning.domain.managers;
import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerException;

import java.util.Collections;
import java.util.List;

public abstract class Manager {

    public abstract String describe();

    /**
     * finds the first occurrence of the name and returns its index
     * @param name the attribute will be searched in the list of objects of the class
     * @return the index of the first object with the same name, or -1 if its does not exist
     * @throws ManagerException
     */
    protected abstract int findItemIndexByName(String name) throws ManagerException;

    /**
     * @param list  the Method sorts the list through the sort method of the collections interface
     */
    protected static void order(List list){
        Collections.sort(list);
    }

    /**
     * Converts the List object to a String
     * @param list
     * @return the List in a String format
     */
    protected static String listToString(List list){
        String out = "";
        for (Object object: list){
            out += object.toString() + "\n";
        }
        return out;
    }
}
