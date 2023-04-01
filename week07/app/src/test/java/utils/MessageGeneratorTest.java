package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MessageGeneratorTest {
    @Test
    void defaultText(){ //이름 없이 만드는 것.
        MessageGenerator messageGenerator = new MessageGenerator();

        assertEquals("Hello, world" +
                "!", messageGenerator.text());
    }

    @Test
    void textWithName(){
        MessageGenerator messageGenerator = new MessageGenerator("Ashal");

        assertEquals("Hello, Ashal!", messageGenerator.text());
    }
}