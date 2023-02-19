public class Account {
    public String number = "123-456-778";
    private long amount = 1000;

    public String getNumber(){
        return number;
    }

    //getter!
    public long getAmount() {
        return amount;
    }

    public void transfer(long transferamount) {
        //돈이 빠져나감.
        amount -= transferamount;
    }

}
