import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamBalancer {
    private static List<Member> allMembers;
    private static int numberOfTeams;
    private static int teamsSize;

    public TeamBalancer(List<Member> allMembers, int numberOfTeams) {
        this.allMembers = allMembers;
        this.numberOfTeams = numberOfTeams;


    }

    public static void balanceTeams(List<Member> allMembers, int numberOfTeams) {

        List<Team> finalListOfTeams = new ArrayList<>();
        List<Member> allSortedMembers = sortAllMembers(allMembers);
        List<Team> listOfTeams = new ArrayList<>(numberOfTeams);
        if (numberOfTeams == 0) {
            throw new IllegalArgumentException("Invalid numbers of teams");
        }
        if (allMembers.size() % numberOfTeams != 0) {
            throw new IllegalArgumentException("Invalid numbers od members");
        }
        teamsSize = allMembers.size() / numberOfTeams;

        for (int i = 0; i < numberOfTeams; i++) {
            listOfTeams.add(new Team());
            listOfTeams.get(i).addMember(allSortedMembers.get(allSortedMembers.size() - 1));
            allSortedMembers.remove(allSortedMembers.size() - 1);
        }

        while (!allSortedMembers.isEmpty()) {
            int minTeamIndex = findMinTeamRate(listOfTeams);
            listOfTeams.get(minTeamIndex).addMember(allSortedMembers.get(allSortedMembers.size() - 1));
            allSortedMembers.remove(allSortedMembers.size() - 1);
            if (listOfTeams.get(minTeamIndex).getTeamSize() == teamsSize) {
                finalListOfTeams.add(listOfTeams.get(minTeamIndex));
                listOfTeams.remove(minTeamIndex);
            }

        }
        printTeams(finalListOfTeams);
    }
    private static List<Member> sortAllMembers (List < Member > allMembers) {
        Collections.sort(allMembers, new SortByRate());

        for (int i = 0; i < allMembers.size(); i++) {
        }
        return allMembers;
    }

    public static int findMinTeamRate (List < Team > listOfTeams){
        int minTeamIndex = 0;
        int minTeamRate = listOfTeams.get(0).getTeamRate();
        for (int i = 1; i < listOfTeams.size(); i++) {
            if (listOfTeams.get(i).getTeamRate() < minTeamRate) {
                minTeamRate = listOfTeams.get(i).getTeamRate();
                minTeamIndex = i;
            }
        }
        return minTeamIndex;
    }

    public static double calculateStandardDeviation(List<Team> listOfTeams) {
        double sumOfRates = 0.0;
        double sumOfAverageRates = 0.0;
        double meanOfAverageRates;
        double standardDeviation = 0.0;

        for(int i = 0; i < listOfTeams.size(); i++){
            sumOfAverageRates += listOfTeams.get(i).getTeamRate()/teamsSize;
        }
        meanOfAverageRates = sumOfAverageRates / listOfTeams.size();

        for (Team team : listOfTeams) {
            double teamAverageRate = team.getTeamRate()/team.getTeamSize();
            standardDeviation += Math.pow(teamAverageRate - meanOfAverageRates, 2);
        }

        return Math.sqrt(standardDeviation / listOfTeams.size());
    }

    public static void printTeams(List<Team> finalListOfTeams){
        for(int i = 0; i < finalListOfTeams.size(); i ++){
            System.out.println("Team no " + (i + 1) + " has " + finalListOfTeams.get(i).getTeamSize()
                    + " players (" + (finalListOfTeams.get(i).printableListOfNames()) + "). Average rate: "
                    + finalListOfTeams.get(i).averageTeamRate());
        }
        System.out.println("Teams rate standard deviation: " + calculateStandardDeviation(finalListOfTeams) );
    }
}

