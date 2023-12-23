import controller.ServerManager;

public class Server {
    public static void main(String[] args) {
        ServerManager serverManager = new ServerManager();
        serverManager.start();

        String[] command;
        while (true){
            command = serverManager.receiveMessage();
            switch (command[0]){
                case "SIGNIN":
                    serverManager.signIn(command[1], command[2]);
                    break;
                case "REGISTER":
                    serverManager.register(command[1], command[2]);
                    break;

                case "EXIT":
                    serverManager.close();
                    break;
            }
        }
    }
}
