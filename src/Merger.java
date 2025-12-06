import java.util.ArrayList;

public class Merger {

    public static ArrayList<Team> mergeAdd(ArrayList<Team> teamList, ArrayList<Team> newTeamList){
        for (Team newTeam : newTeamList) {
            if (teamList.isEmpty()) {
                teamList.add(newTeam);
                continue;
            }
            boolean added = false;
            for (int j = 0; j < teamList.size(); j++) {
                if (!teamList.get(j).lessThan(newTeam)) {
                    teamList.add(j, newTeam);
                    added = true;
                    break;
                }
            }
            if(!added){
                teamList.add(newTeam);
            }

        }
        return teamList;
    }
}
