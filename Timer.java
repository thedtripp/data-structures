package project7_sorting;

/** Class: Timer
 * @author Dr. Glenn Stevenson
 * This Timer class calculates that time taken to complete a process. In this
 * case, it is used to measure completion time for various sorting algorithms.
 */

public class Timer {

    double  count = 0;
    public Timer()
    { 
       
    }
    public void startTimer()
    {
        count = System.nanoTime();
    }
    public void stopTimer()
    {
        long stopCount = System.nanoTime();
        count = stopCount - count;
    }
    public double getMilli()
    {
        return count / 1000000.0; 
    }
    public double getMicro()
    {
        return count / 1000.0;
    }
    public double getSecond()
    {
        return count / 1000000000.0; 
    }

}