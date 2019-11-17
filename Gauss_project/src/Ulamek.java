//Marcin Szczepaniak, gr. 3
//Anna Konstantynowicz, gr. 3

import com.sun.org.apache.bcel.internal.generic.BIPUSH;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Ulamek {

    final private BigInteger licznik;
    final private BigInteger mianownik;

    public Ulamek(float x) {
        this(Double.valueOf(x));
    }

    //https://algorithms.tutorialhorizon.com/convert-decimal-into-irreducible-fraction/
    public Ulamek(double x) {
        String a = "" + x;
        String spilts[] = a.split("\\."); // split using decimal
        int b = spilts[1].length(); // find the decimal length
        BigInteger mianownik = BigDecimal.valueOf(Math.pow(10, b)).toBigInteger();
        BigInteger licznik =  BigDecimal.valueOf(x * Math.pow(10, b)).toBigInteger();

        if (mianownik.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("The denominator is zero.");
        }
        if (licznik.equals(BigInteger.ZERO)) {
            this.licznik = BigInteger.ZERO;
            this.mianownik = BigInteger.ONE;
        } else {
            if (mianownik.compareTo(BigInteger.ZERO) == -1) {
                licznik = licznik.negate();
                mianownik = mianownik.negate();
            }
            BigInteger gcd = licznik.gcd(mianownik);
            this.licznik = licznik.divide(gcd);
            this.mianownik = mianownik.divide(gcd);
        }
    }

    public Ulamek(Ulamek u) {
        this.licznik = u.licznik;
        this.mianownik = u.mianownik;
    }

    //https://codereview.stackexchange.com/questions/165219/implementation-of-a-fraction-class-in-java immutability
    public Ulamek(BigInteger licznik, BigInteger mianownik) {
        if (mianownik.equals(BigInteger.ZERO)) {
            throw new IllegalArgumentException("The denominator is zero.");
        }
        if (licznik.equals(BigInteger.ZERO)) {
            this.licznik = BigInteger.ZERO;
            this.mianownik = BigInteger.ONE;
        } else {
            if (mianownik.compareTo(BigInteger.ZERO) == -1) {
                licznik = licznik.negate();
                mianownik = mianownik.negate();
            }
            BigInteger gcd = licznik.gcd(mianownik);
            this.licznik = licznik.divide(gcd);
            this.mianownik = mianownik.divide(gcd);
        }
    }


    public Ulamek subtract(Ulamek u) {
        return new Ulamek(
                this.licznik.multiply(u.mianownik).subtract(u.licznik.multiply(this.mianownik)),
                this.mianownik.multiply(u.mianownik)
        );
    }

    public Ulamek multiply(Ulamek u) {
        return new Ulamek(this.licznik.multiply(u.licznik), this.mianownik.multiply(u.mianownik));
    }

    public Ulamek divide(Ulamek u) {
        return new Ulamek(this.licznik.multiply(u.mianownik), this.mianownik.multiply(u.licznik));
    }

    public Ulamek add(Ulamek u) {
        return new Ulamek(
                this.licznik.multiply(u.mianownik).add(u.licznik.multiply(this.mianownik)),
                this.mianownik.multiply(u.mianownik)
        );
    }

    public static BigInteger sqrt(BigInteger val) {
        BigInteger half = BigInteger.ZERO.setBit(val.bitLength() / 2);
        BigInteger cur = half;

        while (true) {
            BigInteger tmp = half.add(val.divide(half)).shiftRight(1);

            if (tmp.equals(half) || tmp.equals(cur))
                return tmp;

            cur = half;
            half = tmp;
        }
    }

    public Ulamek sqrt() {
        return new Ulamek(sqrt(this.licznik), sqrt(this.mianownik));
    }

    public Ulamek abs() {
        return new Ulamek(licznik.abs(), mianownik);
    }

    public boolean isGreaterThan(Ulamek u) {
        BigInteger y = this.licznik.multiply(u.mianownik).subtract(this.mianownik.multiply(u.licznik));

        return (y.compareTo(BigInteger.ZERO) == 1) ? true : false;
    }

    public boolean equals(Ulamek u) {

        if (this.licznik.equals(u.licznik) && this.mianownik.equals(u.mianownik)) {
            return true;
        }
        else {
            return false;
        }
    }

    public double toDouble() {
        if (licznik == BigInteger.ZERO) {
            return 0;
        }
        else {
            return licznik.doubleValue() / mianownik.doubleValue();
        }
    }

    public String toStringUlamek() {
        return licznik + "/" + mianownik;
    }

    @Override
    public String toString() {
        return "" + this.toDouble();
    }
}
