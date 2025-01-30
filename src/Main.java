import Data.ArgumentParse;
import Data.DataManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public  class Main {

    public static void main(String[] args) {
        ArgumentParse argumentParse=new ArgumentParse();
        Arrays.stream(args).forEach(argumentParse::chooseArg);

        //test commit

        DataManager dataManager = DataManager.getInstance();

        ReadFile("text1.txt");


        dataManager.getDataFloat().writeInFile();
        argumentParse.executeFunction(dataManager.getDataFloat());

        //dataManager.getDataInteger().writeInFile("integer.txt", false);
        argumentParse.executeFunction(dataManager.getDataInteger());

        //dataManager.getDataString().writeInFile("string.txt", false);
        argumentParse.executeFunction(dataManager.getDataString());


    }


    public static void ReadFile(String file) {
        //todo сделать правильныый вод для полного вода исопльзуя регулрные выржения

        File filePath = new File(file);


        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                CheckTypeOfObjectInString(line);
            }
        } catch (IOException e) {
            System.err.println("Файл не найден, по адресу:" + filePath.getAbsolutePath());
        }
    }


    public static void CheckTypeOfObjectInString(String str) {
        DataManager dataManager = DataManager.getInstance();
        if (str.matches("-?\\d+")) {
            dataManager.getDataInteger().getDataList().add(Long.valueOf(str));
        } else if (str.matches("-?\\d+([.,]\\d+)?([Ee][+-]?\\d+)?")) {
            dataManager.getDataFloat().getDataList().add(Double.valueOf(str));
        } else {
            dataManager.getDataString().getDataList().add(str);
        }
    }

}

