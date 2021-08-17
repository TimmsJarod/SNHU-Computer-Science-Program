import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity{

	private static long nextPlayerId = 1;
	private static List<Player> players = new ArrayList<Player>();
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);//Added super() inorder to access Entity private variables.
	}

	//Adds a player to specified team object. Can have duplicates.
	public Player addPlayer(String name)
	{
		Player player = null;

		Iterator<Player> playerInstance = players.iterator();

		if (player == null) {
			player = new Player(GameService.getGameServiceInstance().getNextPlayerId(), name);
			System.out.println("Player " + name + " has been added!");
			players.add(player);
		}
		// return the new/existing player instance to the caller
		return player;
	}

	@Override//overloaded method customized for class
	public String toString() {
		return "Team [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
