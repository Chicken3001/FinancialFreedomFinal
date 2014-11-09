package com.example.grant.financialfreedom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    User Alfred = new User("m","Alfred","duck15",6500,6000);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        Alfred.setSparecashinvest(100.0);
        Alfred.addGoal(new Goal("House",250000));
        Alfred.addGoal(new Goal("Car",50000));
        Alfred.addGoal(new Goal("Vacation",2500));
        Alfred.addGoal(new Goal("Wedding",25000));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void login_attempt(View view) {
        EditText usernameentry = (EditText)findViewById(R.id.email);
        EditText passwordentry = (EditText)findViewById(R.id.password);

        String username = String.valueOf(usernameentry.getText());
        String password = String.valueOf(passwordentry.getText());

        if(!username.equals(Alfred.getEmail()) || !password.equals(Alfred.getPassword()))
        {
            Toast.makeText(this,"Invalid login, please try again",Toast.LENGTH_LONG).show();
        }
        else
        {
            /*Intent sendOverLogin = new Intent(MainActivity.this,HomeScreen.class);

            sendOverLogin.putExtra("AccountInfo",Alfred);

            MainActivity.this.startActivity(sendOverLogin);*/

            setContentView(R.layout.home_screen);
            TextView disIncome = (TextView)findViewById(R.id.DisposableIncomeView);
            disIncome.setText(String.valueOf(Alfred.getSparecash()));


        }
    }

    public void LogOut(View view) {
        setContentView(R.layout.login);
    }

    public void NewUser(View view) {
        setContentView(R.layout.new_user);
    }

    public void HomeScreen(View view){
        setContentView(R.layout.home_screen);
        TextView disIncome = (TextView)findViewById(R.id.DisposableIncomeView);
        disIncome.setText(String.valueOf(Alfred.getSparecash()));

    }

    public void newGoal(View view){
        setContentView(R.layout.new_goal);
    }

    public void Goals(View view){
        setContentView(R.layout.goals);
        ListView listgoals = (ListView)findViewById(R.id.GoalsList);
        ListAdapter myAdaptor = new ArrayAdapter<Goal>(this,android.R.layout.simple_list_item_1,Alfred.getListofGoals());
        listgoals.setAdapter(myAdaptor);
    }

    public void setGoal(View view){
        EditText name = (EditText)findViewById(R.id.goalname);
        EditText amount = (EditText)findViewById(R.id.totalgoalcost);

        String goalname = String.valueOf(name.getText());
        double goalcost = (double)Integer.parseInt(String.valueOf(amount.getText()));

        Alfred.addGoal(new Goal(goalname, goalcost));

        setContentView(R.layout.goals);
        ListView listgoals = (ListView)findViewById(R.id.GoalsList);
        ListAdapter myAdaptor = new ArrayAdapter<Goal>(this,android.R.layout.simple_list_item_1,Alfred.getListofGoals());
        listgoals.setAdapter(myAdaptor);
    }

    public void addFunds(View view){
        double importantthing = AnnuityCalc.AnnuityCalc(240,Alfred.getSparecash());
        double temp = importantthing-Alfred.getSparecash();
        Toast.makeText(this,"Future Value: " + importantthing + " Interest earned: " + temp,Toast.LENGTH_LONG).show();
        Alfred.setSparecashtotal(0);
        Alfred.listofGoals[0].fundsLeft -= importantthing;
    }

    public void Loans(View view){
        setContentView(R.layout.loans);
    }

    public void newLoan(View view){
        setContentView(R.layout.new_loan);
    }

    public void Spending(View view){
        setContentView(R.layout.spending);
    }

   /*TextView idView;
    EditText incomeBox;
    EditText expenseBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        idView = (TextView) findViewById(R.id.userID);
        incomeBox = (EditText) findViewById(R.id.userIncome);
        expenseBox =
                (EditText) findViewById(R.id.userExpenses);
    }

    public void newUser (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        String Name =
                idView.getText().toString();

        User userName =
                new User(idView.getText().toString(), Name);

        dbHandler.addUser(userName);
        incomeBox.setText("");
        expenseBox.setText("");
    }

    public void lookupUser (View view) {
        MyDBHandler dbHandler = new MyDBHandler(this, null, null, 1);

        User userName =
                dbHandler.findUser(idView.getText().toString());

        if (userName != null) {
            idView.setText(String.valueOf(userName.getUserName()));

            incomeBox.setText(String.valueOf(userName.getUserIncome()));
            expenseBox.setText(String.valueOf(userName.getUserExpenses()));
        } else {
            idView.setText("No Match Found");
        }
    }
    quantityBox.setText(String.valueOf(product.getQuantity()));
} else {
        idView.setText("No Match Found");
        }
        }*/
        }

