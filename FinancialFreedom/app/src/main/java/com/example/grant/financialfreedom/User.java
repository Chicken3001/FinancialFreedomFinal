package com.example.grant.financialfreedom;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Grant on 11/9/2014.
 */
public class User implements Serializable{
    String email, username, password;
    ArrayList<Category> categories = new ArrayList<Category>();
    ArrayList<Expense> expenseList = new ArrayList<Expense>();
    Goal[] listofGoals = new Goal[5];
    int goalindex = 0;
    double income, expenses, sparecashtotal, sparecashinvest, sparecashspend;


    public User(String em, String un, String pw, double in, double out)
    {
        email = em;
        username = un;
        password = pw;
        income = in;
        expenses = out;
        calculateSpareCashTotal();
        listofGoals[0] = new Goal("",0);
        listofGoals[1] = new Goal("",0);
        listofGoals[2] = new Goal("",0);
        listofGoals[3] = new Goal("",0);
        listofGoals[4] = new Goal("",0);
    }

    public Goal[] getListofGoals() {
        return listofGoals;
    }

    public void setListofGoals(Goal[] listofGoals) {
        this.listofGoals = listofGoals;
    }

    public void addGoal(Goal newGoal){
        listofGoals[goalindex++] = newGoal;

    }

    public String[] getGoalNames(){
        String[] temp = new String[5];
        int i = 0;
        for(Goal item : listofGoals)
        {
            if(item!=null) {
                temp[i] = item.getGoalName();
                i++;
            }
        }
        return temp;
    }

    public double[] getGoalAmounts(){
        double[] temp = new double[5];
        int i = 0;
        for(Goal item : listofGoals)
        {
            temp[i++] = item.getFundsLeft();
        }
        return temp;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setSparecashtotal(double sparecashtotal) {
        this.sparecashtotal = sparecashtotal;
    }

    public void setSparecashinvest(double a) {
        this.sparecashinvest = a;
        this.sparecashspend = sparecashtotal - a;
    }

    public void setSparecashspend(double a) {
        this.sparecashspend = a;
        this.sparecashinvest = sparecashtotal - a;
    }

    public double getExpenses() {
        return expenses;
    }

    public double getIncome() {
        return income;
    }

    public double getSparecash() {
        return sparecashtotal;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public void calculateSpareCashTotal()
    {
        sparecashtotal = income - expenses;
    }

    public void addCategory(Category n)
    {
        categories.add(n);
    }

    public void addCategory(String name, double value){
        categories.add(new Category(name, value));
    }

    public double categoryTotalValue(){
        double sum = 0;
        for(Category item : categories)
        {
            sum += item.getTotalBalance();
        }
        return sum;
    }

    public double categoryCurrentValue(){
        double sum = 0;
        for(Category item : categories)
        {
            sum += item.getCurrentBalance();
        }
        return sum;
    }

    public double categoryUnassignedValue(){
        return categoryTotalValue() - sparecashspend;
    }

    public Category getCategory(int n)
    {
        return categories.get(n);
    }

    public Category getCategory(String name){
        for(Category item : categories)
        {
            if(item.getCategoryName().equals(name))
                return item;
        }
        return null;
    }

    public void setCategoryName(int n, String newname){
        getCategory(n).setCategoryName(newname);
    }

    public void setCategoryName(String oldname, String newname){
        getCategory(oldname).setCategoryName(newname);
    }

    public void setCategoryBalance(int n, double newbalance){
        getCategory(n).SetBalance(newbalance);
    }

    public void setCategoryBalance(String name, double newbalance){
        getCategory(name).SetBalance(newbalance);
    }

    public void categorySpend(Category category, double amount){
        category.Spend(amount);
    }



    public void incurExpense(Expense e){
        if(e.associatedCategory!=null)
        {
            categorySpend(getCategory(e.getAssociatedCategory().categoryName),e.getExpenseAmount());
        }
    }





    @Override
    public String toString() {
        return username;
    }
}
