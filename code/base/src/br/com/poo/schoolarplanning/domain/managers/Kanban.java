package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.enums.KanbanStage;


import java.util.ArrayList;
import java.util.List;

public class Kanban extends Manager implements Editable<Activity>{
    private List<Activity> activities;

    public Kanban(){
        this.activities = new ArrayList<Activity>();
    }

    @Override
    public String toString(){
        return "Kanban(All Activies):\n" + this.simpleListActivities(); 
    }

    public String toStringToByPhase( ){
        String out = "";
        
        System.out.println("TO DO");
        for (Activity activity : getActivitiesByPhase( KanbanStage.TO_DO)) {
            System.out.println("\t"+activity+"\n");
        }

        System.out.println("TO DOING");
        for (Activity activity : getActivitiesByPhase(KanbanStage.DOING)) {
            System.out.println("\t"+activity+"\n");
        }

        System.out.println("TO DONE");
        for (Activity activity : getActivitiesByPhase(KanbanStage.DONE)) {
            System.out.println("\t"+activity+"\n");
        }
        return out;
    }

    public void doActivity(Activity activity){
        activity.doActivity();
    }

    public void doneActivity(Activity activity){
        activity.doneActivity();
    }

    @Override
    public void add(Activity o) {
        this.activities.add(o);
        order(this.activities);
    }

    @Override
    public void remove(Activity o) {
        activities.remove(o);
    }

    @Override
    public void removeByName(String name) throws ManagerExceptions {
        this.remove(this.activities.get(this.findItemIndexByName(name)));
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
    protected int findItemIndexByName(String name) throws ManagerExceptions{
        for (Activity activity : this.activities) {
            if( activity.getName().equals(name)){
                return this.activities.indexOf(activity);
            }
        }
        throw new ManagerExceptions("Materia nao encontrada");
    }

    private String simpleListActivities(){
        String out = "";
        for (Activity activity: this.activities){
            out += activity.getName() + "["+ activity.getStage() +"]" + "\n";
        }

        return out;
    }
}
