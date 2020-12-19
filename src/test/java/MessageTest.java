import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class MessageTest
{

    @BeforeEach
    void prepare()
    {
        // keine Ahnung
    }

    @Test
    void message_should_contain_given_text()
    {
        String testText = "Hi, wie geht's?";
        Message testMessage = new Message(testText);
        Assertions.assertEquals(testText, testMessage.getText());
    }

    /**
     * example for a failing test.
     */
    @Test
    void message_should_contain_given_text_but_this_one_will_fail()
    {
        String testText = "Hi, wie geht's?";
        Message testMessage = new Message(testText + " nö");
        Assertions.assertEquals(testText, testMessage.getText());
    }
}
