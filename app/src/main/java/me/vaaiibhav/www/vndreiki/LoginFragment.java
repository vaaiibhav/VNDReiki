package me.vaaiibhav.www.vndreiki;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import me.vaaiibhav.www.vndreiki.modal.ConstantClass;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {
EditText etName, etPass;
    String uName, uPass;
    String Plocation,Pname, Pusername;
ConstantClass cs;
    SharedPreferences sp;
    SharedPreferences.Editor spedit;
    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);
        ViewInitiater(view);
        return view;
    }

    private void ViewInitiater(View view) {
        cs = new ConstantClass();
        sp =getActivity().getSharedPreferences(cs.PREFNAME,0);
        spedit = sp.edit();

        etName = (EditText) view.findViewById(R.id.et_username);
        etPass = (EditText) view.findViewById(R.id.et_password);
        uName = etName.getText().toString();
        uPass =etPass.getText().toString();
        loginator(uName,uPass);


    }

    private void loginator(final String uName, final String uPass) {
        final RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest sr = new StringRequest(cs.loginUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(cs.TAG,response);
                if(response.equals("success")){
                    getLocation();
                    getName();
                    gotoMain();

                }
                rq.stop();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(cs.TAG,error.toString());
                rq.stop();
            }
        }){@Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> map = new HashMap<>();
            map.put(cs.USERNAME,uName);
            map.put(cs.USERPASS,uPass);
            return  map;

        }};rq.add(sr);
    }

    private void getName() {
        final RequestQueue rq = Volley.newRequestQueue(getActivity());
        StringRequest sr = new StringRequest(cs.userUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(cs.TAG,response);
                if(!response.isEmpty()){
                   Pname = response;

                }
                rq.stop();
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(cs.TAG,error.toString());
                rq.stop();
            }
        }){@Override
        protected Map<String, String> getParams() throws AuthFailureError {
            Map<String,String> map = new HashMap<>();
            map.put(cs.USERNAME,uName);
            return  map;

        }};rq.add(sr);
    }

    private void getLocation(){
           final RequestQueue rq = Volley.newRequestQueue(getActivity());
    StringRequest sr = new StringRequest(cs.locationUrl, new Response.Listener<String>() {
        @Override
        public void onResponse(String response) {
            Log.d(cs.TAG,response);
            if(!response.isEmpty()){
                Plocation = response;

            }
            rq.stop();
        }

    }, new Response.ErrorListener() {
        @Override
        public void onErrorResponse(VolleyError error) {
            Log.d(cs.TAG,error.toString());
            rq.stop();
        }
    }){@Override
    protected Map<String, String> getParams() throws AuthFailureError {
        Map<String,String> map = new HashMap<>();
        map.put(cs.USERNAME,uName);
        return  map;

    }};rq.add(sr); }


    private void gotoMain() {
        Pusername = uName;
        spedit.putString(cs.PREFUSERNAME,Pusername);
        spedit.putString(cs.PREFPNAME,Pname);
        spedit.putString(cs.PREFPLOCATION,Plocation);
        Intent gotoMenu = new Intent(getActivity(),MenuActivity.class);
        startActivity(gotoMenu);
    }



}
