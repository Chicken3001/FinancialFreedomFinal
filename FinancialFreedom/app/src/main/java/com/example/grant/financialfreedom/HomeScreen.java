package com.example.grant.financialfreedom;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HomeScreen extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_screen);

        Intent recieveAccount = getIntent();

        User Alfred = (User)recieveAccount.getSerializableExtra("AccountInfo");
    }
}
