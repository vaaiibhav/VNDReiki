package me.vaaiibhav.www.vndreiki;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import me.vaaiibhav.www.vndreiki.modal.ConstantClass;

public class LoginActivity extends AppCompatActivity {
    SharedPreferences sp ;
    ConstantClass cs;
    String personName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        cs = new ConstantClass();
        sp =getSharedPreferences(cs.PREFNAME,0);
        personName =sp.getString(cs.PREFNAME,"");
        if(personName!=null) {
            Fragment login = new LoginFragment();
            android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.lo_loginContainer, login);
            ft.commit();
        }
        else{
            gotoMenu();
        }



    }

    private void gotoMenu() {
        Intent gotoMenu = new Intent(LoginActivity.this, MenuActivity.class);
        startActivity(gotoMenu);
    }
}
