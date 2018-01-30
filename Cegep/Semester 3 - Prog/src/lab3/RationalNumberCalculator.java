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
public class RationalNumberCalculator {
    public static void main(String[] args){
       
       String[] rat1 = new String[2];
       rat1 = args[0].split("/");
       
       Integer numerator1 = Integer.parseInt(rat1[0]);
       Integer denominator1 = Integer.parseInt(rat1[1]);
       //   System.out.println(rat1[0] +"and"+ rat1[1]);
       
       String operator;
       operator = args[1];
       System.out.print(operator+"------");
       
       if(operator.equals("build.xml"))
           operator = "*";
      
       
       String[] rat2 = new String[2];
       rat2 = args[2].split("/");
       
       Integer numerator2  = Integer.parseInt(rat2[0]);
       Integer denominator2 = Integer.parseInt(rat2[1]);
      //  System.out.println(rat2[0] +"and"+ rat2[1]);
      //  System.out.println(numerator1.toString());
       
       Rational answer;
       
       
       
       switch(operator){
           
           case "+": answer = (new Rational(new BigInteger(numerator1.toString()), new BigInteger(denominator1.toString()))).add(new Rational(new BigInteger(numerator2.toString()), new BigInteger(denominator2.toString()))); break;
           case "-": answer = (new Rational(new BigInteger(numerator1.toString()), new BigInteger(denominator1.toString()))).subtract(new Rational(new BigInteger(numerator2.toString()), new BigInteger(denominator2.toString()))); break;
           case "/": answer = (new Rational(new BigInteger(numerator1.toString()), new BigInteger(denominator1.toString()))).divide(new Rational(new BigInteger(numerator2.toString()), new BigInteger(denominator2.toString()))); break;
           case "*": answer = (new Rational(new BigInteger(numerator1.toString()), new BigInteger(denominator1.toString()))).multiply(new Rational(new BigInteger(numerator2.toString()), new BigInteger(denominator2.toString()))); break;
           default : answer = null; break;
       }
       
        System.out.println(args[0] + " " + args[1] + " " + args[2] + "= " + answer);
       
       
       
       
       
       
       
    }
}
