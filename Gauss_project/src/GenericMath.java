import java.math.BigInteger;

public class GenericMath<T extends Number> {
    public T add(T a, T b) {
        if (a instanceof Double)
            return (T) Double.valueOf(a.doubleValue() + b.doubleValue());
        else if (a instanceof Float)
            return (T) Float.valueOf(a.floatValue() + b.floatValue());
        else if (a instanceof Ulamek) {
            return (T) ((Ulamek) a).add((Ulamek) b);
        }
        throw new IllegalArgumentException();
    }

    public T subtract(T a, T b) {
        if (a instanceof Double)
            return (T) Double.valueOf(a.doubleValue() - b.doubleValue());
        else if (a instanceof Float)
            return (T) Float.valueOf(a.floatValue() - b.floatValue());
        else if (a instanceof Ulamek) {
            return (T) ((Ulamek) a).subtract((Ulamek) b);
        }
        throw new IllegalArgumentException();
    }

    public T multiply(T a, T b) {
        if (a instanceof Double)
            return (T) Double.valueOf(a.doubleValue() * b.doubleValue());
        else if (a instanceof Float)
            return (T) Float.valueOf(a.floatValue() * b.floatValue());
        else if (a instanceof Ulamek) {
            return (T) ((Ulamek) a).multiply((Ulamek) b);
        }
        throw new IllegalArgumentException();
    }

    public T divide(T a, T b) {
        if (a instanceof Double)
            return (T) Double.valueOf(a.doubleValue() / b.doubleValue());
        else if (a instanceof Float)
            return (T) Float.valueOf(a.floatValue() / b.floatValue());
        else if (a instanceof Ulamek) {
            return (T) ((Ulamek) a).divide((Ulamek) b);
        }
        throw new IllegalArgumentException();
    }

    public T abs(T a) {
        if (a instanceof Double) {
            if (a.doubleValue() < 0)
                return (T) Double.valueOf(-a.doubleValue());
            else
                return (T) Double.valueOf(a.doubleValue());
        } else if (a instanceof Float) {
            if (a.floatValue() < 0)
                return (T) Float.valueOf(-a.floatValue());
            else
                return (T) Float.valueOf(a.floatValue());
        } else if (a instanceof Ulamek) {
            return (T) ((Ulamek) a).abs();
        }
        throw new IllegalArgumentException();
    }

    public boolean isGreaterThan(T a, T b) {
        if (a instanceof Double) {
            if (a.doubleValue() > b.doubleValue())
                return true;
            else
                return false;
        } else if (a instanceof Float) {
            if (a.floatValue() > b.doubleValue())
                return true;
            else
                return false;
        } else if (a instanceof Ulamek) {
            return ((Ulamek) a).isGreaterThan((Ulamek) b);
        }
        throw new IllegalArgumentException();
    }

    public T getZero(T[] a) {
        if (a[0] instanceof Double) {
            return (T) Double.valueOf(0);
        }
        if (a[0] instanceof Float) {
            return (T) Float.valueOf(0);
        }
        if (a[0] instanceof Ulamek) {
            return (T) new Ulamek(0);
        }
        throw new IllegalArgumentException();
    }

}