package ru.innopolis.uni.course3.commands;


import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by julia on 07.12.2016.
 */
public class Main {
    private static List<Student> list = new StudentsList<>();

    private static void parseFile(String filename) {
        try (FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);) {
            String str = null;

            while ((str=br.readLine()) != null) {
                String[] tokens = str.split(" |=");
                Student student = new Student(tokens[1], Integer.valueOf(tokens[3]));
                list.add(student);
            }

        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ioexception");
            e.printStackTrace();
        }
    }
    private static void serialize(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             ObjectOutputStream oos = new ObjectOutputStream(fos)
        ) {
            oos.writeObject(list);
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ioexception");
            e.printStackTrace();
        }
    }

    private static void deserialize(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             ObjectInputStream oin = new ObjectInputStream(fis)
        ) {
            list = (StudentsList) oin.readObject();
            System.out.println("deserialization");
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("ioexception");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        Boolean exit = false;
        String userCommand = "";

        Scanner reader = new Scanner(System.in);
        while (!exit) {
            System.out.println("Enter your command:");
            userCommand = reader.nextLine();
            String delims = " ";
            String[] tokens = userCommand.split(delims);
            String command = null;
            String filename = null;
            if (tokens.length > 0) {
                command = tokens[0];
            }
            if (tokens.length > 1) {
                filename = tokens[1];
            }

            switch (command) {
                case "parse" :
                    parseFile(filename);
                    break;
                case "serialize" :
                    serialize(filename);
                    break;
                case "deserialize" :
                    deserialize(filename);
                    break;
                case "exit" :
                    exit = true;
                    break;
                default:
                    System.out.println("Unexpected command! Try again");
            }
        }


    }
}
