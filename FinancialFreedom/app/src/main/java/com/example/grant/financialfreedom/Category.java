package com.example.grant.financialfreedom;

/**
 * Created by Grant on 11/9/2014.
 */
public class Category {
    public String categoryName;
    public double totalBalance;
    public double currentBalance;

    public Category(String name, double balance)
    {
        categoryName = name;
        totalBalance = balance;
        currentBalance = balance;
    }

    public void Reset(){
        currentBalance = totalBalance;
    }

    public void Spend(double amount)
    {
        currentBalance -= amount;
    }

    public void SetBalance(double newBalance)
    {
        currentBalance += this.totalBalance - newBalance;
        this.totalBalance = newBalance;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public double getTotalBalance()
    {
        return totalBalance;
    }

    public double getCurrentBalance()
    {
        return currentBalance;
    }

    public String getCategoryName()
    {
        return categoryName;
    }

    public String toString(){
        return categoryName + "     " + currentBalance;
    }
}
