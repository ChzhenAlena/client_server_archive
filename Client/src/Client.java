import controller.ClientManager;
import controller.ConsoleManager;
import model.AccessType;
import model.User;

public class Client {
    public static void main(String[] args) {
        ClientManager clientManager = new ClientManager();
        ConsoleManager console = new ConsoleManager();
        clientManager.start();
        model.User user = null;
        int answer;
        while(true){
            if (user == null) {
                console.printStartMenu();
                answer = console.getNumber();
                switch (answer) {
                    case 1:
                        clientManager.logIn(user);
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

            while ((user != null) && (user.getAccessType() == AccessType.EDIT)) {
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
            while ((user != null) && (user.getAccessType() == AccessType.READ)) {
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
