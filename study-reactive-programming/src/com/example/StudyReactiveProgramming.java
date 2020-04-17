package com.example;

import com.example.event.TradeEvent;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
// Flow API (Concurrency API)
public class StudyReactiveProgramming {
    public static void main(String[] args) {
        SubmissionPublisher<TradeEvent> publisher =
                new SubmissionPublisher<>();
        Flow.Subscriber<TradeEvent> algoTrader = new AlgoTrader();
        Flow.Subscriber<TradeEvent> signalProcessor = new SignalProcessor();
        publisher.subscribe(algoTrader);
        publisher.subscribe(signalProcessor);
        List<TradeEvent> events = List.of(new TradeEvent("GARAN", 1000, 20), new TradeEvent("GARAN", 2000, 21),
                new TradeEvent("GARAN", 3000, 22), new TradeEvent("GARAN", 4000, 23), new TradeEvent("GARAN", 1000, 22),
                new TradeEvent("GARAN", 2000, 21), new TradeEvent("GARAN", 2000, 22),
                new TradeEvent("GARAN", 3000, 22));
        Consumer<TradeEvent> submitEvent = publisher::submit;
        Consumer<TradeEvent> sleep1Sec = event -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
        };
        events.forEach(submitEvent);
        try {
            TimeUnit.SECONDS.sleep(30);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        publisher.close();
        System.err.println("Done.");
    }
}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class AlgoTrader implements Flow.Subscriber<TradeEvent> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(TradeEvent tradeEvent) {
        System.err.println("AlgoTrader: " +Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.err.println("AlgoTrader: " + tradeEvent);
        this.subscription.request(1);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.err.println("AlgoTrader is done!");
    }

}

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class SignalProcessor implements Flow.Subscriber<TradeEvent> {

    private Flow.Subscription subscription;

    @Override
    public void onSubscribe(Flow.Subscription subscription) {
        this.subscription = subscription;
        this.subscription.request(1);
    }

    @Override
    public void onNext(TradeEvent tradeEvent) {
        System.err.println("SignalProcessor: " +Thread.currentThread().getName());
        System.err.println("SignalProcessor: " + tradeEvent);
        this.subscription.request(2);
    }

    @Override
    public void onError(Throwable throwable) {
        System.err.println(throwable.getMessage());
    }

    @Override
    public void onComplete() {
        System.err.println("SignalProcessor is done!");
    }

}