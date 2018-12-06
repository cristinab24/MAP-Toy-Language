package Model.Statement;

import Model.ADT.IMyDictionary;
import Model.ADT.Pair;
import Model.PrgState;
import Exception.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;

public class OpenFileStmt implements IStmt{
    private String fileName;
    private String var;

    public OpenFileStmt(String fileName, String var) {
        super();
        this.fileName = fileName;
        this.var = var;
    }

    public PrgState execute(PrgState state) throws MyException {
        //IMyStack stk=state.getStk();
        IMyDictionary<String,Integer> symTbl= state.getSymTable();
        IMyDictionary<Integer, Pair<String, BufferedReader>> fileTable=state.getFileTable();
        Collection<Pair<String,BufferedReader>> values=fileTable.getValues();
        for(Pair<String, BufferedReader> val :values){
            if(val.getElement0().equals(fileName))
                throw new MyStmtExecException("File already open");
        }

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);
            Pair<String, BufferedReader> pair=new Pair<>(var,br);
            int fd=state.getNextFD();
            fileTable.put(fd,pair);
            symTbl.put(var,fd);
        } catch (IOException e) {
            throw new MyStmtExecException("File does not exist");
        }

        return state;
    }

    public String toString()
    {
        return "openRFile("+var+",\""+fileName+"\")";
    }
}
