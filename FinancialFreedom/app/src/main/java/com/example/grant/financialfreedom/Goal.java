package com.example.grant.financialfreedom;

/**
 * Created by Grant on 11/9/2014.
 */
public class Goal {
    String goalName;
    double currentFunds, totalFundsRequired, fundsLeft;

    public Goal(String name, double total)
    {
        goalName = name;
        totalFundsRequired = total;
        currentFunds = 0;
        fundsLeft = totalFundsRequired;
    }

    public String getGoalName() {
        return goalName;
    }

    public void setGoalName(String goalName) {
        this.goalName = goalName;
    }

    public double getCurrentFunds() {
        return currentFunds;
    }

    public void setCurrentFunds(double currentFunds) {
        this.currentFunds = currentFunds;
    }

    public double getTotalFundsRequired() {
        return totalFundsRequired;
    }

    public void setTotalFundsRequired(double totalFundsRequired) {
        this.totalFundsRequired = totalFundsRequired;
    }

    public double getFundsLeft() {
        return fundsLeft;
    }

    public void setFundsLeft(double fundsLeft) {
        this.fundsLeft = fundsLeft;
    }

    @Override
    public String toString() {
        if(totalFundsRequired==0)
            return "";
        return goalName + "                   " + fundsLeft;
    }
}


