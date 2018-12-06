package Model.Expression;

import Model.ADT.IMyDictionary;
import Exception.*;

public class VarExp extends Exp{
    private String id;

    public VarExp(String id) {
        this.id = id;
    }

    @Override
    public String getVarName() {
        return id;
    }

    public int eval(IMyDictionary<String,Integer> tbl, IMyDictionary<Integer,Integer> heap) throws MyException
    {
        return tbl.get(id);
    }

    public String toString(){
        return id;
    }
}