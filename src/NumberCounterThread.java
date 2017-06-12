
public class NumberCounterThread implements Runnable{

    NumberCounterThread(CommonSwitch commonSwitch){
        this.commonSwitch = commonSwitch;
    }

    CommonSwitch commonSwitch;

    @Override
    public void run() {
        synchronized (commonSwitch) {
            commonSwitch.notify();
            System.out.println(commonSwitch.set);
            while (commonSwitch.isTurnedOn()){
                System.out.println(commonSwitch.set);
                if (commonSwitch.set.size()>=100) {
                    System.out.println("Stopping!");
                    commonSwitch.setIsTurnedOff();
                }

                try {
                    commonSwitch.notify();
                    commonSwitch.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
