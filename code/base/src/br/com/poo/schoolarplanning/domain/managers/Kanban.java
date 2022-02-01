package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.enums.KanbanStage;
import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class models the "Kanban" class, which is the class responsible for organizing the kanban idea in the application.
 * @author Higor Santiago
 * @author Victor Martins 
 */

public class Kanban extends Manager implements Editable<Activity>{
    private List<Activity> activities;

    public Kanban(){
        this.activities = new ArrayList<Activity>();
    }

    public Kanban(List<Activity> activities){
        this();
        this.activities = activities;
    }

    @Override
    public String toString(){
        return "Kanban(All Activies):\n" + this.simpleListActivities(); 
    }

    @Override
    public String describe(){
        String out = this.getStringActivitiesByPhase(KanbanStage.TO_DO);
        out += this.getStringActivitiesByPhase(KanbanStage.DOING);
        out += this.getStringActivitiesByPhase(KanbanStage.DONE);
        return out;
    }

    public void doActivity(Activity activity){
        activity.doActivity();
    }

    public void doneActivity(Activity activity){
        activity.doneActivity();
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
    public void add(Activity o)  {
        boolean contains = false;

        for (Activity activity : this.activities) {
            if(activity.equals(o)){
                contains = true;
                break;
            }
        }

        if(!contains){
            this.activities.add(o);
            order(this.activities);
        }
    }

    @Override
    public void remove(Activity o) {
        activities.remove(o);
    }

    @Override
    public void removeByName(String name) throws ManagerException {
        this.remove(this.activities.get(this.findItemIndexByName(name)));
    }

    @Override
    public void update(Activity oldE, Activity newE) {
        remove(oldE);
        add(newE);
    }

    @Override
    public int findItemIndexByName(String name) throws ManagerException{
        for (Activity activity : this.activities) {
            if( activity.getName().equals(name)){
                return this.activities.indexOf(activity);
            }
        }
        throw new ManagerException("Activity don't found");
    }

    private String simpleListActivities(){
        String out = "";
        for (Activity activity: this.activities){
            out += activity.getName() + "["+ activity.getStage() +"]" + "\n";
        }

        return out;
    }

    /**
     * convert all activities of a specific phase to a String
     * @param kanbanStage
     * @return a String of all activities at a specific phase
     */
    private String getStringActivitiesByPhase(KanbanStage kanbanStage){
        String out = kanbanStage + "\n";
        for (Activity activity : getActivitiesByPhase(kanbanStage)) {
            out += ("\t"+activity+"\n");
        }
        return out;
    }

    public List<Activity> getActivies(){
        return this.activities;
    }
    
    
}
