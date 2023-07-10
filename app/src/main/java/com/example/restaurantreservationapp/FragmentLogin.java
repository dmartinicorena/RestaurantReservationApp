package com.example.restaurantreservationapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentLogin#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentLogin extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";



    public FragmentLogin() {
        // Required empty public constructor
    }
    EditText login;
    EditText pass;
    Button btnLogin;
    Database.Banco banco;
    ArrayList<User> saveReg;
    public static FragmentLogin newInstance(String param1, String param2) {
        FragmentLogin fragment = new FragmentLogin();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    private Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext=context;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Activity activity= (Activity) mContext;
        login.findViewById(R.id.loginInput);
        pass.findViewById(R.id.passInput);
        btnLogin.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDAO alunodao = new UserDAO(banco);
                List<User> users = alunodao.selectAll();
                for (int i = 0; i < users.size(); i++) {
                    if (users.get(i).getLogin().equals(login.toString())){
                        if (users.get(i).getPass().equals(pass.toString())){
                            saveReg.add(users.get(i));

                            Bundle save = new Bundle();
                            save.putSerializable("arr",saveReg);
                            Intent sender = new Intent(getContext(), Reserve.class);
                            sender.putExtras(save);
                            startActivity(sender);
                        }
                        else {

                        }
                    }
                    else {

                    }
                }
            }
        });

    }


}