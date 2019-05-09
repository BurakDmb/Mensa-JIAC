package burakdmb.mensa;

import de.dailab.jiactng.agentcore.AbstractAgentBean;
import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.IMethodExposingBean;
import de.dailab.jiactng.agentcore.action.IMethodExposingBean.Expose;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.comm.ICommunicationBean;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MensaBean extends AbstractMethodExposingBean {


    public static final String ACTION_FETCH_ESSEN= "burakdmb.mensa.MensaBean#fetchEssen";

    @Override
    public void doStart() throws Exception{
        super.doStart();
    }

    @Expose(name = ACTION_FETCH_ESSEN, scope = ActionScope.GLOBAL)
    public String[] fetchEssen(String date, Integer resources_id) throws IOException {
        ArrayList<String> list = new ArrayList<>();

        Document doc = Jsoup.connect("https://www.stw.berlin/xhr/speiseplan-wochentag.html")
                .data("resources_id", ""+resources_id)
                .data("date", date)
                .userAgent("Mozilla")
                .post();

        Elements newsHeadlines = doc.select(".splGroupWrapper:contains(Essen)>.splMeal span.bold");
        for (Element headline : newsHeadlines) {
            list.add(headline.ownText());
        }
        return list.toArray(new String[list.size()]);
    }
}
