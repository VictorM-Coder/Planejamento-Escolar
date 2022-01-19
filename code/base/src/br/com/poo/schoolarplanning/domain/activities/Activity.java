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

    public int daysUntilDeadLine(){
        return 0;
    }

    public void doActivity(){
        this.stage = KanbanStage.DOING;
    }

    public void doneActivity(){
        this.stage = KanbanStage.DONE;
    }
}
