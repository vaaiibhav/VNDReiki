package me.vaaiibhav.www.vndreiki;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import me.vaaiibhav.www.vndreiki.modal.ConstantClass;

public class MenuActivity extends AppCompatActivity {
    TextView tvUName;
    SharedPreferences sp;
    ConstantClass cs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cs = new ConstantClass();
        sp = getSharedPreferences(cs.PREFNAME,0);
        sp.getString(cs.PREFUSERNAME,)

    }
}
