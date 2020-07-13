package ru.miks.quote.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import ru.miks.quote.R;


public class ThemesFragment extends Fragment {//implements OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List abc;
    List theme;
    ListView lv_theme;
    //private OnFragmentInteractionListener mListener;
    View rootview;

    public ThemesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ThemesFragment newInstance(String param1, String param2) {
        ThemesFragment fragment = new ThemesFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview= inflater.inflate(R.layout.fragment_abc, container, false);
        // Inflate the layout for this fragment
        ListView lv_abc=(ListView) rootview.findViewById(R.id.lvabc);
        lv_abc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String a= abc.get(position).toString().substring(0,1);
                for(int i=0;i<theme.size();i++){
                    if(a.equals(theme.get(i).toString().substring(0,1))){
                        lv_theme.setSelection(i);
                        break;
                    };
                }
            }
        });
        //String[] abc= {"A","B",....
        //or this
        abc=new ArrayList<String>();
        abc.add("А");
        abc.add("Б");
        abc.add("В");
        abc.add("Г");
        abc.add("Д");
        abc.add("Е");
        abc.add("Ё");
        abc.add("Ж");
        abc.add("З");
        abc.add("И");
        abc.add("Й");
        abc.add("К");
        abc.add("Л");
        abc.add("М");
        abc.add("Н");
        abc.add("О");
        abc.add("П");
        abc.add("Р");
        abc.add("С");
        abc.add("Т");
        abc.add("У");
        abc.add("Ф");
        abc.add("Х");
        abc.add("Ц");
        abc.add("Ч");
        abc.add("Ш");
        abc.add("Щ");
        abc.add("Э");
        abc.add("Ю");
        abc.add("Я");
        ArrayAdapter<String> abc_adapter=new ArrayAdapter<String>(rootview.getContext(),R.layout.adapter_abc,abc);
        lv_abc.setAdapter(abc_adapter);


        lv_theme=(ListView) rootview.findViewById(R.id.lvauthors);
        lv_theme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                getActivity().getSupportFragmentManager().popBackStack(0,0);
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.container,new QuoteFragment()).addToBackStack("QuoteFragment").commit();
            }
        });
        theme=new ArrayList<String>();
        theme.add("Абстракция");
        theme.add("Б");
        theme.add("В");
        theme.add("Г");
        theme.add("Д");
        theme.add("Е");
        theme.add("Ё");
        theme.add("Ж");
        theme.add("З");
        theme.add("И");
        theme.add("Й");
        theme.add("К");
        theme.add("Л");
        theme.add("М");
        theme.add("Н");
        theme.add("О");
        theme.add("П");
        theme.add("Р");
        theme.add("С");
        theme.add("Т");
        theme.add("У");
        theme.add("Ф");
        theme.add("Х");
        theme.add("Ц");
        theme.add("Ч");
        theme.add("Ш");
        theme.add("Щ");
        theme.add("Э");
        theme.add("Ю");
        theme.add("Я");
        ArrayAdapter<String> theme_adapter=new ArrayAdapter<String>(rootview.getContext(),android.R.layout.simple_list_item_1,theme);
        lv_theme.setAdapter(theme_adapter);
        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
       // mListener = null;
    }

//    @Override
//    public void onFragmentInteraction(Uri uri) {
//
//    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */



}
