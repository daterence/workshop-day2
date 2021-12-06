package workshop.day2;

public class FixedDepositAccount extends BankAccount{
    private float interest = 3f;
    private int durationInMonths = 6;
    public  boolean isInterestChanged = false;
    public boolean isDurationChanged = false;

    // first constructor
    public FixedDepositAccount(String name, Float balance){
        super(name, balance);
    }

    // second constructor
    public FixedDepositAccount (String name, Float balance, Float interest){
        super(name, balance);
        //TODO
    }

    // third constructor
    public FixedDepositAccount (String name, Float balance, Float interest, Integer duration){
        super(name, balance);
        //TODO
    }

    @Override
    public void deposit(float amount){ /* Do nothing */ }

    @Override
    public void withdraw(float amount){ /* Do nothing */ }

    public void setInterest(float interest){
        if (isInterestChanged){
            throw new IllegalArgumentException();
        }
        this.interest = interest;
        this.isInterestChanged = true;
    }

    public void setDurationInMonth(int durationInMonths){
        if(isDurationChanged){
            throw new IllegalArgumentException();
        }
        this.durationInMonths = durationInMonths;
        this.isDurationChanged = true;
    }

}
