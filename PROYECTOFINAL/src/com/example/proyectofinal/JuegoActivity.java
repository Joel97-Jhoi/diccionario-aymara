package com.example.proyectofinal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class JuegoActivity extends Activity {
	
	int personajes[] = {
			R.drawable.uno,
			R.drawable.dos,
			R.drawable.tres,
			R.drawable.cuatro,
			R.drawable.cinco,
			R.drawable.seis};
	
	Integer iperson[] = {0,0,1,1,2,2,3,3,4,4,5,5};
	
	int cont;
	int control=-1;
	Bitmap bmp;
	int val;
	boolean b=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_juego);
		
		iniciar();	
		
	}
	
	public void iniciar() {
		
		cont=0;
		List<Integer> list =Arrays.asList(iperson);
	    Collections.shuffle(list);
	    list.toArray(iperson);

		

		ImageView img1=(ImageView)findViewById(R.id.imageView2);
		ImageView img2=(ImageView)findViewById(R.id.imageView3);
		ImageView img3=(ImageView)findViewById(R.id.imageView4);
		ImageView img4=(ImageView)findViewById(R.id.imageView5);
		ImageView img5=(ImageView)findViewById(R.id.imageView6);
		ImageView img6=(ImageView)findViewById(R.id.imageView7);
		ImageView img7=(ImageView)findViewById(R.id.imageView8);
		ImageView img8=(ImageView)findViewById(R.id.imageView9);
		ImageView img9=(ImageView)findViewById(R.id.imageView10);
		ImageView img10=(ImageView)findViewById(R.id.imageView11);
		ImageView img11=(ImageView)findViewById(R.id.imageView12);
		ImageView img12=(ImageView)findViewById(R.id.imageView13);
		
		img1.setImageResource(R.drawable.interroga);
		img2.setImageResource(R.drawable.interroga);
		img3.setImageResource(R.drawable.interroga);
		img4.setImageResource(R.drawable.interroga);
		img5.setImageResource(R.drawable.interroga);
		img6.setImageResource(R.drawable.interroga);
		img7.setImageResource(R.drawable.interroga);
		img8.setImageResource(R.drawable.interroga);
		img9.setImageResource(R.drawable.interroga);
		img10.setImageResource(R.drawable.interroga);
		img11.setImageResource(R.drawable.interroga);
		img12.setImageResource(R.drawable.interroga);
		
		//habilitamos los botones
		
		img1.setEnabled(true);
		img2.setEnabled(true);
		img3.setEnabled(true);
		img4.setEnabled(true);
		img5.setEnabled(true);
		img6.setEnabled(true);
		img7.setEnabled(true);
		img8.setEnabled(true);
		img9.setEnabled(true);
		img10.setEnabled(true);
		img11.setEnabled(true);
		img12.setEnabled(true);
		
		
	}

	public void vuelta1(View vista) {
		
		if (b) {
			val=R.id.imageView2;
		}
		ImageView img1=(ImageView)findViewById(R.id.imageView2);
		controlador(iperson[0],img1);	
	}
	public void vuelta2(View vista) {
		if (b) {
			val=R.id.imageView3;
		}
		ImageView img2=(ImageView)findViewById(R.id.imageView3);
		controlador(iperson[1],img2);
	}
	public void vuelta3(View vista) {
		if (b) {
			val=R.id.imageView4;
		}
		ImageView img3=(ImageView)findViewById(R.id.imageView4);
		controlador(iperson[2],img3);
	}
	public void vuelta4(View vista) {
		if (b) {
			val=R.id.imageView5;
		}
		ImageView img4=(ImageView)findViewById(R.id.imageView5);
		controlador(iperson[3],img4);
	}
	public void vuelta5(View vista) {
		if (b) {
			val=R.id.imageView6;
		}
		ImageView img5=(ImageView)findViewById(R.id.imageView6);
		controlador(iperson[4],img5);
	}
	public void vuelta6(View vista) {
		if (b) {
			val=R.id.imageView7;
		}
		ImageView img6=(ImageView)findViewById(R.id.imageView7);
		controlador(iperson[5],img6);
	}
	public void vuelta7(View vista) {
		if (b) {
			val=R.id.imageView8;
		}
		ImageView img7=(ImageView)findViewById(R.id.imageView8);
		controlador(iperson[6],img7);
	}
	public void vuelta8(View vista) {
		if (b) {
			val=R.id.imageView9;
		}
		ImageView img8=(ImageView)findViewById(R.id.imageView9);
		controlador(iperson[7],img8);
	}
	public void vuelta9(View vista) {
		if (b) {
			val=R.id.imageView10;
		}
		ImageView img9=(ImageView)findViewById(R.id.imageView10);
		controlador(iperson[8],img9);
	}
	public void vuelta10(View vista) {
		if (b) {
			val=R.id.imageView11;
		}
		ImageView img10=(ImageView)findViewById(R.id.imageView11);
		controlador(iperson[9],img10);
	}
	public void vuelta11(View vista) {
		if (b) {
			val=R.id.imageView12;
		}
		ImageView img11=(ImageView)findViewById(R.id.imageView12);
		controlador(iperson[10],img11);
	}
	public void vuelta12(View vista) {
		if (b) {
			val=R.id.imageView13;
		}
		ImageView img12=(ImageView)findViewById(R.id.imageView13);
		controlador(iperson[11],img12);
	}

	
	private void controlador(int i, final ImageView img) {
		
		final ImageView p=(ImageView)findViewById(val);
		
		bmp=null;
		switch (i) {
		case 0: bmp=BitmapFactory.decodeResource(getResources(), R.drawable.uno);break;
		case 1: bmp=BitmapFactory.decodeResource(getResources(), R.drawable.dos);break;
		case 2: bmp=BitmapFactory.decodeResource(getResources(), R.drawable.tres);break;
		case 3: bmp=BitmapFactory.decodeResource(getResources(), R.drawable.cuatro);break;
		case 4: bmp=BitmapFactory.decodeResource(getResources(), R.drawable.cinco);break;
		case 5: bmp=BitmapFactory.decodeResource(getResources(), R.drawable.seis);break;
		}

		if (control==-1) {//si es que han marcado por primera vez
			control=i;
			img.setImageBitmap(bmp);
			img.setEnabled(false);
			b=false;
			
		}else {
			if (control==i) {//si es que han marcado por segunda vez y preguntamos si son iguales
				
				img.setImageBitmap(bmp);
				img.setEnabled(false);
				control=-1;
				b=true;
				Toast.makeText(this, "Todo posi XD", 0).show();
				cont++;

			}else {//si no son iguales reiniciamos
				
				b=true;
				control=-1;
				
				
				new CountDownTimer(2000,1000) {
					
					@Override
					public void onTick(long arg0) {
						img.setImageBitmap(bmp);
					}
					
					@Override
					public void onFinish() {
						p.setImageResource(R.drawable.interroga);
						img.setImageResource(R.drawable.interroga);
						p.setEnabled(true);
						img.setEnabled(true);
					}
					
				}.start();
			
				Toast.makeText(this, "No va a dar botas :(", 0).show();
				
				
			}
		}
		
		if (cont==6) {
			Toast.makeText(this, "GANASTE!! SIGUE ASI :)", 0).show();
			new CountDownTimer(3000,1000) {
				
				@Override
				public void onTick(long arg0) {

					
				}
				
				@Override
				public void onFinish() {

					
					iniciar();
				}
			}.start();
		
		}
	}
	
	public void fin(View vista){
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
