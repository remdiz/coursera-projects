package mooc.vandy.java4android.gate.logic;

import java.util.Random;

import mooc.vandy.java4android.gate.ui.OutputInterface;

/**
 * This class uses your Gate class to manage a herd of snails.  We
 * have supplied you will the code necessary to execute as an app.
 * You must fill in the missing logic below.
 */
public class HerdManager {
    /**
     * Reference to the output.
     */
    private OutputInterface mOut;

    /**
     * The input Gate object.
     */
    private Gate mEastGate;

    /**
     * The output Gate object.
     */
    private Gate mWestGate;

    /**
     * Maximum number of iterations to run the simulation.
     */
    private static final int MAX_ITERATIONS = 10;

    /**
     * Size of nursery
     */
    public static final int HERD = 24;

    private int inThePen = HERD,
                outToPasture = 0;

    /**
     * Constructor initializes the fields.
     */
    public HerdManager(OutputInterface out,
                       Gate westGate,
                       Gate eastGate) {
        mOut = out;

        mWestGate = westGate;
        mWestGate.open(Gate.IN);

        mEastGate = eastGate;
        mEastGate.open(Gate.OUT);
    }

    public void simulateHerd(Random rand) {

        mOut.println("There are currently " + inThePen + " snails in the pen and " + outToPasture + " snails in the pasture");

        for (int idx = 0; idx < 10; idx++) {

            int randGate = rand.nextInt(10);
            Gate currentGate = randGate > 4 ? mWestGate : mEastGate;
            moveThroughTheGate(currentGate, rand);
            mOut.println("There are currently " + inThePen + " snails in the pen and " + outToPasture + " snails in the pasture");
        }

    }

    private void moveThroughTheGate(Gate gate, Random rand) {

        if ((gate.getSwingDirection() == Gate.IN && outToPasture > 0) || (gate.getSwingDirection() == Gate.OUT && inThePen == 0)) {
            int randQty = 1 + rand.nextInt(outToPasture);
            outToPasture -= randQty;
            inThePen += randQty;
        } else {
            int randQty = 1 + rand.nextInt(inThePen);
            outToPasture += randQty;
            inThePen -= randQty;
        }

    }


}
