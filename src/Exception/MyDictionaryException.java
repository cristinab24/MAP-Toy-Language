package Exception;

public class MyDictionaryException extends MyException {
    private String msg;

    public MyDictionaryException(String m)
    {
        msg=m;
    }

    public String getMsg()
    {
        return msg;
    }
}
