import controller.ClientManager;
import controller.ConsoleManager;
import model.AccessType;
import model.User;

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
                        access = clientManager.signIn();
                        break;
                    case 2:
                        //clientManager.register();
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Такого варианта нет, введите заново\n");
                }
            }

            while (access == AccessType.EDIT) {
                console.printAdminMenu();
                answer = console.getNumber();
                switch (answer) {
                    case 1:
                        //clientManager.show();
                        break;
                    case 2:
                        //clientManager.change();
                        break;
                    case 3:
                        //clientManager.create();
                        break;
                    case 4:
                        //clientManager.delete();
                        break;
                    case 5:
                        //user = clientManager.logOut();
                        break;
                    default:
                        System.out.println("Такого варианта нет, введите заново\n");
                }

            }
            while (access == AccessType.READ) {
                console.printUserMenu();
                answer = console.getNumber();
                switch (answer) {
                    case 1:
                        //clientManager.show();
                        break;
                    case 2:
                        //user = clientManager.logOut();
                        break;
                    default:
                        System.out.println("Такого варианта нет, введите заново\n");
                }
            }
        }
    }
}
