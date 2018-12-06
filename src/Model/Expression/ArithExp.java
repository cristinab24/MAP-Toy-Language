package Model.Expression;

import Model.ADT.IMyDictionary;
import Exception.*;

public class ArithExp extends Exp{
    private Exp e1;
    private Exp e2;
    private int op; //1 stands for +, 2 for -, 3 for * and 4 for /

    public ArithExp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    public int eval(IMyDictionary<String,Integer> tbl, IMyDictionary<Integer,Integer> heap) throws MyException {
        int res;
        if(op>4 || op<1)
            throw new MyExprException("Operator invalid");
        if (op==1)
            res=e1.eval(tbl,heap)+e2.eval(tbl,heap);
        else
            if(op==2)
                res=e1.eval(tbl,heap)-e2.eval(tbl,heap);
            else
                if(op==3)
                    res=e1.eval(tbl,heap)*e2.eval(tbl,heap);
                else
                    {
                    if(e2.eval(tbl,heap)==0)
                        throw new MyExprException("Division by zero is not allowed.");
                    res = e1.eval(tbl,heap) / e2.eval(tbl,heap);
                }

        return res;
    }

    public String toString(){
        if(op==1)
            return e1.toString()+"+"+e2.toString();
        else
            if(op==2)
                return e1.toString()+"-"+e2.toString();
            else
                if(op==3)
                    return e1.toString()+"*"+e2.toString();
                else
                    return e1.toString()+"/"+e2.toString();
    }

    @Override
    public String getVarName() {
        return null;
    }
}
