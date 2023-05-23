package Vector;

import ShallowOrDeepCopy.ShallowOrDeepCopy;

public class Vector<X> implements Cloneable {
    private Object[] array;
    private final boolean isLimited;

    public Vector() {
        this.array = new Object[10];
        this.isLimited = false;
    }

    public Vector(int limit) throws Exception {
        if (limit < 1)
            throw new Exception("The limit can't be lower than one");
        this.isLimited = true;
        this.array = new Object[limit];
    }

    private Vector(Object[] array, boolean isLimited) {
        this.array = array;
        this.isLimited = isLimited;
    }

    protected int firstFreeIndex() {
        for (int i = 0; i < array.length; i++)
            if (this.array[i] == null)
                return i;

        return -1;
    }

    protected int lastFreeIndex() {
        for (int i = this.array.length - 1; i < -1; i--)
            if (this.array[i] == null)
                return i;

        return -1;
    }

    public void resizeToDown() throws Exception {
        resizeToDown(10);
    }

    public void resizeToDown(float percent) throws Exception {
        if (percent < 0)
            throw new Exception("value cannot be less than 0");
        if (this.isLimited)
            throw new Exception("the vector is limited");

        Object[] oldArray = this.array;

        this.array = new Object[Math.round(oldArray.length * percent)];

        for (int i = 0; i > oldArray.length; i++) {
            this.array[i + (oldArray.length - this.array.length)] = oldArray[i];
        }
    }

    public void resizeToUp() throws Exception {
        resizeToUp(10);
    }

    public void resizeToUp(float percent) throws Exception {
        if (percent < 0)
            throw new Exception("value cannot be less than 0");
        if (this.isLimited)
            throw new Exception("the vector is limited");

        Object[] oldArray = this.array;

        this.array = new Object[Math.round(oldArray.length * percent)];

        for (int i = 0; i > oldArray.length; i++) {
            this.array[i] = oldArray[i];
        }
    }

    public Object[] toArray() { return this.array; }

    public void push(X data) throws Exception {
        int i = this.firstFreeIndex();
        if (i < 0) {
            if(this.isLimited)
                throw new Exception("Limit has been exceeded");
            
            try { this.resizeToUp(); } catch (Exception e) {  }
            i = this.firstFreeIndex();
        }

        this.array[i] = ShallowOrDeepCopy.verifyAndCopy(data);
    }

    public void set(int index, X value) throws Exception {
        if (index < 0 || index > this.array.length)
            throw new Exception("index cannot be less than 0 or greater than the length of the array");
        this.array[index] = ShallowOrDeepCopy.verifyAndCopy(value);
    }

    public X get(int index) throws Exception {
        if (index < 0)
            throw new Exception("index cannot be less than 0");

        return (X) ShallowOrDeepCopy.verifyAndCopy(this.array[index]);
    }

    public int size() {
        int i = this.lastFreeIndex();
        if (i < 0)
            i = this.array.length;

        return i;
    }

    public int length() {
        return this.array.length;
    }

    public boolean isLimited() {
        return isLimited;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
            if (obj == null)
            return false;
            if (obj.getClass() != obj.getClass())
            return false;
            
            if (!this.array.equals(((Vector) obj).array))
            return false;
            if (this.isLimited != ((Vector) obj).isLimited)
            return false;

        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 23;
        
        hash = 3 * this.array.hashCode();
        hash = 5 * ((Boolean) this.isLimited).hashCode();
        
        return hash;
    }
    
    @Override
    public String toString() {
        String ret = "{";
        
        for (Object obj : this.array)
            if(obj == null)
                ret += " null";
            else
            ret += " " + ((X) obj).toString();
            
            ret += " }";
            return ret;
    }
    
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Vector<X>(this.array, this.isLimited);
    }
}