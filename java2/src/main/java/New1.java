import java.util.Scanner;

public class New1 {
    public static void main(String[] args) {

        int row = 5;
        int col = 6;
        for (int i = 0; i < row; i++) {
            int j=i*col+1;
            for (; j <= (i+1)*col; j++) {
                System.out.print(j + " ");
            }
            System.out.print("\n");
        }
    }
}
