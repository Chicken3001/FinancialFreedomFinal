package com.example.grant.financialfreedom;

/**
 * Created by Grant on 11/9/2014.
 */
public class Expense {
    String expenseName;
    double expenseAmount;
    Category associatedCategory;

    public Expense(String name, double amount){
        expenseName = name;
        expenseAmount = amount;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public double getExpenseAmount() {
        return expenseAmount;
    }

    public Category getAssociatedCategory() {
        return associatedCategory;
    }

    public void setAssociatedCategory(Category associatedCategory) {
        this.associatedCategory = associatedCategory;
    }

    @Override
    public String toString() {
        return expenseName + "      " + expenseAmount;
    }
}
