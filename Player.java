package game;

public class Player {

    private static int number_of_heart = 3;

    public static void enemy_death() {
        System.out.println("death");
    }

    public static void Is_he_Damaged(int index_player_block){

        //  help for number of box --->  0 = Free_Box    1 = Default_Box    2 = Fire_Box    3 = Sword_Box   4 = Time_Box

        boolean damage_in_time = true;//(Main.time_of_player_on_this_block.get_time() / Box.get_time_of_pausing()) %2 == 1;

        //  give type & is_enemy of player's block and next block
        int type_if_this_block = Main.blocks.get(index_player_block).get_type();
        boolean is_enemy = Main.blocks.get(index_player_block).get_is_enemy();
        int type_of_next_block = Main.blocks.get(index_player_block + 1).get_type();
        boolean is_enemy_next = Main.blocks.get(index_player_block +1).get_is_enemy();


        //  check damage or death
        if((type_if_this_block == 1 && is_enemy && damage_in_time) || (type_of_next_block == 1 && is_enemy_next && damage_in_time))
            number_of_heart--;
        if(type_if_this_block == 2 && damage_in_time)
            number_of_heart--;
        if(type_of_next_block == 3 && damage_in_time)
            number_of_heart--;
        if(type_if_this_block == 4 && Main.time_of_player_on_this_block.get_time() > Box.get_time_block_live())
            Player.enemy_death();


        //  check game finished or no
        if(number_of_heart <= 0)
            Player.enemy_death();

    }
}
