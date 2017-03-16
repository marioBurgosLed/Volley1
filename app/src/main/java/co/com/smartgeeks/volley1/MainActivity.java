package co.com.smartgeeks.volley1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textview1 = (TextView)findViewById(R.id.textiew1);

        RequestQueue queue = Volley.newRequestQueue(this);
        String URL = "http://sigequip.esy.es/obtenerUsuarios.php";

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                textview1.setText("Resultado: "+response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                textview1.setText("No se pudo realizar la solicitud");

            }
        });

        queue.add(stringRequest);
    }
}
