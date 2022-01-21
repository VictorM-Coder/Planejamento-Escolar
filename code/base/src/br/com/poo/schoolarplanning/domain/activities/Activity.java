package br.com.poo.schoolarplanning.domain.activities;

import br.com.poo.schoolarplanning.domain.enums.KanbanStage;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Activity implements Comparable<Activity>{

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
        return "Activity: " + this.name + "Phase: " + this.stage +
                "\nStart Date: " + this.startDate + " DeadLine: " + this.deadLine +
                "\nDescription: " + this.description;
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

    public String getName() { return name; }

    public KanbanStage getStage(){
        return this.stage;
    }
}

