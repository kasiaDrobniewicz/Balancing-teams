import java.util.ArrayList;
import java.util.List;

public class Team {
    private List<Member> teamMembers;
    private int teamSize;

    private int teamRate;


    public Team(){
        this.teamSize = 0;
        this.teamRate = 0;
        this.teamMembers = new ArrayList<>();
    }
    public void addMember (Member member) {
        teamMembers.add(member);
        teamSize++;
        teamRate = teamRate + member.getRate();
    }

    public List<Member> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(List<Member> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void setTeamSize(int teamSize) {
        this.teamSize = teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }

    public int getTeamRate() {
        return teamRate;
    }

    public void setTeamRate(int teamRate) {
        this.teamRate = teamRate;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamMembers=" + teamMembers +
                ", teamSize=" + teamSize +
                ", teamRate=" + teamRate +
                '}';
    }

    public String printableListOfNames() {
        String printableListOfNames = "";
        for(Member member : teamMembers){
            printableListOfNames = printableListOfNames + member.getName() + ", ";
        }
        printableListOfNames = printableListOfNames.substring(0, printableListOfNames.length()-2);
        return printableListOfNames;
    }

    public double averageTeamRate() {
        return Math.round(this.teamRate / teamSize);
    }
}
