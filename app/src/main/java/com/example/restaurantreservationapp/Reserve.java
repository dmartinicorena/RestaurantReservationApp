package com.example.restaurantreservationapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;

import java.util.ArrayList;

public class Reserve extends AppCompatActivity {

    DatePicker datePicker;
    String date;
    EditText hour;
    Button btnReserve;
    Database.Banco banco;
    Reservation reservation;
    ImageButton btnShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservate);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        ArrayList<User> savedUser = (ArrayList<User>) bundle.getSerializable("arr" );
        User user = savedUser.get(0);
        date = ""+datePicker.getDayOfMonth()+"/"+datePicker.getMonth()+"/"+datePicker.getYear();
        hour = findViewById(R.id.hourReservation);
        banco = new Database.Banco(getApplicationContext());
        btnShare = findViewById(R.id.wppShare);
        btnShare.setEnabled(false);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reservation = new Reservation(user.getId(),date,hour.getText().toString());
                ReservationDAO reservationDAO = new ReservationDAO(banco);
                reservation.setId(reservationDAO.save(reservation));

                btnReserve.setEnabled(false);
                btnShare.setEnabled(true);
            }
        });
        String API = "https://wa.me/?text=A%20reserva%20é%20no%20"+date+"%20as%20"+reservation.getHour();

        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse(API);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        finish();
        return super.onOptionsItemSelected(item);
    }
}
