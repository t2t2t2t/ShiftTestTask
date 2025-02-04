package Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public abstract class DataClass<T> {
    public String getForPrintLineUp() {
        return forPrintLineUp;
    }

    private final String forPrintLineUp = "╔═══════════════════════════════════════════╗";

    public String getForPrintLineBottom() {
        return forPrintLineBottom;
    }

    private final String forPrintLineBottom = "╚═══════════════════════════════════════════╝";


    private List<T> dataList=new ArrayList<>();

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public static void ReadFile() {
        List<String> files=DataArgumentFunction.getInstance().getReadFileFile();
        for (int i = 0; i < files.size(); i++) {
            String file=files.get(i);
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

    }


    private static void CheckTypeOfObjectInString(String str) {
        DataManager dataManager = DataManager.getInstance();
        if (str.matches("-?\\d+")) {
            dataManager.getDataInteger().getDataList().add(Long.valueOf(str));
        } else if (str.matches("-?\\d+([.,]\\d+)?([Ee][+-]?\\d+)?")) {
            str = str.replace(',', '.');
            try {
                dataManager.getDataFloat().getDataList().add(Double.valueOf(str));
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format: " + str);
            }
        } else {
            dataManager.getDataString().getDataList().add(str);
        }
    }

    public void writeInFile(){
        boolean rewrite= DataArgumentFunction.getInstance().isWriteInFileRewrite();
        String path=DataArgumentFunction.getInstance().getWritePath();
        if(!dataList.isEmpty())
        {
            Class<?> clazz=dataList.getFirst().getClass();
            String nameFile=DataArgumentFunction.getInstance().getWriteInFileNamePrefix()+getNameForFile(clazz);

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(path+"\\"+nameFile, rewrite))) {
                for(T e:dataList){
                    writer.write(e+"\n");
                }
                System.out.println("Data successfully written to file: "+path+"\\"+nameFile);
            } catch (IOException e) {
                System.err.println("File recording error: " + nameFile);
            }
        }
    }

    private String getNameForFile(Class<?> clazz){
        switch (clazz.getSimpleName()) {
            case ("Long"):
                return "Integer.txt";
            case ("Double"):
                return "Float.txt";
            case ("String"):
                return "String.txt";
        }
        return "data.txt";
    }

    public void shortStatic(){
        System.out.printf("Count elements in: {%d}, type: {%s}%n", getDataList().size(), dataList.getFirst().getClass().getSimpleName());
    }

    public void longStatic(){

    }

}
