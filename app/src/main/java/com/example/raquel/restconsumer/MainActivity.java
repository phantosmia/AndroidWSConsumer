package com.example.raquel.restconsumer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.raquel.restconsumer.modelo.Usuario;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AcessoRest ar = new AcessoRest();
        String chamadaWS;
        chamadaWS= "http://192.168.1.50:8080/FazendaWSTutorial/webresources/generic/Usuario/get/Raquel";
        String resultado = ar.chamadaGet(chamadaWS);
        Log.i("JSON",resultado);
        try {
            Gson g = new Gson();
            Usuario u = new Usuario();
            Type usuarioType = new TypeToken<Usuario>(){}.getType();

            u =  g.fromJson(resultado,usuarioType);
            JSONObject json = new JSONObject(resultado);
            TextView texto = (TextView)findViewById(R.id.texto);
            texto.setText(json.getString("login"));
            texto.setText(u.getLogin());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
