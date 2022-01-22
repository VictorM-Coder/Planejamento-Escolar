package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerExceptions;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Grade extends Manager implements Editable<Subject>{
    private List<Subject> subjects;

    public Grade(){
        this.subjects = new ArrayList<Subject>();
    }

    public Grade(List<Subject> subjects){
        this();
        this.subjects.addAll(subjects);
        order(this.subjects);
    }

    /**
     * @return a String of all subjects names on format:
     * GRADE: name1, name2,...
     */
    @Override
    public String toString(){
        return "GRADE:\n" + this.listSubjectsByName() + "\n--------------\n";
    }

    /**
     * @return a String of all subjects on format:
     * GRADE: name1 teacher1 description1, name2 teacher2 description2,...
     */
    @Override
    public String describe(){
        return "GRADE:\n" + listToString(this.subjects);
    }

    /**
     * Adds the specified element in the subjects list and orders the list
     * @param o subject to be add in the subjects list
     */
    @Override
    public void add(Subject o) {
        boolean contains = false;

        for (Subject subject : subjects) {
            if(subject.equals(o)){
                contains = true;
                break;
            }
        }

        if(!contains){
            this.subjects.add(o);
            order(this.subjects);
        }
    }

    @Override
    public void remove(Subject subject){
        this.subjects.remove(subject);
    }

    @Override
    public void removeByName(String name) throws ManagerExceptions {
        this.remove(this.subjects.get(this.findItemIndexByName(name)));
    }

    @Override
    public void update(Subject oldE, Subject newE){
        this.remove(oldE);
        this.add(newE);
    }

    @Override
    public int findItemIndexByName(String name) throws ManagerExceptions{
        for (Subject subject : subjects) {
            if( subject.getName().equals(name)){
                return subjects.indexOf(subject);
            }
        }
        throw new ManagerExceptions("subject don't found");
    }

    /**
     * @return a String with all subjects names on format: name1, name2,...
     */
    private String listSubjectsByName(){
        String out = "";
        for (Subject subject: this.subjects){
            out += subject.getName() + "\n";
        }

        return out;
    }

    public List<Subject> getSubjects(){
        return subjects;
    }
}
