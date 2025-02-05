package Data;
//singleton

public class DataManager {

    private DataInteger dataInteger=new DataInteger();
    private DataString dataString=new DataString();
    private DataFloat dataFloat=new DataFloat();

    private static DataManager instance;

    public static DataManager getInstance (){
            if(instance==null){
                return instance=new DataManager();
            }else
                return instance;
    }

    public DataInteger getDataInteger() {
        return dataInteger;
    }

    public void setDataInteger(DataInteger dataInteger) {
        this.dataInteger = dataInteger;
    }

    public DataString getDataString() {
        return dataString;
    }

    public void setDataString(DataString dataString) {
        this.dataString = dataString;
    }

    public DataFloat getDataFloat() {
        return dataFloat;
    }

    public void setDataFloat(DataFloat dataFloat) {
        this.dataFloat = dataFloat;
    }
}
