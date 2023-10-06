import java.util.*;

public class Main {
    public static void main(String[] args) {

        ArrayList<Member> members = new ArrayList<>();

        final int numberOfTeams = 3;

        members.add(new Member("Johnny",8));
        members.add(new Member("Robbie",5));
        members.add(new Member("Juliet",3));
        members.add(new Member("Scarlet",5));
        members.add(new Member("Jude",9));
        members.add(new Member("Deborah",6));
        members.add(new Member("Steve",32));
        members.add(new Member("Scott",15));
        members.add(new Member("Kate",41));
        members.add(new Member("Matt",27));
        members.add(new Member("Ben",9));
        members.add(new Member("Diane",7));

        TeamBalancer.balanceTeams(members,numberOfTeams);
    }
}
