package utils;

public class PageGenerator {
    private String name;

    public PageGenerator() {
        this.name = "world";
    }

    public PageGenerator(String name) {
        if(name.isBlank()){ // name.strip().length == 0, name.equals("")
            this.name ="world";
            return;
        }
        this.name = name;
    }

    public String  text() {


        return "Hello, "+name+"!"; //name은 필드로 가지고 있는다.
    }
}
