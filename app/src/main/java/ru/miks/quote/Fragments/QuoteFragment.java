package ru.miks.quote.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.miks.quote.R;


public class QuoteFragment extends Fragment {//implements OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    List abc;
    List quote;
    ListView lv_quote;
    boolean do_share =false;
    //private OnFragmentInteractionListener mListener;
    View rootview;

    public QuoteFragment() {
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
    public static QuoteFragment newInstance(String param1, String param2) {
        QuoteFragment fragment = new QuoteFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);

            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootview = inflater.inflate(R.layout.fragment_quote, container, false);
        // Inflate the layout for this fragment
//        ListView lv_abc=(ListView) rootview.findViewById(R.id.lvabc);
//        lv_abc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String a= abc.get(position).toString().substring(0,1);
//                for(int i=0;i<quote.size();i++){
//                    if(a.equals(quote.get(i).toString().substring(0,1))){
//                        lv_quote.setSelection(i);
//                        break;
//                    };
//                }
//            }
//        });
//        //String[] abc= {"A","B",....
//        //or this
//        abc=new ArrayList<String>();
//        abc.add("А");
//        abc.add("Б");
//        abc.add("В");
//        abc.add("Г");
//        abc.add("Д");
//        abc.add("Е");
//        abc.add("Ё");
//        abc.add("Ж");
//        abc.add("З");
//        abc.add("И");
//        abc.add("Й");
//        abc.add("К");
//        abc.add("Л");
//        abc.add("М");
//        abc.add("Н");
//        abc.add("О");
//        abc.add("П");
//        abc.add("Р");
//        abc.add("С");
//        abc.add("Т");
//        abc.add("У");
//        abc.add("Ф");
//        abc.add("Х");
//        abc.add("Ц");
//        abc.add("Ч");
//        abc.add("Ш");
//        abc.add("Щ");
//        abc.add("Э");
//        abc.add("Ю");
//        abc.add("Я");
//        ArrayAdapter<String> abc_adapter=new ArrayAdapter<String>(rootview.getContext(),R.layout.adapter_abc,abc);
//        lv_abc.setAdapter(abc_adapter);


        lv_quote = (ListView) rootview.findViewById(R.id.lvauthors);
        lv_quote.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(do_share) {do_share=false;
                    final Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.setType("text/plain");
                    intent.putExtra(Intent.EXTRA_TEXT, getResources().getText(R.string.share).toString());
                    try {
                        startActivity(Intent.createChooser(intent, quote.get(position).toString()));
                    } catch (Exception e) {
                    }
                }


            }
        });
        quote = new ArrayList<String>();
        quote.add("Армалвло");
        quote.add("Б");
        quote.add("В");
        quote.add("Г");
        quote.add("Д");
        quote.add("Е");
        quote.add("Ё");
        quote.add("Ж");
        quote.add("З");
        quote.add("И");
        quote.add("Й");
        quote.add("К");
        quote.add("Л");
        quote.add("М");
        quote.add("Н");
        quote.add("О");
        quote.add("П");
        quote.add("Р");
        quote.add("С");
        quote.add("Т");
        quote.add("У");
        quote.add("Ф");
        quote.add("Х");
        quote.add("Ц");
        quote.add("Ч");
        quote.add("Ш");
        quote.add("Щ");
        quote.add("Э");
        quote.add("Ю");
        quote.add("Я");
        ArrayAdapter<String> quote_adapter = new ArrayAdapter<String>(rootview.getContext(), android.R.layout.simple_list_item_1, quote);
        lv_quote.setAdapter(quote_adapter);
        return rootview;
    }

    public void onCreateOptionsMenu(android.view.Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_quotes, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {

            do_share=true;
            Toast.makeText(getActivity(),getResources().getText(R.string.share_help).toString(), Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
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
