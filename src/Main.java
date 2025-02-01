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


        DataClass.ReadFile();

        argumentParse.executeFunction(dataManager.getDataFloat());
        dataManager.getDataFloat().writeInFile();

        argumentParse.executeFunction(dataManager.getDataInteger());
        dataManager.getDataInteger().writeInFile();

        argumentParse.executeFunction(dataManager.getDataString());
        dataManager.getDataString().writeInFile();
    }
}

