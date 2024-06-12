package com.example.proyectofinal;



import java.io.Serializable;
import java.util.HashMap;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	int imgenes[]={R.drawable.aimara,R.drawable.historia,R.drawable.vocales,R.drawable.juego};
	String contenido[] = {"DICCIONARIO","HISTORIA","VOCALES Y CONSONANTES","JUEGO DE MEMORIA"};
	int pos=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void anterior(View vista){
		TextView txt2 = (TextView) findViewById(R.id.textView4);
		ImageView img = (ImageView) findViewById(R.id.imageView2);
		
		this.pos--;
		if(pos>=0){
			txt2.setText(contenido[pos]);
			img.setImageResource(imgenes[pos]);
		}else{
			this.pos=contenido.length-1;
			txt2.setText(contenido[pos]);
			img.setImageResource(imgenes[pos]);
		}
	}
	
	public void siguiente(View vista){
		TextView txt2 = (TextView) findViewById(R.id.textView4);
		ImageView img = (ImageView) findViewById(R.id.imageView2);
		
		this.pos++;
		if(pos<contenido.length){
			txt2.setText(contenido[pos]);
			img.setImageResource(imgenes[pos]);
		}else{
			this.pos=0;
			txt2.setText(contenido[pos]);
			img.setImageResource(imgenes[pos]);
		}
	}
	
	public void ingresar(View vista){
		if (this.pos==0) {
			Intent ventana = new Intent(this,DiccionarioActivity.class);
			startActivity(ventana);
		}else if (this.pos==1){
			Intent ventana = new Intent(this,HistoriaActivity.class);
			startActivity(ventana);
		}else if (this.pos==2) {
			Intent ventana = new Intent(this,VocalesActivity.class);
			startActivity(ventana);
		}else if (this.pos==3) {
			Intent ventana = new Intent(this,JuegoActivity.class);
			startActivity(ventana);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
