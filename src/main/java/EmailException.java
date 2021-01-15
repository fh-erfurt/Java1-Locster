public class EmailException extends RuntimeException
{
    public EmailException(String message)
    {
        super( message);
        System.out.println( "Error Message: " + message);
    }
}
