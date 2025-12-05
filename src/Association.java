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
            this.teamList = Merger.mergeAdd(this.teamList, league.getTeamList());
        }
    }



    public String listTeamByRank(){
        StringBuilder s = new StringBuilder(name + "\n");
        for(Team team: this.teamList){
            s.append(team);
        }
        return s.toString();
    }

    public void randomizeRank(){
        ArrayList<Team> ranked = new ArrayList<>();
        int currRank = 0;
        Team nextTeam;
        while(!this.teamList.isEmpty()){
            currRank ++;
            nextTeam = this.teamList.remove((int)(Math.random()*this.teamList.size()));
            nextTeam.rank = currRank;
            ranked.add(nextTeam);
        }
        this.teamList.addAll(ranked);
        this.sort();
    }

    public void sortTeamList(){
        ArrayList<Team> sortedTeam = new ArrayList<>();
        this.teamList = Merger.mergeAdd(sortedTeam,this.teamList);
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
