package br.com.poo.schoolarplanning.domain.activities;

import br.com.poo.schoolarplanning.domain.enums.KanbanStage;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.time.LocalDate;

public class Activity {

    private String name;
    private String description;
    private LocalDate startDate;
    private LocalDate deadLine;
    private Subject subject;
    private KanbanStage stage;


    public Activity( String name, String description,
                     LocalDate startData, LocalDate deadLine, Subject subject){
        this.name = name;
        this.description = description;
        this.startDate = startData;
        this.deadLine = deadLine;
        this.subject = subject;
        this.stage = KanbanStage.TO_DO;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", deadLine=" + deadLine +
                ", subject=" + subject +
                ", stage=" + stage +
                '}';
    }

    public int daysUntilDeadLine(){
        //usar esse método para o Comparable
        return 0;
    }

    public String getName() { return name; }

    public void doActivity(){
        this.stage = KanbanStage.DOING;
    }

    public void doneActivity(){
        this.stage = KanbanStage.DONE;
    }

    public KanbanStage getStage(){
        return this.stage;
    }
}
