public class Account {
    private long amount = 1000;

    //getter!
    public long getAmount() {
        return amount;
    }

    public void transfer(long transferamount) {
        //돈이 빠져나감.
        amount-=transferamount;
    }
}
