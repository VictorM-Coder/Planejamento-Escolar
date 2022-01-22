package br.com.poo.schoolarplanning.domain.managers;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.enums.KanbanStage;
import br.com.poo.schoolarplanning.domain.managers.exceptions.ManagerExceptions;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Kanban extends Manager implements Editable<Activity>{
    private List<Activity> activities;

    public Kanban(){
        this.activities = new ArrayList<Activity>();
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

    public void controlKanban() throws ManagerExceptions{
        
        while ( true ) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("doing | done | exit");
            String option = scanner.nextLine();
            String ui[] = option.split("  "); 
            if( ui[0].equals("doing")){
                doActivity(activities.get(findItemIndexByName(ui[1])));
                System.out.println("Deu certo");
            } else if( ui[0].equals("done")){
                doneActivity(activities.get(findItemIndexByName(ui[1])));
            } else if( ui[0].equals("exit")) {
                break;
            }
        }
    
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
        int found = 0;
        for (Activity activ : activities) {//contains?
            if( activ.equals(o) ){ found++; }  
        } 
        if( found == 0 ){
            this.activities.add(o);
            order(this.activities);
        }   
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
        add(newE);
    }

    @Override
    public int findItemIndexByName(String name) throws ManagerExceptions{
        for (Activity activity : this.activities) {
            if( activity.getName().equals(name)){
                return this.activities.indexOf(activity);
            }
        }
        throw new ManagerExceptions("Activity don't found");
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
