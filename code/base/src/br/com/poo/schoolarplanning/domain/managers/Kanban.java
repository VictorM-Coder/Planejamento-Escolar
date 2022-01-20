package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.enums.KanbanStage;

import java.util.ArrayList;
import java.util.List;

public class Kanban extends Manager implements Editable<Activity>{
    private List<Activity> activities;

    public void doActivity(Activity activity){

    }

    public void doneActivity(Activity activity){

    }

    @Override
    public void add(Activity o) {
        this.activities.add(o);
    }

    @Override
    public void remove(Activity o) {
        activities.remove(o);
    }

    @Override
    public void update(Activity oldE, Activity newE) {
        remove(oldE);
        add(oldE);
    }

    public List<Activity> getActivitiesByPhase(KanbanStage kanbanStage){
        List<Activity> activitiesOnStage = new ArrayList<Activity>();

        for(Activity activity: this.activities){
            if (activity.getStage() == kanbanStage){
                activitiesOnStage.add(activity);
            }
        }

        return activitiesOnStage;
    }

    @Override
    protected int FindItemIndexByName(String name) {
        for ( Activity E: activities ) {
            if( E.getName().equals(name)){ return activities.indexOf(E); };
        }
        return 0;
    }
}
