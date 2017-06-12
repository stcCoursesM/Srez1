
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


                int i = ((int) (Math.random() * 100));
                commonSwitch.set.add(i);
                y++;
                System.out.println(commonSwitch.set.size());
                try {
                    Thread.sleep(10);
                    if (y%50==0) {
                        commonSwitch.notify();
                        commonSwitch.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
