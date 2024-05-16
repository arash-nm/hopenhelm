package game;

class Time implements Runnable {

    private static int time;

    Time() {
        time = 0;
    }

    public static int get_time(){
        return time;
    }
    @Override
    public void run() {

        while(time < Main.max_time_of_stop *10){
            time ++;
            //System.out.println(time);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted.");
            }
        }
    }
}