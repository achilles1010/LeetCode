package design.patterns.action.template;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 2:48 下午 周二
 */
public class Facebook extends Network {
    public Facebook(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public boolean logIn(String userName, String password) {
        System.out.println("checking user`s parameters");
        System.out.println(("name:" + this.userName));
        System.out.println("password:" + password);

        this.simulateNetworkLatency();

        System.out.println("logIn success on Facebook");
        return true;
    }

    @Override
    public boolean sendData(byte[] data) {
       boolean messagePosted = true;
       if (messagePosted) {
           System.out.println("Message:'" + new String(data) + "' was posted on Facebook");
           return true;
       } else {
           return false;
       }
    }

    @Override
    public void logOut () {
        System.out.println("User :'" + this.userName + "' was logged out from Facebook");
    }

    private void simulateNetworkLatency() {
        int i = 0;
        System.out.println();
        while (i < 10) {
            System.out.println(".");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i++;
        }
    }
}
