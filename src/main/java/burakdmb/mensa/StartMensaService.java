package burakdmb.mensa;


import de.dailab.jiactng.agentcore.SimpleAgentNode;
import de.dailab.jiactng.agentcore.lifecycle.LifecycleException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StartMensaService {

    public static void main(String[] args) {
        System.setProperty("log4j.configuration", "jiactng_log4j.properties");

        // start node
        SimpleAgentNode node = (SimpleAgentNode)
                new ClassPathXmlApplicationContext("mensa/mensa_service.xml").getBean("MensaServiceNode");

        // wait a few seconds
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // stop node
        try {
            node.shutdown();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
