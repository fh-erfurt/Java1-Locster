import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.time.LocalDateTime;

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
        Message testMessage = new Message(testText, null); // TODO JGE
        Assertions.assertEquals(testText, testMessage.getText());
    }

    @Test
    void time_test()
    {
        LocalDateTime time1 = LocalDateTime.now();
        Message msg = new Message("test text", null); // TODO JGE
        Assertions.assertEquals(time1, msg.getCreatedAt());
    }

    /**
     * example for a failing test.
     */
    @Test
    void message_should_contain_given_text_but_this_one_will_fail()
    {
        String testText = "Hi, wie geht's?";
        Message testMessage = new Message(testText + " nö", null); // TODO JGE
        Assertions.assertEquals(testText, testMessage.getText());
    }
}