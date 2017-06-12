import java.util.Random;

public class RandomNumberThread implements Runnable{


    RandomNumberThread(CommonSwitch commonSwitch){
        this.commonSwitch = commonSwitch;
    }

    Random rand;
    CommonSwitch commonSwitch;

    @Override
    public void run() {
        synchronized (commonSwitch) {

            while (commonSwitch.isTurnedOn()) {

                int i = ((int) (Math.random() * 10));
                commonSwitch.set.add(i);
                //System.out.println(i);
                System.out.println(commonSwitch.set);
                System.out.println(commonSwitch.set.size());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
