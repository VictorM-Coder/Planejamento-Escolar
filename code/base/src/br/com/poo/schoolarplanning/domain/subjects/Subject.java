package br.com.poo.schoolarplanning.domain.subjects;
import java.io.Serializable;


/**
 * This class models the "Subjects" class, which goes from the needs in relation to the user's materials.
 * @author Higor Santiago
 * @author Victor Martins 
 */

public class Subject implements Comparable<Subject>, Serializable {
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
        return String.format("[Subject: %s]\n Teacher: %s\n Description: %s", this.name, this.teacherName, this.description);
    }

    @Override
    public int compareTo(Subject subject) {
        return this.name.compareTo(subject.name);
    }

    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Subject){
            return ((Subject)obj).name.equals(this.name) && ((Subject)obj).teacherName.equals(this.teacherName);
        }
        return false;
    }
    

    public String getName(){
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public String getTeacherName() {
        return teacherName;
    }
}
