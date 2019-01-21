package com.evolutions.jabar.teslogika;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.shashank.sony.fancytoastlib.FancyToast;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.view.View.GONE;

/*

Created By : Jabar Syahrial Reza
Tgl 10 Januari 2019

 */
public class Bilangan extends Fragment implements AdapterView.OnItemSelectedListener,View.OnClickListener{
@BindView(R.id.edt_nilai_awal)
    EditText edtNilaiAwal;
@BindView(R.id.edt_nilai_akhir)
EditText edtNilaiAkhir;
@BindView(R.id.label_nilai_awal)
TextView labelNilaiAwal;
@BindView(R.id.label_nilai_akhir)
TextView labelNilaiAkhir;
@BindView(R.id.edt_bil_genap)
EditText edtBilGenap;
@BindView(R.id.edt_bil_ganjil)
EditText edtBilGanjil;
@BindView(R.id.label_bil_prima)
TextView labelBilPrima;
@BindView(R.id.label_bil_genap)
TextView labelBilGenap;
@BindView(R.id.label_bil_ganjil)
TextView labelBilGanjil;
@BindView(R.id.hasil_bil_prima)
TextView hasilBilPrima;
@BindView(R.id.hasil_bil_ganjil)
TextView hasilBilGanjil;
@BindView(R.id.hasil_bil_genap)
TextView hasilBilGenap;
@BindView(R.id.spin_item)
Spinner spin_item;
@BindView(R.id.btn_submit)
Button submit;

    public Bilangan() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

      View view= inflater.inflate(R.layout.fragment_bilangan, container, false);

