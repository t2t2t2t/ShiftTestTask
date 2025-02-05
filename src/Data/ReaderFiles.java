package Data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ReaderFiles {

    public static void loadData() {
        List<String> files=DataArgumentFunction.getInstance().getReadFileFile();
        for (int i = 0; i < files.size(); i++) {
            String file=files.get(i);
            File filePath = new File(file);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    checkTypeOfObjectInString(line);
                }
            } catch (IOException e) {
                System.err.println("Файл не найден, по адресу:" + filePath.getAbsolutePath());
            }
        }

    }

    private static void checkTypeOfObjectInString(String str) {
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
}
