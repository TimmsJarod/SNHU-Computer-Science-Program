package gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
/**
 * A simple class to hold information about a player
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a player is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Player extends Entity{

	public Player(long id, String name) {
		super(id, name);//Added super() inorder to access Entity private variables.
	}

	@Override//overloaded method customized for class
	public String toString() {
		return "Player [id=" + this.getId() + ", name=" + this.getName() + "]";
	}
}
