package com.example.grant.financialfreedom;

        import java.util.Date;
        import java.lang.Math;
        import java.util.Calendar;

/**
 * Created by Grant on 11/8/2014. 
 */
public class AnnuityCalc {
    //calcualte lessened annuity 
    public static double AnnuityCalc(int numMonths,double dblPresentValue) {

        double dblInterestRate = .01;

        int dateDiff = numMonths*12;
        //if date diff is in years 
        int numberOfCompounds = dateDiff*360;

        double futureWithPayment = dblPresentValue*(Math.pow((1+dblInterestRate),(numberOfCompounds)-1)/dblInterestRate);
        double futureWithOutPayment = dblPresentValue*(Math.pow((1+dblInterestRate),(numberOfCompounds)-1)/dblInterestRate);

        return futureWithOutPayment-futureWithPayment-dblPresentValue;
    }
    //calculate interest rate 
    public double InterestCalc(Date datEndDate,double dblPresentValue,double dblInterestRate) {
        int numberOfCompoundsAnnually = 360;
        Date startDate = new Date();

        Calendar currentDate = Calendar.getInstance();
        Calendar endDate = Calendar.getInstance();
        currentDate.setTime(startDate);
        endDate.setTime(datEndDate);

        double dateDiff = currentDate.compareTo(endDate)/1000/3600/24/365;
        //need to know what unit numYears is

        return dblPresentValue*Math.pow((1+dblInterestRate/numberOfCompoundsAnnually),(numberOfCompoundsAnnually*dateDiff));
    }

    //run if choose lessened per month 
    public double LessenedAnnuityCalc(int intNumMonths, double dblTotalValue, double dblPresentValue){
        double lessenedAnnuityRate = (dblTotalValue/intNumMonths)-((dblTotalValue-dblPresentValue)/intNumMonths);
        return lessenedAnnuityRate;

    }
    //run if choose lessened months 
    public int NewMonthsCalc(double dblCurrentPayment, int intNumMonths, double dblPresentValue){
        int lessenedMonths = (int) (intNumMonths-dblPresentValue/dblCurrentPayment);
        return lessenedMonths;

    }
    //run if choose lessened months 
    public double RemainderAnnuityCalc(double dblCurrentPayment, int intNumMonths, double dblPresentValue){
        double remainderAnnuity = (dblPresentValue)/dblCurrentPayment/intNumMonths;
        return remainderAnnuity;
    }
    //run either way 
    public double NewTotalCalc(double dblTotalValue, double dblPresentValue){
        double newTotalValue = dblTotalValue-dblPresentValue;
        return newTotalValue;
    }


} 