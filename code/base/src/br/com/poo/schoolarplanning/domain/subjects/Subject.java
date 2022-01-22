package br.com.poo.schoolarplanning.domain.subjects;

public class Subject implements Comparable<Subject>{
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

    @Override
    public int compareTo(Subject subject) {
        return this.name.compareTo(subject.name);
    }

    
    @Override
    public boolean equals(Object obj) {
        /*if (this.name == ((Subject)obj).name){
            return ((this.name == ((Subject)obj).name) && (this.teacherName == ((Subject)obj).teacherName));
        }
        return false;
        */
        return ((Subject)obj).name.equals(this.name) && ((Subject)obj).teacherName.equals(this.teacherName);
        
    }
    

    public String getName(){
        return this.name;
    }

}
