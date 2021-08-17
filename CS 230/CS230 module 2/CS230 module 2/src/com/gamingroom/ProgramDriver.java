/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXED: obtain reference to the singleton instance
		GameService service = GameService.getGameServiceInstance(); // replace null with ???
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);
		Game game2 = service.addGame("Game #1");
		System.out.println(game2);
		Game game3 = service.addGame("Game #3");
		System.out.println(game3);

		Team team1 = game1.addTeam("Tigers");
		Team team2 = game1.addTeam("Tigers");

		Player player1 = team1.addPlayer("Jeremy Buttons");

		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}
