package Data;

import java.util.stream.Collectors;

public class DataFloat extends DataClass<Double>{
    @Override
    public void longStatic(){
        int size = getDataList().size();
        if(size!=0) {
            Double max = getDataList().stream().max(Double::compareTo).orElse(0.0);
            Double min = getDataList().stream().min(Double::compareTo).orElse(0.0);
            Double averaging = getDataList().stream().collect(Collectors.averagingDouble(Double::floatValue));
            double sum = getDataList().stream().mapToDouble(Double::floatValue).sum();
            System.out.println(getForPrintLineUp());
            System.out.printf("Long static for Float: Size: %d,%n " +
                    "Max number: %f,%n " +
                    "Min number: %f,%n " +
                    "Average number: %f,%n " +
                    "Sum of the numbers: %f %n", size, max, min, averaging, sum, getForPrintLineBottom());
            System.out.println(getForPrintLineBottom());
        }
    }
    @Override
    public void shortStatic(){
        System.out.println(getForPrintLineUp());
        System.out.println("Count elements in Float: "+ getDataList().size());
        System.out.println(getForPrintLineBottom());
    }
}
