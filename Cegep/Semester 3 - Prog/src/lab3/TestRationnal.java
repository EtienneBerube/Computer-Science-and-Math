package lab3;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.math.BigInteger;

/**
 *
 * @author Étienne Bérubé
 */
public class TestRationnal {
    public static void main(String[] args){
        Rational answer = new Rational(BigInteger.ZERO,BigInteger.ONE);
        
        for(int i = 1; i < 100; i++){
           
            answer = answer.add(new Rational ( new BigInteger("" + i) , new BigInteger(""+(i+1)) ) );
        }
        
        System.out.println(answer);
    }
}
