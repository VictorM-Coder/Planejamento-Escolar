package br.com.poo.schoolarplanning.persistence;

import br.com.poo.schoolarplanning.domain.activities.Activity;
import br.com.poo.schoolarplanning.domain.subjects.Subject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * this class models a "Serializer" that serializes List objects from <i>Managers<i/> classes
 * @author Victor Martins
 * @author Higor Santiago
 */
public class Serializer {
    private static final String URL_FILE_ACTIVITIES = "ActivitiesList.ser";
    private static final String URL_FILE_SUBJECTS = "SubjectsList.ser";

    /**
     * write a List of Activities
     * @param activities list to be written
     */
    public static void writeActivitiesList(List<Activity> activities){
        try {
            writeList(URL_FILE_ACTIVITIES, activities);

        }catch (IOException exception){
            System.out.println("error: " + exception);
            exception.printStackTrace();
        }
    }

    /**
     * read a list of Activities and return it
     * @return a list of activities if it has one, or a new Activity Arraylist empty if it hasn't one
     */
    public static List<Activity> readActivitiesList(){
        try{
            return readList(URL_FILE_ACTIVITIES);

        }catch (FileNotFoundException exception){
            System.out.println("no saved data");
        }catch (IOException | ClassNotFoundException exception){
            System.out.println("error: " + exception);
            exception.printStackTrace();
        }

        return new ArrayList<Activity>();
    }

    /**
     * write a List of subjects
     * @param subjects list to be written
     */
    public static void writeSubjectsList(List<Subject> subjects){
        try{
            writeList(URL_FILE_SUBJECTS, subjects);

        }catch (IOException exception){
            System.out.println("error: " + exception);
            exception.printStackTrace();
        }
    }

    /**
     * read a list of Subjects and return it
     * @return a list of subjects if it has one, or a new Subject Arraylist empty if it hasn't one
     */
    public static List<Subject> readSubjectList(){
        try{
            return readList(URL_FILE_SUBJECTS);

        }catch (FileNotFoundException exception){
            System.out.println("no saved data");
        }catch (IOException | ClassNotFoundException exception){
            System.out.println("error: " + exception);
            exception.printStackTrace();
        }

        return  new ArrayList<Subject>();
    }

    /**
     * write a List object in a file
     * @param url of the file to be written
     * @param list that will be written
     * @throws IOException
     */
    private static void writeList(String url, List list) throws IOException {
       try( FileOutputStream fileOutputStream = new FileOutputStream(url);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);){

           objectOutputStream.writeObject(list);
       }
    }

    /**
     * reads a List object of a file.
     * @param url of the file will be read
     * @return a list of the file from the url
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private static List readList(String url) throws ClassNotFoundException, IOException {
        try(FileInputStream fileInputStream = new FileInputStream(url);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);){

            return (List) objectInputStream.readObject();

        }catch ( ClassNotFoundException | IOException exception){
            throw exception;
        }
    }
}












