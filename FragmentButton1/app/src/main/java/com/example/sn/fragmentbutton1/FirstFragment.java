package com.example.sn.fragmentbutton1;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    static EditText et;
    Button b;
    CustomInterface cif;
    public FirstFragment() {
        // Required empty public constructor

    }

    public interface CustomInterface
    {
        public void passData(String s);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_first, container, false);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        cif= (CustomInterface) context;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        et = (EditText) getActivity().findViewById(R.id.et1);
        b = (Button)getActivity().findViewById(R.id.but1);


        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getActivity(),"Button clicked", Toast.LENGTH_SHORT).show();
                cif.passData(et.getText().toString());

            }
        });

    }


}
