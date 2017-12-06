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

import pts3.castgame.R;
import pts3.castgame.activities.MainActivity;

public class TemplateFragment extends Fragment {

    String[] template;
    private ListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_template, container, false);
        template = new String[]{"1) [Carte 1] perso1 = new [Carte 1]();\n[Carte 2] perso2 = new [carte 2]();\nperso1 = ([Carte 1]) perso2;\nSystem.out.println(personnage);",
                "2) [Carte 1] perso1 = new [Carte 2]();\n[Carte 3] perso2 = ([Carte 3]) perso1;\nSystem.out.println(perso2);",
                "3) [Carte 1] perso1 = ([Carte 1]) new [Carte 2]();\n[Carte 3] perso2 = ([Carte 3]) perso1;\nSystem.out.println(perso2);",
                "4) [Carte 1] perso1 = ([Carte 1]) new [Carte 2]();\n[Carte 3] perso2 = perso1;\nSystem.out.println(perso2);",
                "5) [Carte 1] perso1 = new [Carte 2]();\n[Carte 3] perso2 = perso1;\nSystem.out.println(perso2);",
                "6) [Carte 1] perso = new [Carte 2]();\nSystem.out.println(personnage);",
                "7) [Carte 1] perso1 = ([Carte 1]) new [Carte 2]();\n[Carte 3] perso2 = perso1;\nSystem.out.println(personnage);",
                "8) [Carte 1] perso = new [Carte 1]();\nSystem.out.println(perso);",
                "9) [Carte 1] perso1 = [Carte 1]();\n[Carte 2] perso2 = new [Carte 2]();\nperso1 = perso2;\nperso1.[Carte M]();",
                "10) [Carte 1] perso1 = new [Carte 2]();\n[Carte 3] perso2 = ([Carte 3]) perso1;\nperso2.[Carte M]();",
                "11) [Carte 1] perso1 = ([Carte 1]) new [Carte 2]();\n[Carte 3] perso2 = ([Carte 3]) perso1;\nperso2.[Carte M]();",
                "12) [Carte 1] perso1 = new [Carte 1]();\n[Carte 2] perso2 = new [Carte 2]();\nperso1 = ([Carte 1]) perso2;\nperso1.[Carte M]();",
                "13) [Carte 1] perso = ([Carte 1]) new [Carte 2]();\nperso.[Carte M]();",
                "14) [Carte 1] perso = new [Carte 2]();\nperso.[Carte M]();",
                "15) [Carte 1] perso1 = new [Carte 1]();\n[Carte 2] perso2 = new [Carte 2]();\nperso1 = perso2;\nSystem.out.println(perso 1);",
                "16) [Carte 1] perso = ([Carte 1]) new [Carte 2]();\nSystem.out.println(perso);",
                "17) [Carte 1] perso = new [Carte 1]();\nperso.[Carte M]();",
                "18) [Carte 1] perso1 = new [Carte 2]();\n[Carte 3] perso2 = perso1;\nperso2.[Carte M]();"};

        mListView = (ListView) v.findViewById(R.id.listTemplate);

        ArrayAdapter<String> adapter  = new ArrayAdapter<String >(
                getActivity(),
                android.R.layout.simple_list_item_1,
                template
        );
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("test : ", "Position=" + position);

            }
        });
        return v;
    }



}
