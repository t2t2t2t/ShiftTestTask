package Data;

import java.util.stream.Collectors;

public class DataInteger extends DataClass<Long> {
    @Override
    public void longStatic(){
        int size= getDataList().size();
        if(size!=0) {
            Long max=getDataList().stream().max(Long::compareTo).orElse(0L);
            Long min=getDataList().stream().min(Long::compareTo).orElse(0L);
            Double averaging=getDataList().stream().collect(Collectors.averagingInt(Long::intValue));
            int sum= getDataList().stream().mapToInt(Long::intValue).sum();
            System.out.println(getForPrintLineUp());
            System.out.printf("Long static for Integer: " +
                    "Size: %d,%n " +
                    "Max number: %d,%n " +
                    "Min number: %d,%n " +
                    "Average number: %f,%n " +
                    "Sum of the numbers: %d %n", size, max, min, averaging, sum, getForPrintLineBottom());
            System.out.println(getForPrintLineBottom());
        }


    }

    @Override
    public void shortStatic(){
        System.out.println(getForPrintLineUp());
        System.out.println("Count elements in Integer: "+ getDataList().size());
        System.out.println(getForPrintLineBottom());
    }
}
