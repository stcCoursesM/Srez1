
public class RandomNumberThread implements Runnable{


    RandomNumberThread(CommonSwitch commonSwitch){
        this.commonSwitch = commonSwitch;
    }

    CommonSwitch commonSwitch;

    @Override
    public void run() {
        synchronized (commonSwitch) {
            commonSwitch.notify();
            int y = 0;
            while (commonSwitch.isTurnedOn()) {


                int i = ((int) (Math.random() * 10));
                commonSwitch.set.add(i);
                y++;
                try {
                    Thread.sleep(100);
                    if (y%50==0) {
                        commonSwitch.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
