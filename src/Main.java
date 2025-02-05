import Data.ArgumentParser;
import Data.DataManager;
import Data.ReaderFiles;

public  class Main {

    public static void main(String[] args) {
        ArgumentParser argumentParser=new ArgumentParser ();
        // Обработка входных данных
        argumentParser.processingArg(args);

        DataManager dataManager = DataManager.getInstance();

        // Чтение данных из файлов
        ReaderFiles.loadData();

        // Обработка данных и вывод статистики
        argumentParser.executeFunction(dataManager.getDataFloat());
        argumentParser.executeFunction(dataManager.getDataInteger());
        argumentParser.executeFunction(dataManager.getDataString());

        //Запись данных
        dataManager.getDataFloat().writeInFile();
        dataManager.getDataInteger().writeInFile();
        dataManager.getDataString().writeInFile();
    }

}

