package utils;

public class GreetingPageGenerator extends PageGenerator{
    private String name;

    public GreetingPageGenerator() {
        this.name = "world";
    }

    public GreetingPageGenerator(String name) {
        if(name.isBlank()){ // name.strip().length == 0, name.equals("")
            this.name ="world";
            return;
        }
        this.name = name;
    }

    @Override
    public String html() {
        return "Hello, "+name+"!";
    }
}
