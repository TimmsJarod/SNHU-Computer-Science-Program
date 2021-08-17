package gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity{

	private static long nextTeamId = 1;
	private static List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);//Added super() inorder to access Entity private variables.
	}

	//Adds team to game instance. While loop checks and blocks current game for identical team names.
	public Team addTeam(String name)
	{
		Team team = null;

		Iterator<Team> teamInstance = teams.iterator();

		while (teamInstance.hasNext()) {
			Team tempVar = teamInstance.next();
			if (name.equals(tempVar.getName())) {
				System.out.println("This team already exist.");

				return tempVar;
			}
		}

		// if not found, make a new player instance and add to list of games
		if (team == null) {
			team = new Team(nextTeamId++, name);
			System.out.println("Team " + name + " has been added!");
			teams.add(team);
		}
		// return the new/existing player instance to the caller
		return team;
	}

	@Override//overloaded method customized for class.
	public String toString() {
		
		return "Game [id=" + this.getId() + ", name=" + this.getName() + "]";
	}

}
