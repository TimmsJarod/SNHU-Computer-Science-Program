package gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/**
	 * Holds the next identifiers for Game, Player, and Team
	 */
	private static long nextGameId = 1;
	public static long nextPlayerId = 0;
	private static long nextTeamId = 0;

	/**
	The singleton pattern is used in this program to create only one constructed object of GameService at a time.
	 GameService is used to initialize a list of games, however because I have the singleton in place there can only be
	 one list.
	*/

	private static GameService newGame;

	private GameService() {}

	public static GameService getGameServiceInstance() {
		if (newGame == null) {
			newGame = new GameService();
		}
		return newGame;
	}

	/**
	 * Construct a new game instance
	 *
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		/**
		 * For my iterator, I imported the java utility package, which allows me to take an input and match it to
		 * each index location of the Games list with ease. For each check, I assign a temp variable with a game object.
		 * From there I can take the object and call its methods to match the input to see if it already exists within
		 * the list. If it does, the new object is not added to the list.
		 */

		// if found, simply return the existing instance
		Iterator<Game> gameInstance = games.iterator();

		while (gameInstance.hasNext()) {
			Game tempVar = gameInstance.next();
			if (name.equals(tempVar.getName())) {
				System.out.println("This game already exist.");

				return tempVar;
			}
		}

		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}
		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 *
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 *
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		//Instance is used with the getId method to find match or return null.
		Iterator<Game> gameInstance = games.iterator();

		while (gameInstance.hasNext()) {
			Game tempVar = gameInstance.next();
			if (id == tempVar.getId()) {
				game = tempVar;
			}

			// FIXME: Use iterator to look for existing game with same id
			// if found, simply assign that instance to the local variable
		}
			return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;
		//Instance is used with the getName method to find match or return null.
		Iterator<Game> gameInstance= games.iterator();

		while (gameInstance.hasNext()) {
			Game tempVar = gameInstance.next();
			if (name.equals(tempVar.getName())) {
				game = tempVar;
			}
		}
		// FIXME: Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}

	//Returns and increments nextPlayerID long
	public long getNextPlayerId()
	{
		++nextPlayerId;
		return nextPlayerId;
	}
	//Returns and increments nextTeamID long
	public long getNextTeamId()
	{
		++nextTeamId;
		return nextTeamId;
	}
}
