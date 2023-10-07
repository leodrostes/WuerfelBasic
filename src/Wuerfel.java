import java.util.Random;

public class Wuerfel {
    public int werfen()
    {
        Random random = new Random();
        return random.nextInt(1,7);
    }

}
