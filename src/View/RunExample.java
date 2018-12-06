package View;

import Controller.Ctrl;
import Exception.*;

public class RunExample extends Command {
    private Ctrl ctr;

    public RunExample(String key, String desc,Ctrl ctr){
        super(key, desc);
        this.ctr=ctr;
    }
    @Override
    public void execute() {
        try{
            ctr.allStep(); }
        catch (MyException e) {
            System.out.println(e.getMsg());
        }
    }
}