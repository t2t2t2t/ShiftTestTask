package Data;

public class DataArgumentFunction {

    private static DataArgumentFunction instance;

    public static DataArgumentFunction getInstance (){
        if(instance==null){
            return instance=new DataArgumentFunction();
        }else
            return instance;
    }


    public String getWriteInFileNamePrefix() {
        return writeInFileNamePrefix;
    }

    public void setWriteInFileNamePrefix(String writeInFileNameFile) {
        this.writeInFileNamePrefix = writeInFileNameFile;
    }

    public boolean isWriteInFileRewrite() {
        return writeInFileRewrite;
    }

    public void setWriteInFileRewrite(boolean writeInFileRewrite) {
        this.writeInFileRewrite = writeInFileRewrite;
    }

    public String getReadFileFile() {
        return readFileFile;
    }

    public void setReadFileFile(String readFileFile) {
        readFileFile = readFileFile;
    }

    private String writeInFileNamePrefix="";
    private boolean writeInFileRewrite=false;
    private String  readFileFile="";

}
