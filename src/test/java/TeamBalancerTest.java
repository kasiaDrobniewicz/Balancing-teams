import org.junit.Test;

import java.util.ArrayList;

public class TeamBalancerTest {

    private TeamBalancer teamBalancer;

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionOnWrongParameter() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("Johnny", 8));
        members.add(new Member("Robbie", 5));
        members.add(new Member("Juliet", 3));
        members.add(new Member("Scarlet", 5));

        teamBalancer.balanceTeams(members,0);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldThrownIllegalArgumentExceptionOnWrongParameters() {
        ArrayList<Member> members = new ArrayList<>();
        members.add(new Member("Johnny", 8));
        members.add(new Member("Robbie", 5));
        members.add(new Member("Juliet", 3));
        members.add(new Member("Scarlet", 5));

        teamBalancer.balanceTeams(members,-1);
    }


}
