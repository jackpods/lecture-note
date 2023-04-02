package utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PageGeneratorTest {
    @Test
    void defaultText(){ //이름 없이 만드는 것.
        PageGenerator pageGenerator = new PageGenerator();

        assertEquals( "Hello, world" +
                "!", pageGenerator.text());
    }

    @Test
    void textWithName(){
        PageGenerator pageGenerator = new PageGenerator("Ashal");

        assertEquals("Hello, Ashal!", pageGenerator.text());
    }

    @Test
    void textWithEmptyName(){
        PageGenerator pageGenerator = new PageGenerator("");

        assertEquals("Hello, world!", pageGenerator.text());
    }
}