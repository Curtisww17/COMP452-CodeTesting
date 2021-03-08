
//this is a test double for
public class RandomDouble {

    int val;
    public RandomDouble(int val) {
        this.val = val;
    }

    //just return the same value you put in
    public int nextInt(int upperBound) {
        return this.val;
    }
}
