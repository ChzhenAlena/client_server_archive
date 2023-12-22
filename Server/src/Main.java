import controller.Server;

public class Main {
    public static void main(String[] args) {
        Server server = new Server();
        server.start();

        String command = "";
        while (true){
            switch (command){
                case "LOGIN": //server.login();
                                break;
                default:
                    break;
            }
        }
    }
}
