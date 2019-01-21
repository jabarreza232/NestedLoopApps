package com.evolutions.jabar.teslogika;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/*

Created By : Jabar Syahrial Reza
Tgl 10 Januari 2019

 */
public class BentukRumus extends Fragment {
    public BentukRumus() {
        // Required empty public constructor
    }
    @BindView(R.id.txt_persegi)
    TextView persegi;
    @BindView(R.id.txt_segitiga)
    TextView segitiga;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bentuk_rumus, container, false);
        ButterKnife.bind(this, view);
//Pemanggilan kedua fungsi perulangan bersarang persegi dan segitiga
        LogicNestedLoopPersegi();
        LogicNestedLoopSegitiga();
        return view;
    }
    //Fungsi Untuk menampilkan perulangan bersarang persegi
    private void LogicNestedLoopPersegi() {
        String hasil = "";
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {
                    hasil += "  "+"*"+"  ";
                    persegi.setText(hasil);
                }
                hasil += "\n";
                persegi.setText(hasil);
            }
        }
    //Fungsi Untuk menampilkan perulangan bersarang segitiga
        private void LogicNestedLoopSegitiga(){
        String hasil="";
            for (int i = 1; i <=10 ; i++) {
                hasil +="\n";
                segitiga.setText(hasil);
                for (int j = 1; j<=i; j++){
                    hasil+=" * ";
                    segitiga.setText(hasil);

                }

            }
        }
    }

