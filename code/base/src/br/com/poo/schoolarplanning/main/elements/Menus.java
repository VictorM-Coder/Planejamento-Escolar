package br.com.poo.schoolarplanning.main.elements;

/**
 *This This class is responsible for printing the menus
 * @author Higor Santiago
 * @author Victor Martins
 */
public class  Menus {

    public static void menuPrincipal(){
      System.out.println("-----------------------------");
      System.out.println("| GRADE | ACTIVITIES | EXIT | ");
      System.out.println("-----------------------------");
    }

    public static void menuSubject(){
      System.out.println("---------------------------------------");
      System.out.println("| ADD | REMOVE | UPDATE | SHOW | EXIT |");
      System.out.println("---------------------------------------");
    }

    public static void menuAtiv(){
      System.out.println("------------------------------------------------");
      System.out.println("| ADD | REMOVE | UPDATE | SHOW | KANBAN | EXIT |");
      System.out.println("------------------------------------------------");
    }

    public static void menuKanban(){
        System.out.println("--------------------");
        System.out.println("| DO | DONE | EXIT |");
        System.out.println("--------------------");
    }
}
