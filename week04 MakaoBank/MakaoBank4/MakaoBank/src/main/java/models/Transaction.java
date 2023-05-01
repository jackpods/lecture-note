package models;

import java.lang.annotation.Target;

public class Transaction {

    private String type;
    private int amount;

    public Transaction(String type, int amount) {
        this.type = type;
        this.amount = amount;
    }
//    비교 할 때 두 가지 개념
//    1. 동일 => == (둘이 같은 객체다) (primitive Type 은 그냥 값이 같다.)
//    2. 동등 => equals(둘이 같다고 취급)(객체를 값으로 취급)(값 객체,value Object)
//           => equals라는 메서드를 [오버라이딩]
    @Override
    public boolean equals(Object other){
        Transaction otherTransaction = (Transaction) other;
        return this.type.equals(otherTransaction.type) && this.amount == otherTransaction.amount;
    }


}
