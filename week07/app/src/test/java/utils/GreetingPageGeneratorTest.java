package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GreetingPageGeneratorTest {
    @Test
    void defaultText(){ //이름 없이 만드는 것.
        PageGenerator pageGenerator = new GreetingPageGenerator();

        assertTrue(pageGenerator.html().contains("Hello, world!"));
    }

    @Test
    void textWithName(){
        PageGenerator pageGenerator = new GreetingPageGenerator("jack");

        assertTrue(pageGenerator.html().contains("Hello, jack!"));
    }

    @Test
    void textWithEmptyName(){
        PageGenerator pageGenerator = new GreetingPageGenerator("");

        assertTrue(pageGenerator.html().contains("Hello, world!"));
    }
}