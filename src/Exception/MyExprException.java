package Exception;

public class MyExprException extends MyException {
    private String msg;

    public MyExprException(String m)
    {
        msg=m;
    }

    public String getMsg()
    {
        return msg;
    }
}
