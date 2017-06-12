
public class NumberCounterThread implements Runnable{

    NumberCounterThread(CommonSwitch commonSwitch){
        this.commonSwitch = commonSwitch;
    }

    CommonSwitch commonSwitch;

    @Override
    public void run() {
        synchronized (commonSwitch) {
            while (commonSwitch.isTurnedOn()){
                System.out.println(commonSwitch.set.isEmpty());
                if (commonSwitch.set.size()>=10) {
                    commonSwitch.setIsTurnedOff();
                    System.out.println("Stopping!");
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
