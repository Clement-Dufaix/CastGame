package pts3.castgame.models.cg_engine.lien;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import pts3.castgame.models.cg_engine.CastGameTemplate;
import pts3.castgame.models.cg_engine.CastGameTypable;
import pts3.castgame.models.cg_engine.LignTemplate;

public class FacadeMoteur {

    public static final List<CastGameTemplate> TEMPLATES = templatesDuProf();
    private CastGameTemplate templateChoisi;
    private List<CastGameTemplate> listTemplate;
    private Map<Integer, CastGameTypable> dfgth;

    public FacadeMoteur() {

    }

    public void setTemplateChoisi(CastGameTemplate template){
        this.templateChoisi = template;
    }

    public List<CastGameTemplate> getListTemplate(){
        return /*Temp*/TEMPLATES;
    }

    public static List<CastGameTemplate> templatesDuProf() {
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