      ButterKnife.bind(this,view);
         //Mengimplementasikan spinner
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(getContext(),R.array.spin_bil,android.R.layout.simple_list_item_1);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin_item.setAdapter(adapter);
        spin_item.setOnItemSelectedListener(this);
        submit.setOnClickListener(this);
        return view;

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
        //Pemanggilan Fungsi seluruh item
        show_item_1();
        show_item_2();
        show_item_3();
        show_item_4();
    }
    //Fungsi untuk menampilkan dan menghilangkan item bilangan prima
    void show_item_1() {
        Object a = spin_item.getItemAtPosition(1);
        if (spin_item.getSelectedItem().equals(a)) {
            edtNilaiAwal.setVisibility(View.VISIBLE);
            edtNilaiAkhir.setVisibility(View.VISIBLE);
            labelNilaiAwal.setVisibility(View.VISIBLE);
            labelNilaiAkhir.setVisibility(View.VISIBLE);
            labelBilPrima.setVisibility(View.VISIBLE);
            hasilBilPrima.setVisibility(View.VISIBLE);
        } else {
            edtNilaiAwal.setVisibility(GONE);
            edtNilaiAkhir.setVisibility(GONE);
            labelNilaiAwal.setVisibility(GONE);
            labelNilaiAkhir.setVisibility(GONE);
            labelBilPrima.setVisibility(GONE);
            hasilBilPrima.setVisibility(GONE);
        }

    }
    //Fungsi untuk menampilkan dan menghilangkan item bilangan genap
    void show_item_2(){
        Object b = spin_item.getItemAtPosition(2);
        if(spin_item.getSelectedItem().equals(b)){
            edtBilGenap.setVisibility(View.VISIBLE);
            labelBilGenap.setVisibility(View.VISIBLE);
            hasilBilGenap.setVisibility(View.VISIBLE);
        }else{
            labelBilGenap.setVisibility(GONE);
            edtBilGenap.setVisibility(GONE);
            hasilBilGenap.setVisibility(GONE);
        }

    }
    //Fungsi untuk menampilkan dan menghilangkan item bilangan ganjil
    void show_item_3(){
        Object c = spin_item.getItemAtPosition(3);
        if (spin_item.getSelectedItem().equals(c)){
            edtBilGanjil.setVisibility(View.VISIBLE);
            labelBilGanjil.setVisibility(View.VISIBLE);
            hasilBilGanjil.setVisibility(View.VISIBLE);
        }else {
            edtBilGanjil.setVisibility(GONE);
            labelBilGanjil.setVisibility(GONE);
            hasilBilGanjil.setVisibility(GONE);
        }

    }
    //Fungsi untuk menampilkan seluruh bilangan
    void show_item_4(){
    Object d = spin_item.getItemAtPosition(4);
    Object a= spin_item.getItemAtPosition(0);
    if (spin_item.getSelectedItem().equals(d)) {
    show_all_item();

    }else if (spin_item.getSelectedItem().equals(a)){
        hide_all_item();
    }

}
    void show_all_item(){
        edtNilaiAwal.setVisibility(View.VISIBLE);
        edtNilaiAkhir.setVisibility(View.VISIBLE);
        labelNilaiAwal.setVisibility(View.VISIBLE);
        labelNilaiAkhir.setVisibility(View.VISIBLE);
        labelBilPrima.setVisibility(View.VISIBLE);
        hasilBilPrima.setVisibility(View.VISIBLE);
        edtBilGenap.setVisibility(View.VISIBLE);
        labelBilGenap.setVisibility(View.VISIBLE);
        hasilBilGenap.setVisibility(View.VISIBLE);
        edtBilGanjil.setVisibility(View.VISIBLE);
        labelBilGanjil.setVisibility(View.VISIBLE);
        hasilBilGanjil.setVisibility(View.VISIBLE);
    }
    void hide_all_item(){
        edtBilGanjil.setVisibility(GONE);
        labelBilGanjil.setVisibility(GONE);
        hasilBilGanjil.setVisibility(GONE);
        labelBilGenap.setVisibility(GONE);
        edtBilGenap.setVisibility(GONE);
        hasilBilGenap.setVisibility(GONE);
        edtNilaiAwal.setVisibility(GONE);
        edtNilaiAkhir.setVisibility(GONE);
        labelNilaiAwal.setVisibility(GONE);
        labelNilaiAkhir.setVisibility(GONE);
        labelBilPrima.setVisibility(GONE);
        hasilBilPrima.setVisibility(GONE);

    }

    //Fungsi Inputan Bilangan Prima
    @SuppressLint("SetTextI18n")
    private void LogicBilanganPrima(String inputNilaiAwal,String inputNilaiAkhir){
try {
    int nilaiAwal = Integer.valueOf(inputNilaiAwal);
    int nilaiAkhir = Integer.valueOf(inputNilaiAkhir);
    int angka;
    String hasil = "";
    for (int i = nilaiAwal; i <= nilaiAkhir; i++) {
        int counter = 0;
        for (angka = i; angka >= 1; angka = angka - 1) {
            if (i % angka == 0) {
                counter = counter + 1;
            }
        }

        if (counter == 2) {
            hasil += " " + i + " ";
            hasilBilPrima.setText("Hasil bilangan prima dari " + nilaiAwal + " sampai " + nilaiAkhir + " : " + hasil);
        }

        hasilBilPrima.setText("Hasil bilangan prima dari " + nilaiAwal + " sampai " + nilaiAkhir + " Adalah : " + hasil);

    }
}catch (NumberFormatException e){
    e.printStackTrace();
}



    }
    //Fungsi Inputan Bilangan Genap
    @SuppressLint("SetTextI18n")
    private void LogicBilanganGenap(String inputNilaiGenap){
        try {
            int nilaiGenap = Integer.valueOf(inputNilaiGenap);
            String hasil="";

            for (int i = 0; i <= nilaiGenap; i++) {

                if (i % 2 == 0) {
                    hasil+=" "+ i +" ";

                    hasilBilGenap.setText("Hasil : " + hasil);
                }

            }

        }catch (NumberFormatException e){
            e.printStackTrace();
        }
    }
    //Fungsi Inputan Bilangan Ganjil
    @SuppressLint("SetTextI18n")
    private void LogicBilanganGanjil(String inputNilaiGanjil){
        try {
            int nilaiGanjil = Integer.valueOf(inputNilaiGanjil);
            String hasil="";

            for (int i = 0; i <= nilaiGanjil; i++) {

                if (i % 2 == 1) {
                    hasil+=" "+ i +" ";

                    hasilBilGanjil.setText("Hasil : " + hasil);

                }

            }
        }catch (NumberFormatException e){
            e.printStackTrace();
        }

        }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }



    @Override
    public void onClick(View view) {
        String inputNilaiAwal = edtNilaiAwal.getText().toString();
        String inputNilaiAkhir = edtNilaiAkhir.getText().toString();
        String inputNilaiGenap = edtBilGenap.getText().toString();
        String inputNilaiGanjil = edtBilGanjil.getText().toString();
        LogicInputNilaiBilanganPrima(inputNilaiAwal,inputNilaiAkhir);
        LogicInputNilaiBilanganGenap(inputNilaiGenap);
        LogicInputNilaiBilanganGanjil(inputNilaiGanjil);
    }

    /*Fungsi untuk memberitahukan jika nilai kosong akan muncul pemberitahuan toast pada nilai inputan masing-masing.
    jika tidak akan muncul hasil nilai inputan
   */
    private void LogicInputNilaiBilanganPrima(String inputNilaiAwal,String inputNilaiAkhir){
        if (inputNilaiAwal.isEmpty()&&inputNilaiAkhir.isEmpty()) {
            FancyToast.makeText(getContext(), "Silahkan Segera di isi kepada kedua nilai bilangan prima yang ingin di inputkan !", FancyToast.LENGTH_SHORT, FancyToast.WARNING, true).show();
        }else {
            LogicBilanganPrima(inputNilaiAwal, inputNilaiAkhir);
        }

    }
    private void LogicInputNilaiBilanganGenap(String inputNilaiGenap){
    if(inputNilaiGenap.isEmpty()){
        FancyToast.makeText(getContext(),"Silahkan Segera di isi nilai bilangan genap yang ingin di inputkan !",FancyToast.LENGTH_SHORT,FancyToast.WARNING,true).show();
    }else {
        LogicBilanganGenap(inputNilaiGenap);
        }
    }
    private void LogicInputNilaiBilanganGanjil(String inputNilaiGanjil){
    if(inputNilaiGanjil.isEmpty()){
        FancyToast.makeText(getContext(),"Silahkan Segera di isi nilai bilangan ganjil yang ingin di inputkan !",FancyToast.LENGTH_SHORT,FancyToast.WARNING,true).show();
    }else{
        LogicBilanganGanjil(inputNilaiGanjil);
    }
  }

}
