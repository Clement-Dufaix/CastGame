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

import java.util.ArrayList;
import java.util.List;

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;
import pts3.castgame.models.CastGameTemplate;

public class TemplateFragment extends Fragment {

    private MainActivity context;
    private ListView listTemplates;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_template, container, false);
        context = ((MainActivity) getActivity());

        listTemplates = view.findViewById(R.id.list_templates);
        context.getFacade().reset();

        // Ajout des numéros aux templates
        List<CastGameTemplate> templates = context.getFacade().getListTemplate();
        List<String> templatesString = new ArrayList<>();

        int i = 1;
        for (CastGameTemplate template : templates) {
            templatesString.add("N°" + i + "\n" + template.toString());
            i++;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(),
                android.R.layout.simple_list_item_1, templatesString);
        listTemplates.setAdapter(adapter);


        listTemplates.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                context.getFacade().setTemplateChoisi(context.getFacade().getListTemplate().get(position));
                context.setFragmentCardSelection();
            }
        });
        return view;
    }

}

