package hello;

import static spark.Spark.*;

public class MainServer {

	final static Model model = new Model();

	public static void main(String[] args) {

		ProcessBuilder process = new ProcessBuilder();
		Integer port;

		if (process.environment().get("PORT") != null) {
			port = Integer.parseInt(process.environment().get("PORT"));
		} else {
			port = 1234;

		}
		port(port);

		staticFileLocation("/static");
		inicializarUsers();

		Controller controller = new Controller(model);

		controller.login();
		controller.add();
		controller.delete();
	}

	public static void inicializarUsers() {
		model.addUser(new User("arth758", "123456"));
		
	}
}
