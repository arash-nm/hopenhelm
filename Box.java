package game;

public class Box {
    //  help for number of box --->  0 = Free_Box    1 = Default_Box    2 = Fire_Box    3 = Sword_Box   4 = Time_Box

    private static int type;
    private static boolean is_enemy;
    private static final int time_block_live = 2;
    private static final int time_of_pausing = 3;

    public static int get_type(){
        return type;
    }
    public static boolean get_is_enemy(){
        return is_enemy;
    }
    public static int get_time_block_live(){
        return time_block_live;
    }
    public static int get_time_of_pausing(){
        return time_of_pausing;
    }


    public Box(int type_of_box, boolean is_enemy){

        Box.type = type_of_box;
        if(Box.type == 1)
            Box.is_enemy = is_enemy;
        else
            Box.is_enemy = false;

    }

}
