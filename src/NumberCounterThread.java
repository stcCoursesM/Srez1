
public class NumberCounterThread implements Runnable{

    NumberCounterThread(CommonSwitch commonSwitch){
        this.commonSwitch = commonSwitch;
    }

    CommonSwitch commonSwitch;

    @Override
    public void run() {
        synchronized (commonSwitch) {
            commonSwitch.notify();
            System.out.println(commonSwitch.isTurnedOn());
            while (commonSwitch.isTurnedOn()){
                System.out.println(commonSwitch.set);
                if (commonSwitch.set.size()>=100) {
                    commonSwitch.setIsTurnedOff();
                    System.out.println("Stopping!");
                }

                try {
                    commonSwitch.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
