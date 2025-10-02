
import org.example.Broker;
import org.example.Observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class BrokerTest {
    private Broker broker;
    private List<String> messagesReceived;

    class TestObserver implements Observer {
        @Override
        public void update(String message) {
            messagesReceived.add(message);
        }
    }

    @BeforeEach
    void setUp() {
        broker = new Broker();
        messagesReceived = new ArrayList<>();
    }

    @Test
    void testObserverReceivesNotificationMessage() {
        Observer testObserver = new TestObserver();
        broker.addObserver(testObserver);
        broker.setStatus("Up");

        assertEquals(1, messagesReceived.size());
        assertTrue(messagesReceived.get(0).contains("Up"));
    }

    @Test
    void testMultipleObserversReceivingNotificationMessage() {
        Observer observer1 = new TestObserver();
        Observer observer2 = new TestObserver();

        broker.addObserver(observer1);
        broker.addObserver(observer2);

        broker.setStatus("Down");

        assertEquals(2, messagesReceived.size());
        for (String msg : messagesReceived) {
            assertTrue(msg.contains("Down"));
        }
    }
}
