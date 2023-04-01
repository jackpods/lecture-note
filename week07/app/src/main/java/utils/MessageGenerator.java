package utils;

public class MessageGenerator {
    private String name;

    public MessageGenerator() {
        this.name = "world";
    }

    public MessageGenerator(String name) {
        this.name = name;
    }

    public String  text() {


        return "Hello, "+name+"!"; //name은 필드로 가지고 있는다.
    }
}
