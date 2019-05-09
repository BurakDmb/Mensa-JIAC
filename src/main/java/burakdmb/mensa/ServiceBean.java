package burakdmb.mensa;

import de.dailab.jiactng.agentcore.action.AbstractMethodExposingBean;
import de.dailab.jiactng.agentcore.action.Action;
import de.dailab.jiactng.agentcore.action.ActionResult;
import de.dailab.jiactng.agentcore.action.scope.ActionScope;
import de.dailab.jiactng.agentcore.ontology.IActionDescription;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.TemplateViewRoute;
import spark.template.pebble.PebbleTemplateEngine;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static spark.Spark.get;


public class ServiceBean extends AbstractMethodExposingBean{


    public static final String ACTION_START_WEBSERVER = "burakdmb.mensa.ServiceBean#startServer";


    @Override
    public void doStart() throws Exception{
        super.doStart();
        IActionDescription startAction= retrieveAction(ACTION_START_WEBSERVER);
        if (startAction == null)
            throw new RuntimeException("Start action not found.");
        invoke(startAction, null);
    }


    @Expose(name = ACTION_START_WEBSERVER, scope = ActionScope.NODE)
    public void startServer()  {
        get("/", new TemplateViewRoute() {
            @Override
            public ModelAndView handle(Request request, Response response) throws Exception {
                IActionDescription template = new Action(MensaBean.ACTION_FETCH_ESSEN);
                IActionDescription act = thisAgent.searchAction(template);
                if (act == null)
                    throw new RuntimeException("Fetch essen action not found.");

                //Get current date
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String date = dateFormat.format(new Date());

                //Invoke the action from the MensaAgent and wait for the result
                ActionResult result = invokeAndWaitForResult(act, new Serializable[]{date, new Integer(538)});
                Serializable[] tmp = result.getResults();
                String[] essenResult = (String[])tmp[0];

                //Create a hashmap for the template engine end render the template with these attributes.
                Map<String, Object> attributes = new HashMap<>();
                attributes.put("essens", essenResult);
                return new ModelAndView(attributes, "index.pebble");
            }
        }, new PebbleTemplateEngine());
        log.info("Web server is active");
    }
}
