package Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class ArgumentParse {


    public void setFlags(Map<String, Integer> flags) {
        this.flags = flags;
    }

    public  Map<String, Integer> getFlags() {
        return flags;
    }

    private  Map<String, Integer> flags;

    private Map<String, Consumer<DataClass<?>>> functions;


    public   ArgumentParse() {
        flags = new HashMap<>();
        flags.put("-o", -1);
        flags.put("-p", -1);
        flags.put("-a", -1);
        flags.put("-s", -1);
        flags.put("-f", -1);

        functions = new HashMap<>();
        functions.put("-s", DataClass::longStatic);
        functions.put("-f", DataClass::shortStatic);
    }

    public  void chooseArg(String[] args){
        int countFlag=-1;
        for (String arg : args) {
            if (arg.startsWith("-")) {
                countFlag++;
            }
        }


        int indexO=0;
        int indexP=0;

        for (int i=0; i<countFlag+1;i++) {
            String currentArg = args[i];
            if (getFlags().containsKey(currentArg)) {
                getFlags().put(currentArg, i);
                if (currentArg.equals("-a")) {
                    DataArgumentFunction.getInstance().setWriteInFileRewrite(true);
                }
            } else System.out.println("This flag don`t exist :" + args[i]);
        }

        if(getFlags().get("-p")>getFlags().get("-o")){
            indexP=1;
            DataArgumentFunction.getInstance().setWriteInFileNamePrefix(args[countFlag+1]);
            if (getFlags().get("-o")!=-1){
                indexO=1;
                DataArgumentFunction.getInstance().setWritePath(args[countFlag+2]);
            }
        }

        if(getFlags().get("-o")>getFlags().get("-p")){
            indexO=1;
            DataArgumentFunction.getInstance().setWritePath(args[countFlag+1]);
            if (getFlags().get("-p")!=-1){
                indexP=1;
                DataArgumentFunction.getInstance().setWriteInFileNamePrefix(args[countFlag+2]);
            }
        }

        //System.out.println( DataArgumentFunction.getInstance().getWritePath());

        for (int i = countFlag+1+indexO+indexP; i < args.length ; i++) {
            DataArgumentFunction.getInstance().setAddReadFileFile(args[i]);
        }


    }



    public void executeFunction(DataClass<?> dataClass) {
        for (Map.Entry<String, Integer> entry : flags.entrySet()) {
            String flag = entry.getKey();
            Boolean isExecute = entry.getValue()!=-1;
            if (isExecute && functions.get(flag)!=null) {
                functions.get(flag).accept(dataClass);
            }
        }
    }

}
