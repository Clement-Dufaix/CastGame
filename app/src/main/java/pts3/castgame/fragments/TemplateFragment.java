package pts3.castgame.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.CastGameTemplate;

public class TemplateFragment extends Fragment {


    private ListView mListView;
    private MainActivity context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_template, container, false);

        mListView = v.findViewById(R.id.listTemplate);
        context = ((MainActivity)getActivity());
        ArrayAdapter<CastGameTemplate> adapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                context.getFacade().getListTemplate()
        );
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("test : ", "Position=" + position);
                context.getFacade().setTemplateChoisi(context.getFacade().getListTemplate().get(position));
                ((MainActivity)getActivity()).selectTemplate();
            }
        });
        return v;
    }

}

