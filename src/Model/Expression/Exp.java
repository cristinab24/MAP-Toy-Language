package Model.Expression;

import Model.ADT.IMyDictionary;
import Exception.*;

public abstract class Exp {
    public abstract int eval(IMyDictionary<String,Integer> tbl, IMyDictionary<Integer,Integer> heap) throws MyException;
    public abstract String toString();//again other option is to use toString instead of this toStr
    public abstract String getVarName();
}
