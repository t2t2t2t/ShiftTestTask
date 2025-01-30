package Data;

import java.util.stream.Collectors;

public class DataFloat extends DataClass<Double>{
    @Override
    public void longStatic(){
        int size= getDataList().size();
        Double max=getDataList().stream().max(Double::compareTo).orElse(0.0);
        Double min=getDataList().stream().min(Double::compareTo).orElse(0.0);
        Double averaging=getDataList().stream().collect(Collectors.averagingDouble(Double::floatValue));
        double sum= getDataList().stream().mapToDouble(Double::floatValue).sum();
        System.out.println(getForPrintLineUp());
        System.out.println("Long static for Float");
        System.out.println("Size: "+size);
        System.out.println("Max number: "+max);
        System.out.println("Min number:"+min);
        System.out.println("Average number: "+averaging);
        System.out.println("Sum of the numbers: "+sum);
        System.out.println(getForPrintLineBottom());
    }
    @Override
    public void shortStatic(){
        System.out.println(getForPrintLineUp());
        System.out.println("Count elements in Float: "+ getDataList().size());
        System.out.println(getForPrintLineBottom());
    }
}
