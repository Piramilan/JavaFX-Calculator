package com.milan.javafx;

import java.io.*;

public class CalcData {
    private static String user;

    public void dataInput(String userName){
        user = userName;
        String msg = "\nWelcome Back " + userName;
        try {
            File file = new File("userData/"+userName+".txt");

            if (file.createNewFile()){
                System.out.println("New File is created!");
                outputFile(userName + "'s Calculation Data\n",userName);
            }else{
                System.out.println("File with the same name already exists.");
                outputFile(msg,userName);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void dataWrite(String calc) throws IOException {
        outputFile(calc,user);
        System.out.println("Calculation Added");
    }

    public static void outputFile(String data,String user) throws IOException {
        PrintWriter outputFile= new PrintWriter(new FileWriter("userData/"+user+".txt", true));
        outputFile.println(data);
        outputFile.flush();
        outputFile.close();
    }
}
