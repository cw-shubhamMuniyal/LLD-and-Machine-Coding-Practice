package PubSubQueue.Interface;

import PubSubQueue.Model.Message;

public interface ISubscriber {

    String getId();
    void consume(Message message) throws InterruptedException;
}