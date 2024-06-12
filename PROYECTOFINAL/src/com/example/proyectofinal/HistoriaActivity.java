package com.example.proyectofinal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class HistoriaActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_historia);
		TextView txt = (TextView) findViewById(R.id.textView2);
		AssetManager am = getAssets();
		InputStream is = null;
		try {/*lallaa*/
			is = am.open("historia.txt");
			String texto = cargarArchivo(is);
			txt.setText(texto);
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
