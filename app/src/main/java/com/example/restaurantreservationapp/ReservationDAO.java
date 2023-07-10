package com.example.restaurantreservationapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ReservationDAO {
        private Database.Banco banco;
        public ReservationDAO(Database.Banco b){
            this.banco = b;
        }
        public int save(Reservation reservation){
            int id = reservation.getId();
            SQLiteDatabase db = banco.getWritableDatabase();
            try{
                ContentValues values = new ContentValues();
                values.put("id_user",reservation.getUserID());
                values.put("date",reservation.getDate());
                values.put("hour",reservation.getHour());
                if(id==0){
                    //new reservation
                    id = (int) db.insert("reservation","",values);
                }
                else{
                    //update reservation
                    String _id = String.valueOf(reservation.getId());
                    String[] whereArgs = new String[]{_id};
                    id = db.update("reservation",values,"id=?",whereArgs);
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
        private List<Reservation> paraLista(Cursor c){
            List<Reservation> reservations = new ArrayList<>();
            if(c.moveToFirst()){
                do{
                    Reservation a = new Reservation();
                    a.setId(c.getInt(c.getColumnIndex("id")));
                    a.setDate(c.getString(c.getColumnIndex("date")));
                    a.setHour(c.getString(c.getColumnIndex("hour")));
                    a.setUserID(Integer.parseInt((c.getString(c.getColumnIndex("id_user")))));
                    reservations.add(a);
                }while (c.moveToNext());
            }
            return reservations;
        }
        public List<Reservation> buscarTodos(){
            SQLiteDatabase db = banco.getReadableDatabase();
            Cursor c = null;
            try{
                //c = db.query("reservation",null,null,null,null,null,null);
                c = db.rawQuery("SELECT * FROM aluno",null);
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

