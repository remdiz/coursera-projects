package mooc.vandy.java4android.buildings.logic;

/**
 * This is the office class file, it is a subclass of Building.
 */
public class Office extends Building {
       
    private String mBusinessName;
    private int mParkingSpaces;
    private static int sTotalOffices = 0;

    public Office(int length, int width, int lotLength, int lotWidth) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = null;
        this.mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        this.mParkingSpaces = 0;
        sTotalOffices++;
    }

    public Office(int length, int width, int lotLength, int lotWidth, String businessName, int parkingSpaces) {
        super(length, width, lotLength, lotWidth);
        this.mBusinessName = businessName;
        this.mParkingSpaces = parkingSpaces;
        sTotalOffices++;
    }

    public String getBusinessName() {
        return mBusinessName;
    }

    public int getParkingSpaces() {
        return mParkingSpaces;
    }

    public void setBusinessName(String mBusinessName) {
        this.mBusinessName = mBusinessName;
    }

    public void setParkingSpaces(int mParkingSpaces) {
        this.mParkingSpaces = mParkingSpaces;
    }

    @Override
    public String toString() {
        String businessName = getBusinessName();
        int parkingSpaces = getParkingSpaces();
        String output = "Business: ";
        if (businessName == null)
            output += "unoccupied";
        else
            output += businessName;
        if (parkingSpaces > 0)
            output += "; has " + parkingSpaces + " parking spaces";
        output += " (total offices: " + sTotalOffices + ")";
        return output;
    }

    public boolean equals(Object other) {

        Office otherOffice = (Office)other;
        return calcBuildingArea() == otherOffice.calcBuildingArea() && getParkingSpaces() == otherOffice.getParkingSpaces();

    }

}
