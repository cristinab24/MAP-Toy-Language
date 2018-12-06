package Exception;

public class MyStmtExecException extends MyException {
    private String msg;

    public MyStmtExecException(String m)
    {
        msg=m;
    }

    public String getMsg()
    {
        return msg;
    }
}
