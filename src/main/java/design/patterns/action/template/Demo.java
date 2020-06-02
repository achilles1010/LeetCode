package design.patterns.action.template;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author daixulin
 * @version : v1.0
 * @date 2020-06-02 2:48 下午 周二
 */
public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name:");
        String userName = reader.readLine().trim();;
        System.out.print("Input password:");
        String password = reader.readLine().trim();

        System.out.print("Input message: ");
        String message = reader.readLine().trim();

        System.out.println("choose social network for posting message:");
        System.out.println("1-Facebook");
        System.out.println("2-Twitter");

        int choice = Integer.parseInt(reader.readLine());

        if (choice == 1) {
            network = new Facebook(userName, password);
        } else if (choice == 2) {
            network = new Twitter(userName, password);
        }

        assert network != null;
        network.post(message);
    }
}
