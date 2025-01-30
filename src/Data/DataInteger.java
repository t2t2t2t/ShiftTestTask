package Data;

import java.util.stream.Collectors;

public class DataInteger extends DataClass<Long> {
    @Override
    public void longStatic(){
        int size= getDataList().size();
        Long max=getDataList().stream().max(Long::compareTo).orElse(0L);
        Long min=getDataList().stream().min(Long::compareTo).orElse(0L);
        Double averaging=getDataList().stream().collect(Collectors.averagingInt(Long::intValue));
        int sum= getDataList().stream().mapToInt(Long::intValue).sum();
        System.out.println(getForPrintLineUp());
        System.out.println("Long static for Integer");
        System.out.println("Size: "+size);
        System.out.println("Max number: "+max);
        System.out.println("Min number:"+min);
        System.out.println("Average number: "+averaging);
        System.out.println("Sum of the numbers"+sum);
        System.out.println(getForPrintLineBottom());
    }

    @Override
    public void shortStatic(){
        System.out.println(getForPrintLineUp());
        System.out.println("Count elements in Integer: "+ getDataList().size());
        System.out.println(getForPrintLineBottom());
    }
}
