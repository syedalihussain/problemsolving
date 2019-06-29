package O.Quantifi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Friend {
	private Collection<Friend> friends;
	private String email;

	public Friend(String email) {
		this.email = email;
		this.friends = new ArrayList<Friend>();
	}

	public String getEmail() {
		return email;
	}

	public Collection<Friend> getFriends() {
		return friends;
	}

	public void addFriendship(Friend friend) {
		friends.add(friend);
		friend.getFriends().add(this);
	}

	public boolean canBeConnected(Friend friend) {
		return findPathBiBFS(this, friend);
	}

	private boolean findPathBiBFS(Friend source, Friend dest) {
		BFSData sourceData = new BFSData(source);
		BFSData destData = new BFSData(dest);

		while (!sourceData.isFinished() && !destData.isFinished()) {
			Friend collision = searchLevel(sourceData, destData);
			if (collision != null)
				return true;

			collision = searchLevel(destData, sourceData);
			if (collision != null)
				return true;
		}

		return false;
	}

	private Friend searchLevel(BFSData sourceData, BFSData destData) {
		int count = sourceData.toVisit.size();

		for (int i = 0; i < count; i++) {

			Friend currentFriend = sourceData.toVisit.remove();
			if (destData.visited.contains(currentFriend))
				return currentFriend;

			sourceData.visited.add(currentFriend);
			//	Add friends to queue
			ArrayList<Friend> friends = (ArrayList<Friend>) currentFriend.getFriends();
			for (Friend friend : friends) {
				if (!sourceData.visited.contains(friend)) {
					sourceData.toVisit.add(friend);
				}
			}

		}

		return null;
	}

	public static void main(String[] args) {
		Friend a = new Friend("A");
		Friend b = new Friend("B");
		Friend c = new Friend("C");

		a.addFriendship(b);
		c.addFriendship(b);

		System.out.println(a.canBeConnected(c));
	}

	private class BFSData {
		Queue<Friend> toVisit;
		HashSet<Friend> visited;
		public BFSData(Friend friend) {
			toVisit = new LinkedList<>();
			toVisit.addAll(friend.getFriends());
			visited = new HashSet<>();
			visited.add(friend);
		}

		public boolean isFinished() {
			return toVisit.isEmpty();
		}
	}
}
