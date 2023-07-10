package com.example.restaurantreservationapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {
        private Database.Banco banco;
        public UserDAO(Database.Banco b){
            this.banco = b;
        }
        public int save(User user){
            int id = user.getId();
            SQLiteDatabase db = banco.getWritableDatabase();
            try{
                ContentValues values = new ContentValues();
                values.put("name",user.getName());
                values.put("login",user.getLogin());
                values.put("pass",user.getPass());
                if(id==0){
                    //new insert
                    id = (int) db.insert("user","",values);
                }
                else{
                    //update
                    String _id = String.valueOf(user.getId());
                    String[] whereArgs = new String[]{_id};
                    id = db.update("user",values,"id=?",whereArgs);
                }
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                //db.close();
            }
            return id;
        }
        @SuppressLint("Range")
        private List<User> paraLista(Cursor c){
            List<User> user = new ArrayList<>();
            if(c.moveToFirst()){
                do{
                    User a = new User();
                    a.setId(c.getInt(c.getColumnIndex("id")));
                    a.setName(c.getString(c.getColumnIndex("name")));
                    a.setLogin(c.getString(c.getColumnIndex("login")));
                    a.setPass(c.getString(c.getColumnIndex("pass")));

                    user.add(a);
                }while (c.moveToNext());
            }
            return user;
        }
        public List<User> selectAll(){
            SQLiteDatabase db = banco.getReadableDatabase();
            Cursor c = null;
            try{
                //c = db.query("aluno",null,null,null,null,null,null);
                c = db.rawQuery("SELECT * FROM user",null);
            }
            catch (Exception e){
                e.printStackTrace();
            }
            finally {
                //db.close();
            }
            if(c!= null){
                return paraLista(c);
            }
            return null;
        }

    public List<User> selectUser(String login){
        SQLiteDatabase db = banco.getReadableDatabase();
        Cursor c = null;
        try{
            //c = db.query("user",null,null,null,null,null,null);
            c = db.rawQuery("SELECT * FROM user WHERE login = ?",new String[] {login});
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            //db.close();
        }
        if(c!= null){
            return paraLista(c);
        }
        return null;
    }
}

