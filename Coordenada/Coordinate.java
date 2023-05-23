public class Coordinate implements Comparable<Coordinate>, Cloneable {
    private int X;
    private int Y;

    public Coordinate(int X, int Y) {
        this.X = X;
        this.Y = Y;
    }

    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public void setX(int X) {
        this.X = X;
    }

    public void setY(int Y) {
        this.Y = Y;
    }

    // Construtor de cópia
    public Coordinate(Coordinate other) {
        this.X = other.X;
        this.Y = other.Y;
    }

    @Override
    public String toString() {
        return "(" + this.X + ", " + this.Y + ")";
    }

    @Override
    public int hashCode() {

        int hash = 1;
        int prime = 31;

        hash = prime * hash + Integer.valueOf(this.X).hashCode();
        hash = prime * hash + Integer.valueOf(this.Y).hashCode();

        if (hash < 0) {
            hash = -hash;
        }
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Coordinate other = (Coordinate) obj;

        if (X != other.X)
            return false;

        if (Y != other.Y)
            return false;

        return true;
    }

    @Override
    public Coordinate clone() {
        Coordinate ret = null;
        try {
            ret = new Coordinate(this);
        } catch (Exception ignore) {
        }
        return ret;
    }

    @Override
    public int compareTo(Coordinate other) {
        if (this.X < other.X) {
            return -1;
        } else if (this.X > other.X) {
            return 1;
        } else if (this.Y < other.Y) {
            return -1;
        } else if (this.Y > other.Y) {
            return 1;
        } else {
            return 0;
        }
    }
}
