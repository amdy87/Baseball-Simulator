import java.util.ArrayList;
import java.util.Arrays;

public class Division {
    public String name;
    public ArrayList<Team> teamList = new ArrayList<>();

    public Division(String name,Team[] teams){
        this.name = name;
        this.teamList.addAll(Arrays.asList(teams));
    }

    public ArrayList<Team> getTeams(){
        return this.teamList;
    }

    public ArrayList<Team> mergeAdd(ArrayList<Team> teamList, ArrayList<Team> newTeamList) {
        for (Team newTeam : newTeamList) {
            if (teamList.isEmpty()) {
                teamList.add(newTeam);
                continue;
            }
            boolean added = false;
            for (int j = 0; j < teamList.size(); j++) {
                if (!teamList.get(j).compareTo(newTeam)) {
                    teamList.add(j, newTeam);
                    added = true;
                    break;
                }
            }
            if (!added) {
                teamList.add(newTeam);
            }

        }
        return teamList;
    }

    public void sort(){
        ArrayList<Team> newList = new ArrayList<>();
        this.teamList = this.mergeAdd(newList,this.teamList);
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(this.name + "\n");
        for(Team team: this.teamList){
            s.append(team);
        }
        return s.toString();
    }
}
