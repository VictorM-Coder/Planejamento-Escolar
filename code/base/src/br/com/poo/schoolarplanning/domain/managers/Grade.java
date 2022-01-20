package br.com.poo.schoolarplanning.domain.managers;

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
     *
     * @return a String of all subjects names on format:
     * GRADE:
     * name1
     * name2
     * ...
     */
    @Override
    public String toString(){
        return "GRADE:\n" + this.listSubjectsByName();
    }

    /**
     * @return a String of all subjects on format:
     * GRADE: name1 teacher1 description1, name2 teacher2 description2,...
     */
    public String describeSubjects(){
        return "GRADE:\n" + this.subjectsToString();
    }

    /**
     * Adds the specified element in the subjects list and orders the list
     * @param subject subject to be add in the subjects list
     */
    @Override
    public void add(Subject subject) {
        this.subjects.add(subject);
        order(this.subjects);
    }

    @Override
    public void remove(Subject subject) {
        this.subjects.remove(subject);
    }

    @Override
    public void update(Subject oldE, Subject newE) {
        this.remove(oldE);
        this.add(newE);
    }

    @Override
    protected int FindItemIndexByName(String name) {
        return 0;
    }

    /**
     *
     * @return a String with all subjects names on format:
     * name1
     * name2
     * ...
     */
    private String listSubjectsByName(){
        String out = "";
        for (Subject subject: this.subjects){
            out += subject.getName() + "\n";
        }

        return out;
    }

    private String subjectsToString(){
        String out = "";
        for (Subject subject: this.subjects){
            out += subject + "\n";
        }

        return out;
    }
}
