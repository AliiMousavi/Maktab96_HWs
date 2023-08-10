package q1;

import lombok.Getter;

@Getter
public class Rational {
    private int numerator; //Soorat
    private int denominator; //Makhraj
    public Rational(){
        numerator =0;
        denominator =1;
    }

    public void setSimplifiedValue(int numerator, int denominator){
        int maxMutualDivisor = 1;
        for (int i =2; i<=Math.max(Math.abs(numerator),Math.abs(denominator))/2; i++){
            if (Math.abs(numerator)%i == 0 && Math.abs(denominator)%i == 0)
                maxMutualDivisor = i;
        }
        this.numerator = numerator/maxMutualDivisor;
        this.denominator = denominator/maxMutualDivisor;
    }

    public Rational add (Rational number){
        Rational result = new Rational();
        result.setSimplifiedValue(this.numerator * number.denominator + this.denominator * number.numerator, this.denominator * number.denominator);
        return result;
    }
    public Rational sub (Rational number){
        Rational result = new Rational();
        result.setSimplifiedValue(this.numerator * number.denominator - this.denominator * number.numerator, this.denominator * number.denominator);
        return result;
    }
    public Rational mul (Rational number){
        Rational result = new Rational();
        result.setSimplifiedValue(this.numerator * number.numerator, this.denominator * number.denominator);
        return result;
    }
    public Rational div (Rational number){
        Rational result = new Rational();
        result.setSimplifiedValue(this.numerator * number.denominator, this.denominator * number.numerator);
        return result;
    }
    public double toFloatingPoint(){
        return (float)this.numerator/(float)this.denominator;
    }

    public String toString(){
        String result ="";
        if(this.numerator == 0)
            result += "0";
        else
            result += numerator + "/" + denominator;
        return result;
    }

    public String toComplexNumber(){
        String result = "";
        int complete = this.numerator / this.denominator;
        Rational remainedRational = new Rational();
        remainedRational.setSimplifiedValue(this.numerator-complete * this.denominator , this.denominator);
        result += complete + " + " + remainedRational;
        return result;
    }

    public void setValue(int numerator , int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

}
