package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.cg_engine.CastGameTemplate;
import pts3.castgame.models.cg_engine.LignTemplate;

public class TemplateFragment extends Fragment {

    public static final List<CastGameTemplate> template = templatesDuProf();
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_template, container, false);

        mListView = (ListView) v.findViewById(R.id.listTemplate);

        ArrayAdapter<CastGameTemplate> adapter = new ArrayAdapter<CastGameTemplate>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                template
        );
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO corriger ce morceau
                ((MainActivity)getActivity()).getIntent().putExtra("template",template.get(position).toString());

                Log.i("test : ", "Position=" + position);

                ((MainActivity)getActivity()).choisirTemplate();
            }
        });
        return v;
    }

    private static List<CastGameTemplate> templatesDuProf() {
        List<CastGameTemplate> result = new ArrayList<CastGameTemplate>(18);

        //1
        List<LignTemplate> lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, 1, false, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //2
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //3
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //4
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //5
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, false));

        //6
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //7
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        //8
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        result.add(new CastGameTemplate(lignList, 1, false));

        //9
        lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, null, false, 1));
        result.add(new CastGameTemplate(lignList, 1, true));

        //10
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        //11
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        lignList.add(new LignTemplate(3, 2, 3, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        //12
        lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, 1, false, 2));
        result.add(new CastGameTemplate(lignList, 1, true));

        //13
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        result.add(new CastGameTemplate(lignList, 1, true));

        //14
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        result.add(new CastGameTemplate(lignList, 1, true));

        //15
        lignList = new ArrayList<LignTemplate>(3);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        lignList.add(new LignTemplate(2, 2, null, true, 2));
        lignList.add(new LignTemplate(null, 1, null, false, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //16
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, 1, true, 2));
        result.add(new CastGameTemplate(lignList, 1, false));

        //17
        lignList = new ArrayList<LignTemplate>(1);
        lignList.add(new LignTemplate(1, 1, null, true, 1));
        result.add(new CastGameTemplate(lignList, 1, true));

        //18
        lignList = new ArrayList<LignTemplate>(2);
        lignList.add(new LignTemplate(1, 1, null, true, 2));
        lignList.add(new LignTemplate(3, 2, null, false, 1));
        result.add(new CastGameTemplate(lignList, 2, true));

        return result;
    }
}

