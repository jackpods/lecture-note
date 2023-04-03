package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GreetingPageGeneratorTest {
    @Test
    void defaultText(){ //이름 없이 만드는 것.
        PageGenerator pageGenerator = new GreetingPageGenerator();

        assertEquals("Hello, world" +
                "!", pageGenerator.html());
    }

    @Test
    void textWithName(){
        PageGenerator pageGenerator = new GreetingPageGenerator("jack");

        assertEquals("Hello, jack!", pageGenerator.html());
    }

    @Test
    void textWithEmptyName(){
        PageGenerator pageGenerator = new GreetingPageGenerator("");

        assertEquals("Hello, world!", pageGenerator.html());
    }
}