package Model.Statement;

import Model.ADT.IMyDictionary;
import Model.ADT.Pair;
import Model.Expression.Exp;
import Model.PrgState;
import Exception.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.Collection;

public class ReadFileStmt implements IStmt {
    private Exp fileName;
    private String var;

    public ReadFileStmt(Exp fileName, String var) {
        super();
        this.fileName = fileName;
        this.var = var;
    }

    public PrgState execute(PrgState state) throws MyException {
        int value;
        boolean found=false;
        //IMyStack stk=state.getStk();
        IMyDictionary<String,Integer> symTbl= state.getSymTable();
        IMyDictionary<Integer, Pair<String, BufferedReader>> fileTable=state.getFileTable();
        Collection<Pair<String,BufferedReader>> values=fileTable.getValues();
        IMyDictionary<Integer, Integer> heap=state.getHeap();
        for(Pair<String, BufferedReader> pair :values){
            if(fileTable.getKeyByValue(pair).equals(fileName.eval(symTbl,heap))) {
                BufferedReader br=pair.getElement1();
                String sCurrentLine;
                try {
                    sCurrentLine = br.readLine();
                    value=Integer.parseInt(sCurrentLine);
                }
                catch (IOException ignored){
                    value=0;
                }
                if (symTbl.containsKey(var))
                    symTbl.update(var, value);
                else
                    symTbl.put(var,value);
                found=true;
                break;
            }
        }
        if(!found) throw new MyStmtExecException("File not open");

        return state;
    }

    public String toString()
    {
        return "readFile("+fileName.toString()+",\""+var+"\")";
    }
}
