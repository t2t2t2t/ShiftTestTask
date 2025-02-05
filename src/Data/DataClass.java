package Data;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
//абстрактный класс для Integer String Float данных
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


    public void writeInFile(){

        if(!dataList.isEmpty())
        {
            boolean rewrite= DataArgumentFunction.getInstance().isWriteInFileRewrite();
            String path=DataArgumentFunction.getInstance().getWritePath();
            if(path!=""){
                path.concat(File.separator);
            }
            Class<?> clazz=dataList.getFirst().getClass();
            String nameFile=DataArgumentFunction.getInstance().getWriteInFileNamePrefix()+getNameForFile(clazz);

            String fullPath = path + nameFile;
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fullPath, rewrite))) {
                for(T e:dataList){
                    writer.write(e+"\n");
                }
                System.out.println("Data successfully written to file: "+fullPath);
            } catch (IOException e) {
                System.err.println("File recording error: " + fullPath);
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
