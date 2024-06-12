package com.example.proyectofinal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;


import android.os.Bundle;
import android.app.Activity;
import android.content.res.AssetManager;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DiccionarioActivity extends Activity {
	Map<String, String> palabras = new HashMap<String, String>();
	//Map<String,String> pedidos = new HashMap<String, String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_diccionario);
		TextView txt = (TextView) findViewById(R.id.textView5);
		AssetManager am = getAssets();
		InputStream is = null;
		try {
			is = am.open("palabras.txt");
			String texto = cargarArchivo(is);
			String pal[] = texto.split("\n");
			for (int i = 0; i < pal.length; i++) {
				String frase[] = pal[i].split(";");
				palabras.put(frase[0].toLowerCase(), frase[1]);
			}
			//txt.setText(palabras.size()+"-"+pal.length);
		} catch (IOException e) {
			Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
		}
	}
	
	
	private String cargarArchivo(InputStream is) throws IOException{
		ByteArrayOutputStream v = new ByteArrayOutputStream();// es un vector infinito
		byte[] bytes = new byte[2048];//aqui cargamos lo que va a leer del txt
		int large = 0;				 //tamaño de las lecturas 
										//podemos leer, entre 512,1024,2048...
		int c=0;
		while ((large=is.read(bytes))>0){//Se realiza hasta que termina de leer el texto
			v.write(bytes,0,large);
			c++;							
		}
		Toast.makeText(this, c+"", Toast.LENGTH_LONG).show();
		return new String(v.toByteArray(),"UTF-8");
	}
	
	public void limpiar(View vista){
		EditText edt = (EditText) findViewById(R.id.editText1);
		TextView txt0 = (TextView) findViewById(R.id.textView3);
		TextView txt = (TextView) findViewById(R.id.textView5);
		edt.setText("");
		txt0.setText("");
		txt.setText("");
	}
	
	public void traducir(View vista){
		EditText edt = (EditText) findViewById(R.id.editText1);
		TextView txt0 = (TextView) findViewById(R.id.textView3);
		TextView txt = (TextView) findViewById(R.id.textView5);
		String espaniol = edt.getText().toString();
		txt0.setText("Palabra -> "+espaniol);
		espaniol = espaniol.trim().toLowerCase();
		
		if (palabras.containsKey(espaniol)) {
			txt.setText(palabras.get(espaniol));
		} else {
			txt.setText("La palabra todavia no se encuentra en el diccionario :(");
		}
	}
	
	public void volver(View vista){
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
