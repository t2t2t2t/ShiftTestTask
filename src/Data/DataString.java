package Data;

import java.util.Comparator;

public class DataString extends DataClass<String>{
    @Override
    public void longStatic(){
        int size=getDataList().size();
        String maxString=getDataList().stream().max(Comparator.comparingInt(String::length)).orElse("");
        long maxSize= maxString.length();
        String minString=getDataList().stream().min(Comparator.comparingInt(String::length)).orElse("");
        long minSize= minString.length();
        System.out.println(getForPrintLineUp());
        System.out.println("Long static for String");
        System.out.println("Size: "+size);
        System.out.println("Max row: "+maxString);
        System.out.println("Max size row: "+maxSize);
        System.out.println("Min row: "+minString);
        System.out.println("Min size row: "+minSize);
        System.out.println(getForPrintLineBottom());
    }
    @Override
    public void shortStatic(){
        System.out.println(getForPrintLineUp());
        System.out.println("Count elements in String: "+ getDataList().size());
        System.out.println(getForPrintLineBottom());
    }
}
