package com.colivine.jsrkfadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class AddMemberActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    Button button;
    public  static final String BASE_URL="https://jsrkf.com/new_update/dbconfig.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_member);
        et1 = (EditText) findViewById(R.id.edt_username);
        et2 = (EditText) findViewById(R.id.edt_email);
        et3 = (EditText) findViewById(R.id.edt_mobile);
        et4 = (EditText) findViewById(R.id.edt_password);
        button = (Button) findViewById(R.id.btn_submit);


        //here's starting point of volley data post method

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String username = et1.getText().toString().trim();
                final String email = et2.getText().toString().trim();
                final String mobile = et3.getText().toString().trim();
                final String password = et4.getText().toString().trim();

                StringRequest stringRequest=new StringRequest(Request.Method.POST, BASE_URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(AddMemberActivity.this,response.toString(),Toast.LENGTH_LONG);

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(AddMemberActivity.this,error.toString(),Toast.LENGTH_LONG);

                    }
                }){
                    @Override
                    protected Map<String, String> getParams()  {
                        Map<String,String>parms=new HashMap<String, String>();
                        parms.put("username",username);
                        parms.put("email",email);
                        parms.put("mobile",mobile);
                        parms.put("password",password);
                        return parms;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(stringRequest);
            }

            ;
        });
    }
}