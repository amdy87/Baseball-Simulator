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


    public void sort(){
        ArrayList<Team> newList = new ArrayList<>();
        this.teamList = Merger.mergeAdd(newList,this.teamList);
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
