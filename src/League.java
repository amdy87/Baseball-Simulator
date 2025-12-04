import java.lang.reflect.Array;
import java.util.ArrayList;

public class League {
    public Team[] teams;
    public String name;
    public League[] children;

    public League(){}

    public League(String name, Team[] teams){
        this.teams = teams;
        this.name = name;
    }

    public League(String name,League[] children){
        this.name = name;
        this.children = children;
    }

    private ArrayList<Team> getTeams(){
        ArrayList<Team> teams = new ArrayList<Team>();
        if(this.children != null){
            for(int i = 0; i < this.children.length; i ++){
                teams.addAll(this.children[i].getTeams());
            }
        }else {
            for(int i = 0;i < this.teams.length; i ++){
                teams.add(this.teams[i]);
            }
        }
        return teams;
    }

    public void randomizeRank(){
        ArrayList<Team> unranked = this.getTeams();
        int rank = 1;
        Team nextTeam;
        while(!unranked.isEmpty()) {
            nextTeam = unranked.remove((int)(Math.random()*unranked.size()));
            nextTeam.setRank(rank);
            rank ++;
        }

    }

    public String toString(){
        String s = this.name + "\n";
        if(this.children != null){
            for(int i = 0;i < this.children.length;i ++){
                s += this.children[i];
            }
        } else {
            for(int i = 0;i < this.teams.length;i ++){
                s += this.teams[i];
            }
        }
        return s;
    }

}
