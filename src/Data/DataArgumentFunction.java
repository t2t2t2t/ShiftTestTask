package Data;

public class DataArgumentFunction {

    private static DataArgumentFunction instance;

    public static DataArgumentFunction getInstance (){
        if(instance==null){
            return instance=new DataArgumentFunction();
        }else
            return instance;
    }


    public String getWriteInFileNameFile() {
        return writeInFileNameFile;
    }

    public void setWriteInFileNameFile(String writeInFileNameFile) {
        this.writeInFileNameFile = writeInFileNameFile;
    }

    public boolean isWriteInFileRewrite() {
        return writeInFileRewrite;
    }

    public void setWriteInFileRewrite(boolean writeInFileRewrite) {
        this.writeInFileRewrite = writeInFileRewrite;
    }

    public String getReadFileFile() {
        return ReadFileFile;
    }

    public void setReadFileFile(String readFileFile) {
        ReadFileFile = readFileFile;
    }

    private String writeInFileNameFile="";
    private boolean writeInFileRewrite=false;
    private String  ReadFileFile="";

}
