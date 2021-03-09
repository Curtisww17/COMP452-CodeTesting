import java.util.Random;

//this is a test double for Random
public class RandomDouble extends Random {

    int val;
    public RandomDouble(int val) {
        this.val = val;
    }

    //just return the same value you put in
    @Override
    public int nextInt(int upperBound) {
        return this.val;
    }
}
