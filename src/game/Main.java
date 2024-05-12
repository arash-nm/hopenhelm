package game;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

    }

    public static void run_game(){
        //  generate random number for create random block
        Random rand = new Random();

        //  create primitive screen
        final int size_of_screen = 11;
        final int index_of_player = size_of_screen/2 +1;
        ArrayList<Box> blocks = new ArrayList<Box>();
        for(int i = 0; i < size_of_screen/2; i++)
            blocks.add(new Free_Box(0));
        blocks.add(new Box(1));


        while (true) {

            //  do block work
            Box test = (blocks.get(index_of_player));
            Box.box_work();

            //  check player alive
            if(Player.is_he_alive(index_of_player))
                continue;
            else
                Main.end_game();


            final int number_of_block_mode = 5;
            int type_of_box = rand.nextInt(10) % number_of_block_mode;  // for generate random number to new block
            //  create new block
            switch (type_of_box) {
                case 0:
                    blocks.add(new Free_Box(type_of_box));
                    break;
                case 1:
                    blocks.add(new Box(type_of_box));
                    break;
                case 2:
                    blocks.add(new Fire_box(type_of_box));
                    break;
                case 3:
                    blocks.add(new Sword_box(type_of_box));
                    break;
                case 4:
                    blocks.add(new Time_Box(type_of_box));

            }

        }
    }

    public static void end_game(){
        System.out.println(123);
    }
}