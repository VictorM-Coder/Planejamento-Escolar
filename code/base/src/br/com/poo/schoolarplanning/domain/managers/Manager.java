package br.com.poo.schoolarplanning.domain.managers;
import java.util.Collections;
import java.util.List;

public abstract class Manager{
    /**
     *
     * @param list  the Method sorts the list through the sort method of the collections interface
     */
    protected static void order(List list){
        Collections.sort(list);
    }


    protected abstract int findItemIndexByName(String name) throws ManagerExceptions;

    protected static String listToString(List list){
        String out = "";
        for (Object object: list){
            out += object.toString() + "\n";
        }
        return out;
    }
}
