package mooc.vandy.java4android.buildings.logic;

/**
 * This is the House class file that extends Building.
 */
public class House extends Building {

    private String mOwner;

    private boolean mPool;

    public House(int length, int width, int lotLength, int lotWidth) {

        super(length, width, lotLength, lotWidth);
        mOwner = null;
        mPool = false;

    }

    public House(int length, int width, int lotLength, int lotWidth, String owner) {

        super(length, width, lotLength, lotWidth);
        mOwner = owner;
        mPool = false;

    }

    public House(int length, int width, int lotLength, int lotWidth, String owner, boolean pool) {

        super(length, width, lotLength, lotWidth);
        mOwner = owner;
        mPool = pool;

    }

    public String getOwner() {
        return mOwner;
    }

    public boolean hasPool() {

        return mPool;

    }

    public void setOwner(String owner) {
        this.mOwner = owner;
    }

    public void setPool(boolean pool) {
        this.mPool = pool;
    }

    @Override
    public String toString() {
        int buildingArea = calcBuildingArea();
        int lotArea = calcLotArea();
        return "Owner: " + mOwner + (mPool ? "; has a pool" : "") + (lotArea > buildingArea ? "; has a big open space" : "");
    }

    public boolean equals(Object other) {

        return calcBuildingArea() == ((House) other).calcBuildingArea() && hasPool() == ((House) other).hasPool();

    }

}
