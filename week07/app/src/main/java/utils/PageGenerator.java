package utils;

public abstract class PageGenerator {
    public String html(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<meta charset=\"UTF-8\">\n" +
                "<title>MakaoBank</title>\n" +
                "</head>\n" +
                "<body>\n" +
                navigation() +
                content() +
                "</body>\n" +
                "</html>\n";
    }

    private String navigation() {
        return "<nav>\n" +
                "<a href=/>홈으로</a>\n"+
                "<a href=/account>잔액 조회</a>\n"+
                "<a href=/transfer>송금</a>\n"+
                "</nav>\n";
    }

    public abstract String content();
}

//링크가 실제로 세가지가 걸리는 것을 확인해야한다.-> 테스트 한다.