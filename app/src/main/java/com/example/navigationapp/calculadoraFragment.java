package com.example.navigationapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link calculadoraFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class calculadoraFragment extends Fragment {



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public calculadoraFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment calculadoraFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static calculadoraFragment newInstance(String param1, String param2) {
        calculadoraFragment fragment = new calculadoraFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private View view;
    private EditText etNro1, etNro2, etResultado;
    private Button btnSumar, btnRestar, btnMultiplicar, btnDividir;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        etNro1 = view.findViewById(R.id.etNro1);
        etNro2 = view.findViewById(R.id.etNro2);
        etResultado = view.findViewById(R.id.etResultado);
        btnSumar = view.findViewById(R.id.btnSumar);
        btnRestar = view.findViewById(R.id.btnRestar);
        btnMultiplicar = view.findViewById(R.id.btnMultiplicar);
        btnDividir = view.findViewById(R.id.btnDividir);

        btnSumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nro1 = Double.valueOf(etNro1.getText().toString());
                double nro2 = Double.valueOf(etNro2.getText().toString());
                double suma = nro1+nro2;
                etResultado.setText(String.valueOf(suma));
            }
        });
        btnRestar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nro1 = Double.valueOf(etNro1.getText().toString());
                double nro2 = Double.valueOf(etNro2.getText().toString());
                double resta = nro1-nro2;
                etResultado.setText(String.valueOf(resta));
            }
        });
        btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nro1 = Double.valueOf(etNro1.getText().toString());
                double nro2 = Double.valueOf(etNro2.getText().toString());
                double multi = nro1*nro2;
                etResultado.setText(String.valueOf(multi));
            }
        });
        btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double nro1 = Double.valueOf(etNro1.getText().toString());
                double nro2 = Double.valueOf(etNro2.getText().toString());
                if(nro2==0) {
                    etResultado.setText("Error: Division");
                }else {
                    double division = nro1 / nro2;
                    etResultado.setText(String.valueOf(division));
                }
            }
        });
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Escuchar los controles de la vista
        Button btnSalir = view.findViewById(R.id.btnSalir);

        //Proceso de evento
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.maravillasFragment);
            }
        });

    }
}