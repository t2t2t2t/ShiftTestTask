package Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DataClass<T> {
    public String getForPrintLineUp() {
        return forPrintLineUp;
    }

    private String forPrintLineUp = "╔═══════════════════════════════════════════╗";

    public String getForPrintLineBottom() {
        return forPrintLineBottom;
    }

    private String forPrintLineBottom = "╚═══════════════════════════════════════════╝";


    private List<T> dataList=new ArrayList<>();

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
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

    //todo переписать что бы было без аргументов

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

    public void writeInFile(String nameFile,boolean rewrite){
        if(!dataList.isEmpty())
        {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(nameFile, rewrite))) {
                for(T e:dataList){
                    writer.write(e+"\n");
                }
            } catch (IOException e) {
                System.err.println("Ошибка записи файла: " + nameFile);
            }
        }
    }

    public void shortStatic(){
        System.out.println("Count elements in: "+ getDataList().size());
    }

    public void longStatic(){

    }

}
