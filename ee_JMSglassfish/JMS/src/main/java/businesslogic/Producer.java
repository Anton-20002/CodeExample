package businesslogic;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * Created by Anton on 29.09.2018.
 */
@Stateless
@LocalBean
public class Producer {

    @Resource(mappedName = "jms/myFirst")
    private  ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/myQueue")
    private Destination destination;
    @Schedule(hour = "*", minute = "*", second = "*/5", persistent = false)
    public void produceMessage() throws NamingException {

        try (
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(destination) ) {

            producer.send(session.createTextMessage("Hello MDB"));
            System.out.println("-------------------------------------");


        } catch (JMSException e) {
            e.printStackTrace();
        }

        }




}
