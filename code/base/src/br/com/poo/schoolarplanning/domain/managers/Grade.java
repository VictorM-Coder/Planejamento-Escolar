package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Grade extends Manager implements Editable<Subject>{
    private List<Subject> itens;

    public Grade(){
        this.itens = new ArrayList<Subject>();
    }

    public Grade(List<Subject> subjects){
        this();
        this.itens.addAll(subjects);
        order(this.itens);
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
        this.itens.add(subject);
        order(this.itens);
    }

    @Override
    public void remove(Subject subject) {
        this.itens.remove(subject);
    }

    @Override
    public void update(Subject oldE, Subject newE) {
        this.remove(oldE);
        this.add(newE);
    }

    @Override
    public int FindItemIndexByName(String name) {
        for (Subject subject : itens) {
            if( subject.getName().equals(name)){
                return itens.indexOf(subject);
            }
        }
        throw new ManagerExceptions("Materia nao encontrada");
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
        for (Subject subject: this.itens){
            out += subject.getName() + "\n";
        }

        return out;
    }

    private String subjectsToString(){
        String out = "";
        for (Subject subject: this.itens){
            out += subject + "\n";
        }

        return out;
    }

    public List<Subject> getSubjects(){
        return itens;
    }
}
