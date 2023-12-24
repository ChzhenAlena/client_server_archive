import controller.ClientManager;
import controller.ConsoleManager;
import model.AccessType;

public class Client {
    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();
        ConsoleManager console = new ConsoleManager();
        clientManager.start();
        AccessType access = null;
        int answer;
        while(true){
            if (access == null) {
                console.printStartMenu();
                answer = console.getNumber();
                switch (answer) {
                    case 1:
                        access = clientManager.logIn("SIGNIN");
                        break;
                    case 2:
                        clientManager.logIn("REGISTER");
                        access = AccessType.READ;
                        break;
                    case 3:
                        clientManager.exit();
                        System.exit(0);
                    default:
                        System.out.println("Такого варианта нет, введите число от 1 до 3\n");
                }
            }

            while (access == AccessType.EDIT) {
                console.printAdminMenu();
                answer = console.getNumber();
                switch (answer) {
                    case 1:
                        clientManager.show();
                        break;
                    case 2:
                        //clientManager.change();
                        break;
                    case 3:
                        clientManager.create();
                        break;
                    case 4:
                        //clientManager.delete();
                        break;
                    case 5:
                        access = null;
                        break;
                    default:
                        System.out.println("Такого варианта нет, введите число от 1 до 5\n");
                }

            }
            while (access == AccessType.READ) {
                console.printUserMenu();
                answer = console.getNumber();
                switch (answer) {
                    case 1:
                        clientManager.show();
                        break;
                    case 2:
                        access = null;
                        break;
                    default:
                        System.out.println("Такого варианта нет, введите 1 или 2\n");
                }
            }
        }
    }
}
