package br.com.poo.schoolarplanning.domain.activities;

import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * This class models "GroupActivity", as it takes care of user group activity needs.
 * @author Higor Santiago
 * @author Victor Martins 
 */

public class GroupActivity extends Activity{
    private List<String> participants;

    public GroupActivity(String name, String description, LocalDate startData, LocalDate deadLine, Subject subject, String...participants) {
        super(name, description, startData, deadLine, subject);

        this.participants = new ArrayList<>();
        if (participants != null){
            this.participants.addAll(List.of(participants));
        }
    }

    public GroupActivity(String name, String description, LocalDate startData, LocalDate deadLine, Subject subject, List<String> participants){
        super(name, description, startData, deadLine, subject);
        this.participants = participants;
    }

    @Override
    public String toString(){
        return super.toString() + "|\n\tParticipants: " + this.participantsToString();
    }

    public void setParticipants(List<String> participants){
        this.participants = participants;
    }

    private String participantsToString(){
        String out = "";

        for (int cont = 0; cont < this.participants.size(); cont++){
            out += participants.get(cont);

            out += (cont != this.participants.size()-1)? ", ": "";
        }

        return out;
    }

    public List<String> getParticipants(){
        return this.participants;
    }
}
