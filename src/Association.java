import java.awt.image.AreaAveragingScaleFilter;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Association {
    public String name;
    public League[] leagues;
    ArrayList<Team> teamList = new ArrayList<>();

    public Association(String name, League[] leagues){
        this.name = name;
        this.leagues = leagues;
        for(League league: this.leagues) {
            this.teamList = this.mergeAdd(this.teamList, league.getTeamList());
        }
    }

    public ArrayList<Team> mergeAdd(ArrayList<Team> teamList, ArrayList<Team> newTeamList){
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
            if(!added){
                teamList.add(newTeam);
            }

        }
        return teamList;
    }

    public ArrayList<Team> teamRank(){
        return this.teamList;
    }

    public void randomizeRank(){
        for(Team team: this.teamList){
            team.setRank((int)(Math.random()*30)+1);
        }
    }

    public void sortTeamList(){
        ArrayList<Team> sortedTeam = new ArrayList<>();
        this.teamList = this.mergeAdd(sortedTeam,this.teamList);
    }

    public void sort(){
        this.sortTeamList();
        for(League league: this.leagues){
            league.sort();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(this.name + "\n");
        for(League league: this.leagues){
            s.append("\n").append(league);
        }
        return s.toString();
    }
}
