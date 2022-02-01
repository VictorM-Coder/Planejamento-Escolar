package br.com.poo.schoolarplanning.domain.activities;

import br.com.poo.schoolarplanning.domain.enums.KanbanStage;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 * This class models "Activity", as it takes care of user activity needs.
 * @author Higor Santiago
 * @author Victor Martins 
 */

public class Activity implements Comparable<Activity>, Serializable {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate deadLine;
    private Subject subject;
    private KanbanStage stage;


    public Activity( String name, String description, LocalDate startData, LocalDate deadLine, Subject subject){
        this.name = name;
        this.description = description;
        this.startDate = startData;
        this.deadLine = deadLine;
        this.subject = subject;
        this.stage = KanbanStage.TO_DO;
    }

    @Override
    public String toString() {
        return "Activity: " + this.name + " Phase: " + this.stage +
                "|\n\tStart Date: " + this.startDate + " DeadLine: " + this.deadLine +
                "|\n\tDescription: " + this.description;
    }



    /**
     * calculate the number of days from today to the deadline
     * @return the number of days from today to the deadline.
     * if today is equals to the deadline returns 0.
     * if date passed returns a negative value
     */
    public int daysUntilDeadLine(){
        return ((int) LocalDate.now().until(this.deadLine, ChronoUnit.DAYS));
    }

    /**
     * change the phase to DOING
     */
    public void doActivity(){
        this.stage = KanbanStage.DOING;
    }

    /**
     * change the phase to DONE
     */
    public void doneActivity(){
        this.stage = KanbanStage.DONE;
    }

    @Override
    public int compareTo(Activity activity) {
        int daysDifference = this.daysUntilDeadLine() - activity.daysUntilDeadLine();

        return Integer.compare(daysDifference, 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Activity){
           return (((Activity)obj).name.equals(this.name) && ((Activity)obj).subject.equals(this.subject));
        }
        return false;
    }

    public String getName(){
        return name; }

    public KanbanStage getStage(){
        return this.stage;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getDeadLine() {
        return deadLine;
    }

    public Subject getSubject() {
        return subject;
    }
}

