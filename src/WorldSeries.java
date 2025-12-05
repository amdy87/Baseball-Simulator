import java.util.ArrayList;

public class WorldSeries {
    public Association mlb;
    private int numTeams = 12;
    ArrayList<Team> left,right;

    public WorldSeries(Association mlb, boolean ranked){
        if(!ranked){
            mlb.randomizeRank();
        }
        this.mlb = mlb;
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();

        for(Division div: mlb.leagues[0].divs){
            this.left.add(div.teamList.getFirst());
        }
        this.left = Merger.mergeAdd(new ArrayList<>(),this.left);
        int added = 0;
        for(Team team: mlb.leagues[0].getTeamList()){
            if(!this.left.contains(team)){
                this.left.add(team);
                if(added == 1){
                    break;
                }else{
                    added ++;
                }
            }
        }

        for(Division div: mlb.leagues[1].divs){
            this.right.add(div.teamList.getFirst());
        }
        this.right = Merger.mergeAdd(new ArrayList<>(),this.right);
        added = 0;
        for(Team team: mlb.leagues[1].getTeamList()){
            if(!this.right.contains(team)){
                this.right.add(team);
                if(added == 1){
                    break;
                }else{
                    added ++;
                }
            }
        }

    }
}
