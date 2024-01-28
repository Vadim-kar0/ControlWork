package View;

import java.util.List;
import java.util.Scanner;

public class UserView implements View {
    Scanner in = new Scanner(System.in);

    public int get() {
        return in.nextInt();
    };

    @Override
    public void set(String value) {
        System.out.println(value);

    }
}
