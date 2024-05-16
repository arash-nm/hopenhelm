package game;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    static Random rand = new Random();
    static ArrayList<Box> blocks = new ArrayList<Box>();
    static Time time_of_player_on_this_block = new Time();
    static final int number_of_block_mode = 4;
    static final int size_of_screen = 11;
    static final int max_time_of_stop = 2;
    static final int index_of_player = size_of_screen/2 +1;


    public static void main(String[] args) {
        Main.run_game();
    }

    public static void run_game(){


        for(int i = 0; i < size_of_screen/2; i++)
            blocks.add(new Box(0,false));
        blocks.add(new Box( 1,false));
        blocks.add(new Box( 1,false));
        for(int i = 1; i < size_of_screen/2; i++) {
            int type_of_box = rand.nextInt(10) % number_of_block_mode +1;
            boolean is_enemy = rand.nextBoolean();
            blocks.add(new Box(type_of_box,is_enemy));
        }

        int i = 0;
        while (i <20) {
            i++;
                            //  *********** press button ***********   \\

            //  calculating the stop time

            Thread thread = new Thread(time_of_player_on_this_block);
            thread.start();
            //System.out.println("467865432145678654321");

            //  for generate new random block
            int type_of_box = rand.nextInt(10) % number_of_block_mode +1;
            boolean is_enemy = rand.nextBoolean();
            //  create new block
            blocks.add(new Box(type_of_box, is_enemy));
            blocks.removeFirst();



            //  check what happens to the player?
            Player.Is_he_Damaged(index_of_player);




        }
    }

    //  for ending game
    public static void end_game(){
        System.out.println(123);
    }
}