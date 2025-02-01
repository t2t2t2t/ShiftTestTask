package Data;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.function.Consumer;

public class ArgumentParse {


    public void setFlags(Map<String, Boolean> flags) {
        this.flags = flags;
    }

    public  Map<String, Boolean> getFlags() {
        return flags;
    }

    private  Map<String, Boolean> flags;

    private Map<String, Consumer<DataClass<?>>> functions;


    public   ArgumentParse() {
        flags = new HashMap<>();
        flags.put("-o", false);
        flags.put("-p", false);
        flags.put("-a", false);
        flags.put("-s", false);
        flags.put("-f", false);

        functions = new HashMap<>();
        functions.put("-s", DataClass::longStatic);
        functions.put("-f", DataClass::shortStatic);
    }

    public  void chooseArg(String[] args){
        int countFlag=0;
        for (String arg : args) {
            if (arg.startsWith("-")) {
                countFlag++;
            }
        }


        int indexO=0;
        int indexP=0;

        for (int i=0; i<countFlag;i++) {
            String currentArg = args[i];
            if (getFlags().containsKey(currentArg)) {
                getFlags().put(currentArg, true);
                if (currentArg.equals("-a")) {
                    DataArgumentFunction.getInstance().setWriteInFileRewrite(true);
                }
                else if (currentArg.equals("-o") && getFlags().get("-p").equals(false)) {
                    indexO = 1;
                }
                else if (currentArg.equals("-o") && getFlags().get("-p").equals(true)) {
                    indexO =2;
                }
                else if (currentArg.equals("-p") && getFlags().get("-o").equals(false)) {
                    indexP = 1;
                }
                else if (currentArg.equals("-p") && getFlags().get("-o").equals(true)) {
                    indexP = 2;
                }
            } else System.out.println("This flag don`t exist :" + args[i]);
        }

        if(getFlags().get("-p").equals(true)){
            DataArgumentFunction.getInstance().setWriteInFileNamePrefix(args[countFlag+indexP-1]);

        }

        if(getFlags().get("-o").equals(true)){
            DataArgumentFunction.getInstance().setWritePath(args[countFlag+indexO-1]);
        }

        System.out.println( DataArgumentFunction.getInstance().getWritePath());

        for (int i = countFlag+indexO+indexP; i < args.length ; i++) {
            DataArgumentFunction.getInstance().setAddReadFileFile(args[i]);
        }


    }



    public void executeFunction(DataClass<?> dataClass) {
        for (Map.Entry<String, Boolean> entry : flags.entrySet()) {
            String flag = entry.getKey();
            Boolean isExecute = entry.getValue();
            if (isExecute && functions.get(flag)!=null) {
                functions.get(flag).accept(dataClass);
            }
        }
    }

}
