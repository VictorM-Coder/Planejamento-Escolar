package br.com.poo.schoolarplanning.main.elements;

public class  Menus {

    public static void menuPrincipal(){
      System.out.println("--------------------------------------------");
      System.out.println("| 1 - SUBJECTS | 2 - ACTIVITIES | 3 - EXIT | ");
      System.out.println("--------------------------------------------");
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
