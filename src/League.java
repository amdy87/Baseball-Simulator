import java.util.ArrayList;

public class League {
    public String name;
    public Division[] divs;
    public ArrayList<Team> teamList = new ArrayList<>();

    public League(String name, Division[] divs){
        this.name = name;
        this.divs = divs;
        for(Division div: divs){
            Merger.mergeAdd(this.teamList,div.getTeams());
        }
    }

    public ArrayList<Team> getTeamList(){
        return this.teamList;
    }



    public ArrayList<Team> teamRank(){
        return this.teamList;
    }

    public void sortTeamList(){
        ArrayList<Team> sortedTeam = new ArrayList<>();
        this.teamList = Merger.mergeAdd(sortedTeam,this.teamList);
    }

    public void sort(){
        this.sortTeamList();
        for(Division div: this.divs){
            div.sort();
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder(this.name + "\n");
        for(Division div: this.divs){
            s.append("\n").append(div);
        }
        return s.toString();
    }
}
