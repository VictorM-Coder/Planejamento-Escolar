package br.com.poo.schoolarplanning.domain.subjects;

public class Subject {
    private String name;
    private String description;
    private String teacherName;

    public Subject(String name, String teacherName, String description){
        this.name = name;
        this.teacherName = teacherName;
        this.description = description;
    }

    @Override
    public String toString(){
        return String.format("Name: %s\nTeacher: %s\nDescription: %s", this.name, this.teacherName, this.description);
    }
}
