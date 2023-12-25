import controller.ServerManager;

public class Server {
    public static void main(String[] args) {
        ServerManager serverManager = new ServerManager();
        serverManager.startServer();
        serverManager.connect();
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
                case "SHOW":
                    serverManager.sendStudent(command[1]);
                    break;
                case "CREATE":
                    serverManager.createStudent();
                    break;
                case "CHANGE":
                    serverManager.changeStudent(command[1]);
                    break;
                case "DELETE":
                    serverManager.deleteStudent(command[1]);
                    break;

                case "EXIT":
                    serverManager.disconnect();
                    System.out.println("В ожидании клиента");
                    serverManager.connect();
                    break;
            }
        }
    }
}
