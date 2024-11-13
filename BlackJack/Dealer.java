import java.util.List;
import java.util.ArrayList;

public class Dealer extends Player {
    public Dealer() {
        super(0); // Dealer does not need a balance
    }

    public boolean shouldHit() {
        return getHandTotal() <= 16;
    }
}
