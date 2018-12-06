package Model.Expression;

import Exception.MyException;
import Exception.MyExprException;
import Model.ADT.IMyDictionary;

public class BooleanExp extends Exp{
    private Exp e1;
    private Exp e2;
    private int op; //1 stands for <, 2 for <=, 3 for ==, 4 for !=, 5 for >=, 6 for >

    public BooleanExp(Exp e1, Exp e2, int op) {
        this.e1 = e1;
        this.e2 = e2;
        this.op = op;
    }

    @Override
    public int eval(IMyDictionary<String,Integer> tbl, IMyDictionary<Integer,Integer> heap) throws MyException {
        int res;
        switch (op){
            case 1:{
                res=e1.eval(tbl,heap)<e2.eval(tbl,heap) ? 1 : 0;
                break;
            }
            case 2: {
                res=e1.eval(tbl,heap)<=e2.eval(tbl,heap) ? 1 : 0;
                break;
            }
            case 3: {
                res=e1.eval(tbl,heap)==e2.eval(tbl,heap) ? 1 : 0;
                break;
            }
            case 4:{
                res=e1.eval(tbl,heap)!=e2.eval(tbl,heap) ? 1 : 0;
                break;
            }
            case 5:{
                res=e1.eval(tbl,heap)>=e2.eval(tbl,heap) ? 1 : 0;
                break;
            }
            case 6:{
                res=e1.eval(tbl,heap)==e2.eval(tbl,heap) ? 1 : 0;
                break;
            }
            default:
                throw new MyExprException("Operator invalid");
        }
        return res;
    }

    @Override
    public String toString(){
        switch (op){
            case 1:{
                return e1.toString()+"<"+e2.toString();
            }
            case 2: {
                return e1.toString()+"<="+e2.toString();
            }
            case 3: {
                return e1.toString()+"=="+e2.toString();
            }
            case 4:{
                return e1.toString()+"!="+e2.toString();
            }
            case 5:{
                return e1.toString()+">="+e2.toString();
            }
            case 6:{
                return e1.toString()+">"+e2.toString();
            }
            default:
                return "";
        }
    }

    @Override
    public String getVarName() {
        return null;
    }
}
