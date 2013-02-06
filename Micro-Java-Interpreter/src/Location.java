public class Location {
    public static int nextLocationCounter = 0;

    public int index;

    // Maybe change this whole class to a Singleton later if there
    // will be issues with synchronization or something.
    public Location() {
        index = nextLocationCounter++;
    }

    public Location(int index) {
        this.index = index;
    }

    public boolean equals(Object o) {
        if (o instanceof Location) {
            Location other = (Location) o;
            return other.index == this.index;
        }
        return false;
    }

}
