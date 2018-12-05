import java.util.Scanner;

public class Main{
    public static void menu(){
        System.out.println("0 - exit" + "\n" + "1 - add node" +"\n" + "2 - get node using key of node");
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<Integer, Integer> treeM = new TreeMap<Integer, Integer>();

        menu();
        int choose;
        do {
            choose = sc.nextInt();
            switch (choose) {
                case 1: {
                    treeM.add();
                    break;
                }
                case 2: {
                    treeM.get();
                    break;
                }
                default: {
                    if (choose != 0)
                        System.out.println("Error!");
                }
            }
            menu();
        } while (choose != 0);
    }
}
