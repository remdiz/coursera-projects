package mooc.vandy.java4android.buildings.logic;

/**
 * This is the Building class file.
 */
public class Building {
    
    private int mLength,
                mWidth,
                mLotLength,
                mLotWidth;

    public Building(int length, int width, int lotLength, int lotWidth) {

        mLength = length;
        mWidth = width;
        mLotLength = lotLength;
        mLotWidth = lotWidth;

    }

    public int getLength() {

        return mLength;

    }

    public int getWidth() {
        return mWidth;
    }

    public int getLotLength() {
        return mLotLength;
    }

    public int getLotWidth() {
        return mLotWidth;
    }

    public void setLength(int length) {
        this.mLength = length;
    }

    public void setWidth(int width) {
        this.mWidth = width;
    }

    public void setLotLength(int lotLength) {
        this.mLotLength = lotLength;
    }

    public void setLotWidth(int lotWidth) {
        this.mLotWidth = lotWidth;
    }

    public int calcBuildingArea() {

        return mLength * mWidth;

    }

    public int calcLotArea() {

        return mLotWidth * mLotLength;

    }

    public String toString() {

        return "Building object";

    }

}
