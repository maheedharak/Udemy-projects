package org.personal;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> channelToSubscribers  = new TreeMap<>(); // channelName, numSubscribers
        Map<String, String> channelToPublisher = new TreeMap<>(); // channelName, publisher
        Map<String, Integer> publisherToSubscribers = new TreeMap<>(); // publisher, numSubscribers
// channel -> number of subscribers (K, V1)
        channelToSubscribers.put("JustForLaughs", 120_000);
        channelToSubscribers.put("JustForGags", 10_000);
        channelToSubscribers.put("ContemplationTechniques", 10_000);
        channelToSubscribers.put("A New Earth", 20_000);
// channel -> publisher (K, V2)
        channelToPublisher.put("JustForLaughs", "Charlie Chaplin");
        channelToPublisher.put("JustForGags", "Charlie Chaplin");
        channelToPublisher.put("ContemplationTechniques", "Echhart Tolle");
        channelToPublisher.put("A New Earth", "Echhart Tolle");


        channelToSubscribers.forEach((K,V) ->{
            String publisher = channelToPublisher.get(K);
            Integer totalVal = publisherToSubscribers.get(publisher) == null? V:(publisherToSubscribers.get(publisher) + V); ;
            publisherToSubscribers.put(publisher,totalVal);
        });
        publisherToSubscribers.forEach((K,V) -> System.out.println("publisher: "+K+"; numSubscribers:"+V));
        Comparator<Entry<String,Integer>> entryComparator = Comparator.comparingInt(Entry::getValue);
        Entry<String,Integer> maxPublishers = Collections.max(publisherToSubscribers.entrySet(),entryComparator);
        System.out.println("Publisher with most subscribers: "+maxPublishers.getKey()+" "+maxPublishers.getValue());
        Entry<String,Integer> minPublishers = Collections.min(publisherToSubscribers.entrySet(),entryComparator);
        System.out.println("Publisher with fewest subscribers: "+minPublishers.getKey()+" "+minPublishers.getValue());

    }
}