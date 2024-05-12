package game;

public class Box {
    //  help for number of box
    //  0 = free box
    //  1 = default box
    //  2 = fire box
    //  3 = sword box
    private static int type;

    public static void box(){
        System.out.println("test");
    }
    public static int get_type(){
        return type;
    }
    public static void box_work(int type_of_box){
        switch (type_of_box) {
            case 0:
                screen_box.add(new Free_Box(type_of_box));
                break;
            case 1:
                screen_box.add(new Box(type_of_box));
                break;
            case 2:
                screen_box.add(new Fire_box(type_of_box));
                break;
            case 3:
                screen_box.add(new Sword_box(type_of_box));
                break;

        }
    }

    public Box(int type){
        this.type = type;

    }


}
