public class CoreCalculator {
    //상수 -> 가끔은 public 추천은 아
    public static final String[] OPERATORS = new String[]{"+","-","*","/","="};

    //프로그램의 핵심 상태

    public long currentNumber = 0;
    private long accumulator = 0;
    private String currentOperator = "";

    //currentNumber의 Getter(추천은 아니지만, 일단 사용)
    public long getCurrentNumber() { //  control+enter하면 getter 만들 수 있다
        return currentNumber;
    }
    //accumulator의 Getter(추천은 아니지만, 일단 사용)
    public long getAccumulator() {
        return accumulator;
    }

    //==================진짜로 할 수 있는 일!!!

    //숫자 눌렀을 때 활용
    public void addnumber(int number) {
        currentNumber *= 10;
        currentNumber += number;
    }
    //연산자 눌렀을 때 활용
    public void updateOperator(String operator) {
        currentOperator = operator;
    }

    //계산 <-- 가장 핵심!
    public void calculate( ) {
        switch (currentOperator) {
            case "" -> accumulator = currentNumber;
            case "+" -> accumulator += currentNumber;
            case "-" -> accumulator -= currentNumber;
            case "*" -> accumulator *= currentNumber;
            case "/" -> accumulator /= currentNumber;
        }
        currentNumber=0;
    }
}
