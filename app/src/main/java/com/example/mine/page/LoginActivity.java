package com.example.mine.page;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.mine.R;


public class LoginActivity extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);



        NavController controller= Navigation.findNavController(this,R.id.login_fragment);
        NavigationUI.setupActionBarWithNavController(this,controller);

    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController controller=Navigation.findNavController(this,R.id.login_fragment);
        return  controller.navigateUp();
        //return super.onSupportNavigateUp();
    }
}
