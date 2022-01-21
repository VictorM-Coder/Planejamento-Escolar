package br.com.poo.schoolarplanning.tests;
import java.util.Scanner;
import br.com.poo.schoolarplanning.domain.subjects.Subject;
import br.com.poo.schoolarplanning.domain.managers.Grade;
import br.com.poo.schoolarplanning.domain.managers.Kanban;

public class Main {
  public static void main(String[] args) {

    Scanner leitor = new Scanner(System.in);
    
    while( true ){

      System.out.println("1 - Materias\n2 - Atividades\n3 - Exit");
      int Opcao = leitor.nextInt();
      Grade grade = new Grade();
      Kanban kanban = new Kanban();

      try{
        if( Opcao == 3) {
          break;
        } else if( Opcao == 1 ){
          while ( true ){

            String Opcao2 = leitor.nextLine();
            String ui[] = Opcao2.split("  ");
            System.out.println("Add\nRemove\nUpdate\nExit");

            if( ui[0].equals("Exit")){
              break;
            } else if( ui[0].equals("add")){
              Subject materia = new Subject(ui[1],ui[2],ui[3]);
              grade.add(materia);
            } else if( ui[0].equals("show")){
              System.out.print(grade.describeSubjects());
            } else if( ui[0].equals("remove")){
              
            }
        }
      }
      
    } catch ( Exception e){
      System.out.println(e.getMessage());
    }

      
    
  } 

  }
}
