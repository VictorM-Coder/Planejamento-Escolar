package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.activities.Activity;

import java.util.List;

public class Kanban extends Manager implements Editable<Activity>{
    private List<Activity> activitiesToDo;
    private List<Activity> activitiesDoing;
    private List<Activity> activitiesDone;

    public void doActivity(Activity activity){

    }

    public void doneActivity(Activity activity){

    }

    @Override
    public void add(Activity o) {

    }

    @Override
    public void remove(Activity o) {

    }

    @Override
    public void update(Activity oldE, Activity newE) {

    }

    @Override
    protected int FindItemIndexByName(String name) {
        return 0;
    }
}
