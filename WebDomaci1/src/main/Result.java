package main;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;

public class Result implements Runnable{

    public static boolean f = false;
    private String student;
    private String questioner;
    private Professor professor;
    private Assistant assistant;
    private long arrivalTime;
    private long TTC;
    private long startTime;
    private long startTime2;
    private int score;
    private boolean done;

    public Result(String student, Professor professor , Assistant assistant, Long arrivalTime, Long TTC, long startTime, int score) {
        this.student = student;
        this.professor = professor;
        this.assistant = assistant;
        this.arrivalTime = arrivalTime;
        this.TTC = TTC;
        this.startTime = startTime;
        this.score = score;
    }

    @Override
    public void run() {
        Random rand = new Random();
        while(!done){
            int i = rand.nextInt(2);

            if(i==1) {
                //professor
                questioner = professor.getName();
                try {
                    professor.getCyclicBarrier().await();
                    //startTime2 = System.currentTimeMillis();
                } catch (InterruptedException e) {
                    System.out.println(student + " interrupted!");
                    //valjda ako dobije poslednjeg i nema para za njega onda pukne
                    return;
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
                startTime2 = System.currentTimeMillis() - Main.clock;
                done = true;
            } else {
                //assistant
                questioner = assistant.getName();
                startTime2 = System.currentTimeMillis() - Main.clock;
                done = true;
            }
        }
        //done
        if(startTime2 >= 5000){//isteklo 5 sekundi
            //f = true;
            Main.num.incrementAndGet();
            System.out.println(student + " ran out of time");
        } else {
            //f = false;
            Main.sum.addAndGet(score);
            System.out.println("Thread:" + student +
                    "  Arrival:" + arrivalTime +
                    "  Prof:" + questioner +
                    "  TTC:" + TTC +
                    "  Start:" + startTime2 +
                    "  Score:" + score);
        }
    }

    @Override
    public String toString() {
        return "Result{" +
                "Student = '" + student + '\'' +
                ", Questioner = '" + questioner + '\'' +
                ", Arrival time = " + arrivalTime +
                ", TTC = " + TTC +
                ", Start time = " + startTime +
                ", Score = " + score +
                '}';
    }

    public String getQuestioner() {
        return questioner;
    }

    public void setQuestioner(String questioner) {
        this.questioner = questioner;
    }

    public Long getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Long arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Long getTTC() {
        return TTC;
    }

    public void setTTC(Long TTC) {
        this.TTC = TTC;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
