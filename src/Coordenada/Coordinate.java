package Coordenada;

public class Coordinate implements  Cloneable {
    
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
    public int hashCode() {

        int hash = 1;
        int prime = 31;

        hash *= prime + Integer.valueOf(this.X).hashCode();
        hash *= prime + Integer.valueOf(this.Y).hashCode();

        if (hash < 0) hash = -hash;
        
        return hash;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;
        if (obj == null) return false;
        if (this.getClass() != obj.getClass()) return false;

        Coordinate that = (Coordinate) obj;

        if (this.X != that.X) return false;
        if (this.Y != that.Y) return false;

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
    public String toString() {
        return "(" + this.X + ", " + this.Y + ")";
    }
}
