package Data;

import java.util.ArrayList;
import java.util.List;

public class DataArgumentFunction {

    private String writeInFileNamePrefix="";
    private boolean writeInFileRewrite=false;

    public List<String> getReadFileFile() {
        return readFileFile;
    }

    public void setReadFileFile(List<String> readFileFile) {
        this.readFileFile = readFileFile;
    }

    public void setAddReadFileFile(String readFileFile) {
        this.readFileFile.add(readFileFile);
    }

    private List<String> readFileFile =new ArrayList<>();
    private String writePath="";

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


    public String getWritePath() {
        return writePath;
    }

    public void setWritePath(String writePath) {
        this.writePath = writePath;
    }

}
