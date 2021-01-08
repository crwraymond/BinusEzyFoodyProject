package com.example.ezyfoodyproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="EzyFoody.db";
    public static final String TABLE_NAME="restaurant_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "stock_airmineral";
    public static final String COL_3 = "stock_jusapel";
    public static final String COL_4 = "stock_jusalpukat";
    public static final String COL_5 = "stock_jusmangga";
    public static final String COL_6 = "stock_lumpia";
    public static final String COL_7 = "stock_onionring";
    public static final String COL_8 = "stock_rotibakar";
    public static final String COL_9 = "stock_kentanggoreng";
    public static final String COL_10= "stock_nasigoreng";
    public static final String COL_11= "stock_batagor";
    public static final String COL_12= "stock_mieayam";
    public static final String COL_13= "stock_ayamgoreng";
    public static final String COL_TOPUP= "Saldo";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE restaurant_table (ID INTEGER PRIMARY KEY AUTOINCREMENT, stock_airmineral INTEGER, stock_jusapel INTEGER, stock_jusalpukat INTEGER, stock_jusmangga INTEGER, stock_lumpia INTEGER, stock_onionring INTEGER, stock_rotibakar INTEGER, stock_kentanggoreng INTEGER, stock_nasigoreng INTEGER, stock_batagor INTEGER, stock_mieayam INTEGER, stock_ayamgoreng INTEGER)");
        db.execSQL("CREATE TABLE history (Nama VARCHAR, Price INTEGER, Quantity INTEGER, Date DATE, Address VARCHAR)");
        db.execSQL("CREATE TABLE topup (ID VARCHAR, Saldo INTEGER)");
        ContentValues contentValues =  new ContentValues();
        contentValues.put("ID", "1");
        contentValues.put("Saldo", 100000);
        db.insert("topup", null, contentValues);
        ContentValues contentValuesR =  new ContentValues();
        contentValuesR.put("stock_airmineral", 10);
        contentValuesR.put("stock_jusapel", 10);
        contentValuesR.put("stock_jusalpukat", 10);
        contentValuesR.put("stock_jusmangga", 10);
        contentValuesR.put("stock_lumpia", 10);
        contentValuesR.put("stock_onionring", 10);
        contentValuesR.put("stock_rotibakar", 10);
        contentValuesR.put("stock_kentanggoreng", 10);
        contentValuesR.put("stock_batagor", 10);
        contentValuesR.put("stock_mieayam", 10);
        contentValuesR.put("stock_ayamgoreng", 10);
        contentValuesR.put("stock_nasigoreng", 10);
        db.insert("restaurant_table", null, contentValuesR);
        ContentValues contentValuesR1 =  new ContentValues();
        contentValuesR1.put("stock_airmineral", 15);
        contentValuesR1.put("stock_jusapel", 15);
        contentValuesR1.put("stock_jusalpukat", 15);
        contentValuesR1.put("stock_jusmangga", 15);
        contentValuesR1.put("stock_lumpia", 15);
        contentValuesR1.put("stock_onionring", 15);
        contentValuesR1.put("stock_rotibakar", 15);
        contentValuesR1.put("stock_kentanggoreng", 15);
        contentValuesR1.put("stock_batagor", 15);
        contentValuesR1.put("stock_mieayam", 15);
        contentValuesR1.put("stock_ayamgoreng", 15);
        contentValuesR1.put("stock_nasigoreng", 15);
        db.insert("restaurant_table", null, contentValuesR1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS history");
        db.execSQL("DROP TABLE IF EXISTS topup");
        onCreate(db);
    }

    public boolean insertDataTopUp(int saldo)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("Saldo", saldo);
        long result = db.insert("topup", null, contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public boolean insertHistory(String Nama, int qty, String date, int price, String alamat)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues =  new ContentValues();
        contentValues.put("Nama", Nama);
        contentValues.put("Quantity", qty);
        contentValues.put("Date", date);
        contentValues.put("Price", price);
        contentValues.put("Address", alamat);
        long result = db.insert("history", null, contentValues);
        if(result==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public Cursor getHistoryData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM history", null);
        return res;
    }


    public Cursor getDataTopUp()
    {
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT Saldo FROM topup", null);
        return res;
    }

    public boolean tfsaldo(String id, int Saldo)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("Saldo", Saldo);
        db.update("topup", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    //UPDATE STOCK
    //UPDATE STOCK DRINK
    public boolean stockAM(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_airmineral", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockJA(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_jusapel", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockJM(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_jusmangga", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockJAL(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_jusalpukat", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }

    //UPDATE STOCK FOOD
    public boolean stockNG(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_nasigoreng", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockAG(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_ayamgoreng", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockMA(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_mieayam", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockB(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_batagor", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }

    //UPDATE STOCK SNACK
    public boolean stockL(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_lumpia", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockKG(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_kentanggoreng", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockOR(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_onionring", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }
    public boolean stockRB(String id, int s)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put("ID", id);
        contentValues.put("stock_rotibakar", s);
        db.update("restaurant_table", contentValues, "ID = ?", new String[] {id});
        return true;
    }

    //AMBIL STOCK
    //AMBIL DATA STOCK DRINK
    public Cursor getAM(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_airmineral FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getJA(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_jusapel FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getJM(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_jusmangga FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getJAL(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_jusalpukat FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    //AMBIL DATA STOCK SNACK
    public Cursor getL(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_lumpia FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getKG(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_kentanggoreng FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getOR(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_onionring FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getRB(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_rotibakar FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    //AMBIL STOCK FOOD
    public Cursor getNG(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_nasigoreng FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getAG(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_ayamgoreng FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getMA(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_mieayam FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }

    public Cursor getB(int id)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT stock_batagor FROM restaurant_table WHERE ID = "+id, null);
        return res;
    }
}
