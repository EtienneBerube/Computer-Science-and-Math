/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.math.BigInteger;

/**
 *
 * @author Étienne Bérubé
 */
public class Rational extends Number implements Comparable<Rational> {
// Data fields for numerator and denominator
private BigInteger numerator = new BigInteger("0");
private BigInteger denominator = new BigInteger("1");
/** Construct a rational with default properties */

public Rational() {
this(new BigInteger("0"), new BigInteger("1"));
}

/** Construct a rational with specified numerator and denominator */
public Rational(BigInteger numerator, BigInteger denominator) {
long gcd = gcd(numerator, denominator);
this.numerator = ((denominator.compareTo(new BigInteger("0")) == 1) ? BigInteger.ONE : new BigInteger("-1")).multiply(new BigInteger(""+(numerator.divide(new BigInteger(""+gcd))))) ;
this.denominator = new BigInteger("" + (denominator.abs().divide(new BigInteger("" + gcd))));
}

/** Find GCD of two numbers */
private static long gcd(BigInteger n, BigInteger d) {
long gcd = (n.gcd(d)).longValue();

 return gcd;
 }

 /** Return numerator */
 public BigInteger getNumerator() {
 return numerator;
 }

 /** Return denominator */
 public BigInteger getDenominator() {
 return denominator;
 }

 /** Add a rational number to this rational */
 public Rational add(Rational secondRational) {
 BigInteger n = numerator.multiply(secondRational.getDenominator()).add(denominator.multiply(secondRational.getNumerator()));
 BigInteger d = denominator.multiply(secondRational.getDenominator());
 return new Rational(n, d);
 }

 /** Subtract a rational number from this rational */
 public Rational subtract(Rational secondRational) {
 BigInteger n = numerator.multiply(secondRational.getDenominator()).subtract(denominator.multiply(secondRational.getNumerator()));
 BigInteger d = denominator.multiply(secondRational.getDenominator());
 return new Rational(n, d);
 }

 /** Multiply a rational number by this rational */
 public Rational multiply(Rational secondRational) {
BigInteger n = numerator.multiply(secondRational.getNumerator());
 BigInteger d = denominator.multiply(secondRational.getDenominator());
 return new Rational(n, d);
 }

 /** Divide a rational number by this rational */
 public Rational divide(Rational secondRational) {
 BigInteger n = numerator.multiply(secondRational.getDenominator());
 BigInteger d = denominator.multiply(secondRational.getNumerator());
 return new Rational(n, d);
 }

 @Override
 public String toString() {
 if (denominator.equals(new BigInteger("1")))
 return numerator + "";
 else
 return numerator + "/" + denominator;
 }

 @Override // Override the equals method in the Object class
 public boolean equals(Object o) {
 if ((this.subtract((Rational)(o))).getNumerator().equals(new BigInteger("0")))
 return true;
else
 return false;
 }

 @Override // Implement the abstract intValue method in Number
 public int intValue() {
     BigInteger x = numerator.divide(denominator);
     int y = x.intValue();
 return y;
 }

 @Override // Implement the abstract floatValue method in Number
 public float floatValue() {
    BigInteger x = numerator.divide(denominator);
     float y = x.floatValue();
     
     return y;
 }

 @Override // Implement the doubleValue method in Number
 public double doubleValue() {
        BigInteger x = numerator.divide(denominator);
     double y = x.intValue();
     
     return y;
 }

 @Override // Implement the abstract longValue method in Number
 public long longValue() {
     BigInteger x = numerator.divide(denominator);
     long y = x.longValue();
     
     return y;
 }

 @Override // Implement the compareTo method in Comparable
 public int compareTo(Rational o) {
 if (this.subtract(o).getNumerator().compareTo(BigInteger.ONE)>0)
 return 1;
 else if (this.subtract(o).getNumerator().compareTo(BigInteger.ONE)<0)
 return -1;
 else
 return 0;
 }
}