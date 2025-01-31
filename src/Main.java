import Data.ArgumentParse;
import Data.DataArgumentFunction;
import Data.DataClass;
import Data.DataManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

//O путь для вывода
//P префикс для вывода
//A для пераписи
//S крастная статстика
//F длинная
//todo исправить для ввод для вывода добавить ввод несольких файлах исправить на запятой цифры
public  class Main {

    public static void main(String[] args) {
        ArgumentParse argumentParse=new ArgumentParse();
        argumentParse.chooseArg(args);

        System.out.println(DataArgumentFunction.getInstance().getReadFileFile());
        System.out.println(DataArgumentFunction.getInstance().getWriteInFileNamePrefix());
        System.out.println(DataArgumentFunction.getInstance().isWriteInFileRewrite());
        //test commit

        DataManager dataManager = DataManager.getInstance();

      //  ReadFile("text1.txt");

        DataClass.ReadFile();
        dataManager.getDataFloat().writeInFile();
        argumentParse.executeFunction(dataManager.getDataFloat());

        dataManager.getDataInteger().writeInFile();
        argumentParse.executeFunction(dataManager.getDataInteger());

        dataManager.getDataString().writeInFile();
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

