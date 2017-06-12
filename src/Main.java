
public class Main {

    public static void main(String[] args) {


        CommonSwitch cs = new CommonSwitch();

        new Thread(new RandomNumberThread(cs)).start();
        new Thread(new NumberCounterThread(cs)).start();


    }
}