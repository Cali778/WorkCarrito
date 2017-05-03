package com.example.usuario.proyectcarrito.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.usuario.proyectcarrito.bean.Product;
import com.example.usuario.proyectcarrito.util.Commons;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Usuario on 02/05/2017.
 */

public class ProductDAO extends SQLiteOpenHelper {


    private static final  int VERSION = 1;
    public ProductDAO(Context context){
        super(context, Commons.DATABASE, null, VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String ddl = "CREATE TABLE Product(" +
                " ProductId INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL," +
                " Descripcion TEXT," +
                " Cantidad TEXT," +
                " Precio REAL," +
                ");";
        db.execSQL(ddl);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String ddl ="DROP TABLE IF EXISTS Product";
        db.execSQL(ddl);
        this.onCreate(db);
    }


    public void saveProduct(Product product){
        ContentValues values=new ContentValues();
        values.put("Descripcion",product.getDescripcion());
        values.put("Cantidad",product.getCantidad());
        values.put("Precio",product.getPrecio());
        getWritableDatabase().insert("Product",null,values);


    }

    public List<Product> findProductAll(){
        List<Product> productList = new ArrayList<Product>();
        String columns[]={"ProductId","Descripcion","Cantidad","Precio"};
        String where = null ;
        Cursor cursor = getReadableDatabase().query("Product",columns,where,null,null,null,null);
        Product product = null;
        while (cursor.moveToNext()){
            product = new Product();
            product.setProductId(cursor.getLong(0));
            product.setDescripcion(cursor.getString(1));
            product.setCantidad(cursor.getString(2));
            product.setPrecio(cursor.getDouble(3));

            productList.add(product);
        }

        return productList;


    }



}
