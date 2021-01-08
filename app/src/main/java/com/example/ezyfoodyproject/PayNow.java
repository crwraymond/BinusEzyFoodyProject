package com.example.ezyfoodyproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

public class PayNow extends AppCompatActivity {
    public String AMQuantity = "0", JAPQuantity = "0", JMQuantity = "0", JALQuantity = "0";
    public String NGQuantity ="0", BQuantity="0", MAQuantity ="0", AGQuantity="0";
    public String LQuantity="0", KGQuantity="0", ORQuantity="0", RBQuantity="0";
    public String id;
    int total = 0;
    int kurang=0;
    public String ia="";
    DatabaseHelper myDB;
    Date d=new Date();
    Calendar calendar = Calendar.getInstance();
    String currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.getTime());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay_now);
        Intent intent = getIntent();
        myDB = new DatabaseHelper(this);
        AMQuantity = intent.getStringExtra("airMineral");
        JAPQuantity = intent.getStringExtra("jusApel");
        JMQuantity = intent.getStringExtra("jusMangga");
        JALQuantity = intent.getStringExtra("jusAlpukat");
        NGQuantity = intent.getStringExtra("nasiGoreng");
        BQuantity = intent.getStringExtra("batagor");
        MAQuantity = intent.getStringExtra("mieAyam");
        AGQuantity = intent.getStringExtra("ayamGoreng");
        LQuantity = intent.getStringExtra("lumpia");
        KGQuantity = intent.getStringExtra("kentangGoreng");
        ORQuantity = intent.getStringExtra("onionRing");
        RBQuantity = intent.getStringExtra("rotiBakar");
        id = intent.getStringExtra("id");
        ia = intent.getStringExtra("alamat");
        TextView airMinerals = (TextView) findViewById(R.id.AirMin);
        TextView jusApels = (TextView) findViewById(R.id.JusAp);
        TextView jusManggas = (TextView) findViewById(R.id.JusMg);
        TextView jusAlpukats = (TextView) findViewById(R.id.JusAl);
        TextView totals = (TextView) findViewById(R.id.textView);
        TextView nasiGoreng = (TextView) findViewById(R.id.NG);
        TextView batagor = (TextView) findViewById(R.id.B);
        TextView mieAyam = (TextView) findViewById(R.id.MA);
        TextView ayamGoreng = (TextView) findViewById(R.id.AG);
        TextView lumpia = (TextView) findViewById(R.id.L);
        TextView kentangGoreng = (TextView) findViewById(R.id.KG);
        TextView onionRing = (TextView) findViewById(R.id.OR);
        TextView rotiBakar = (TextView) findViewById(R.id.RB);
        if (AMQuantity != null&&!AMQuantity.equals("0")) {
            total = total + Integer.parseInt(AMQuantity)*2500;
            airMinerals.setText("Air Mineral\n" + intent.getStringExtra("airMineral") + "x Rp. 2.500");
            airMinerals.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Air Mineral", Integer.parseInt(AMQuantity), currentDate, Integer.parseInt(AMQuantity)*2500, ia);
            Cursor resAM= myDB.getAM(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockAM(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(AMQuantity));
        }
        if (JAPQuantity != null&&!JAPQuantity.equals("0")) {
            total = total + Integer.parseInt(JAPQuantity)*15000;
            jusApels.setText("Jus Apel\n" + intent.getStringExtra("jusApel") + "x Rp. 15.000");
            jusApels.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Jus Apel", Integer.parseInt(JAPQuantity), currentDate, Integer.parseInt(JAPQuantity)*15000, ia);
            Cursor resAM= myDB.getJA(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockJA(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(JAPQuantity));
        }
        if (JMQuantity != null&&!JMQuantity.equals("0")) {
            total = total + Integer.parseInt(JMQuantity)*17000;
            jusManggas.setText("Jus Mangga\n" + intent.getStringExtra("jusMangga") + "x Rp. 17.000");
            jusManggas.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Jus Mangga", Integer.parseInt(JMQuantity), currentDate,Integer.parseInt(JMQuantity)*17000, ia);
            Cursor resAM= myDB.getJM(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockJM(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(JMQuantity));
        }
        if (JALQuantity != null&&!JALQuantity.equals("0")) {
            total = total + Integer.parseInt(JALQuantity)*20000;
            jusAlpukats.setText("Jus Alpukat\n" + intent.getStringExtra("jusAlpukat") + "x Rp. 20.000");
            jusAlpukats.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Jus Alpukat", Integer.parseInt(JALQuantity), currentDate,Integer.parseInt(JALQuantity)*20000, ia);
            Cursor resAM= myDB.getJAL(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockJAL(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(JALQuantity));
        }
        if (NGQuantity != null&&!NGQuantity.equals("0")) {
            total = total + Integer.parseInt(NGQuantity)*25000;
            nasiGoreng.setText("Nasi Goreng\n" + intent.getStringExtra("nasiGoreng") + "x Rp. 25.000");
            nasiGoreng.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Nasi Goreng", Integer.parseInt(NGQuantity), currentDate,Integer.parseInt(NGQuantity)*25000, ia);
            Cursor resAM= myDB.getNG(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockNG(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(NGQuantity));
        }
        if (BQuantity != null&&!BQuantity.equals("0")) {
            total = total + Integer.parseInt(BQuantity)*15000;
            batagor.setText("Batagor\n" + intent.getStringExtra("batagor") + "x Rp. 15.000");
            batagor.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Batagor", Integer.parseInt(BQuantity), currentDate,Integer.parseInt(BQuantity)*15000, ia);
            Cursor resAM= myDB.getB(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockB(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(BQuantity));
        }
        if (MAQuantity != null&&!MAQuantity.equals("0")) {
            total = total + Integer.parseInt(MAQuantity)*20000;
            mieAyam.setText("Mie Ayam\n" + intent.getStringExtra("mieAyam") + "x Rp. 20.000");
            mieAyam.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Mie Ayam", Integer.parseInt(MAQuantity), currentDate, Integer.parseInt(MAQuantity)*20000, ia);
            Cursor resAM= myDB.getMA(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockMA(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(MAQuantity));
        }
        if (AGQuantity != null&&!AGQuantity.equals("0")) {
            total = total + Integer.parseInt(AGQuantity)*17000;
            ayamGoreng.setText("Ayam Goreng\n" + intent.getStringExtra("ayamGoreng") + "x Rp. 17.000");
            ayamGoreng.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Ayam Goreng", Integer.parseInt(AGQuantity), currentDate,Integer.parseInt(AGQuantity)*17000, ia);
            Cursor resAM= myDB.getAG(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockAG(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(AGQuantity));
        }
        if (LQuantity != null&&!LQuantity.equals("0")) {
            total = total + Integer.parseInt(LQuantity)*2500;
            lumpia.setText("Lumpia\n" + intent.getStringExtra("lumpia") + "x Rp. 2.500");
            lumpia.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Lumpia", Integer.parseInt(LQuantity), currentDate,Integer.parseInt(LQuantity)*2500, ia);
            Cursor resAM= myDB.getL(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockL(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(LQuantity));
        }
        if (KGQuantity != null&&!KGQuantity.equals("0")) {
            total = total + Integer.parseInt(KGQuantity)*15000;
            kentangGoreng.setText("Kentang Goreng\n" + intent.getStringExtra("kentangGoreng") + "x Rp. 15.000");
            kentangGoreng.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Kentang Goreng", Integer.parseInt(KGQuantity), currentDate,Integer.parseInt(KGQuantity)*15000, ia);
            Cursor resAM= myDB.getKG(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockKG(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(KGQuantity));
        }
        if (ORQuantity != null&&!ORQuantity.equals("0")) {
            total = total + Integer.parseInt(ORQuantity)*20000;
            onionRing.setText("Onion Ring\n" + intent.getStringExtra("onionRing") + "x Rp. 20.000");
            onionRing.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Onion Ring", Integer.parseInt(ORQuantity), currentDate,Integer.parseInt(ORQuantity)*20000, ia);
            Cursor resAM= myDB.getOR(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockOR(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(ORQuantity));
        }
        if (RBQuantity != null&&!RBQuantity.equals("0")) {
            total = total + Integer.parseInt(RBQuantity)*10000;
            rotiBakar.setText("Roti Bakar\n" + intent.getStringExtra("rotiBakar") + "x Rp. 10.000");
            rotiBakar.setVisibility(View.VISIBLE);
            boolean insert1=myDB.insertHistory("Roti Bakar", Integer.parseInt(RBQuantity), currentDate,Integer.parseInt(RBQuantity)*10000, ia);
            Cursor resAM= myDB.getRB(Integer.parseInt(id));
            resAM.moveToNext();
            boolean stockAM=myDB.stockRB(id, Integer.parseInt(resAM.getString(0))-Integer.parseInt(RBQuantity));
        }
        totals.setText("Rp. " + total);

    }

    public void onClickMainMenu(View view)
    {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("id", id);
        intent.putExtra("alamat", ia);
        startActivity(intent);
    }





}