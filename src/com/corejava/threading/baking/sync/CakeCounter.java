package com.corejava.threading.baking.sync;

class CakeCounter {
    int cakeCount = 0;

    public synchronized void increment() {
        cakeCount++;
    }
}

class Team implements Runnable {
    CakeCounter cakeCounter;

    Team(CakeCounter cakeCounter) {
        this.cakeCounter = cakeCounter;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            cakeCounter.increment();
        }
    }
}

class SyncClient {
    public static void main(String[] args) {
        CakeCounter cakeCounter = new CakeCounter();

        Thread team1 = new Thread(new Team(cakeCounter));
        Thread team2 = new Thread(new Team(cakeCounter));

        team1.start();
        team2.start();

        // We are joining two threads to indicate that it should print cake count only after full completion of both the threads.
        // So the meaning of "join" is t1 and t2 will join back main thread after
        // they finish their own thread. So main thread has to wait for their join
        try {
            team1.join();
            team2.join();
        } catch (Exception ignored) {
        }

        System.out.println(cakeCounter.cakeCount); // 2000
    }
}
