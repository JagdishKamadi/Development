import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 1;

        while (choice <= 5) {
            String string = sc.nextLine();
            String maskedString = "*".repeat(16);
            switch (string.length()) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    maskedString = getMaskString(string, 0, 1);
                    break;
                case 8:
                    maskedString = getMaskString(string, 0, 2);
                    break;
                case 9:
                    maskedString = getMaskString(string, 0, 3);
                    break;
                case 10:
                    maskedString = getMaskString(string, 0, 4);
                    break;
                case 11:
                    maskedString = getMaskString(string, 1, 4);
                    break;
                case 12:
                    maskedString = getMaskString(string, 2, 4);
                    break;
                case 13:
                    maskedString = getMaskString(string, 3, 4);
                    break;
                case 14:
                    maskedString = getMaskString(string, 4, 4);
                    break;
                case 15:
                    maskedString = getMaskString(string, 5, 4);
                    break;
                case 16:
                    maskedString = getMaskString(string, 6, 4);
                    break;
                case 17:
                    maskedString = getMaskString(string, 6, 4);
                    break;
                case 18:
                    maskedString = getMaskString(string, 6, 4);
                    break;

                default:
                    maskedString = getMaskString(string, 6, 4);
                    break;
            }
            System.out.println("Masked String : " + maskedString);
            choice++;
        }
    }

    private static String getMaskString(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < start; i++) {
            sb.append(str.charAt(i));
        }

        if (str.length() == 17) {
            sb.append("*".repeat(16 - (end + start) + 1));
        } else if (str.length() == 18) {
            sb.append("*".repeat(16 - (end + start) + 2));
        } else if (str.length() >= 19) {
            sb.append("*".repeat(16 - (end + start) + 3));
        } else {
            sb.append("*".repeat(16 - (end + start)));
        }

        for (int i = str.length() - end; i < str.length(); i++) {
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }


}
