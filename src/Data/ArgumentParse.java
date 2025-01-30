package Data;

import java.util.HashMap;
import java.util.Map;
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
       // functions.put("-a", DataClass::writeInFile);
        functions.put("-s", DataClass::longStatic);
        functions.put("-f", DataClass::shortStatic);
    }

    public  void chooseArg(String arg){
        if(getFlags().containsKey(arg)){
            getFlags().put(arg,true);
        }
        else System.out.println("This flag don`t exist :"+arg);
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
