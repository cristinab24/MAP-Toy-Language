package Model.Expression;

import Model.ADT.IMyDictionary;

public class ConstExp extends Exp{
    private int number;

    public ConstExp(int number) {
        this.number = number;
    }

    @Override
    public String getVarName() {
        return null;
    }

    public int eval(IMyDictionary<String,Integer> tbl, IMyDictionary<Integer,Integer> heap)
    {
        return number;
    }

    public String toString(){
        return String.valueOf(number);
    }
}
