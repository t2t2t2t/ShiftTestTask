package Data;

import java.util.Comparator;

public class DataString extends DataClass<String>{
    @Override
    public void longStatic(){
        int size=getDataList().size();
        if(size!=0) {
            String maxString = getDataList().stream().max(Comparator.comparingInt(String::length)).orElse("");
            long maxSize = maxString.length();
            String minString = getDataList().stream().min(Comparator.comparingInt(String::length)).orElse("");
            long minSize = minString.length();
            System.out.println(getForPrintLineUp());
            System.out.printf("Long static for String: " +
                    "Size: %d,%n " +
                    "Max row: %s,%n " +
                    "Max size row: %d,%n " +
                    "Min row: %s,%n " +
                    "Min size row: %d%n", size, maxString, maxSize, minString, minSize);

            System.out.println(getForPrintLineBottom());
        }
    }
    @Override
    public void shortStatic(){
        System.out.println(getForPrintLineUp());
        System.out.println("Count elements in String: "+ getDataList().size());
        System.out.println(getForPrintLineBottom());
    }
}
