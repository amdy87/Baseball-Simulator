import java.util.ArrayList;

public class WorldSeries {
    public Association mlb;
    ArrayList<Team> left,right;
    int round = 1;
    Series[] currSeries;
    Team winner=null;


    public WorldSeries(Association mlb){
        this.mlb = mlb;
        this.left = new ArrayList<>();
        this.right = new ArrayList<>();

    }

    public void setupNextRound(){
        if(this.round == 1){
            this.currSeries = new Series[4];
            this.currSeries[0] = new Series(this.left.get(2),this.left.get(5), new int[]{1,1,1}, "AL Wildcard");
            this.currSeries[1] = new Series(this.left.get(3), this.left.get(4),new int[]{1,1,1}, "AL Wildcard");
            this.left.remove(5);
            this.left.remove(4);
            this.left.remove(3);
            this.left.remove(2);

            this.currSeries[2] = new Series(this.right.get(2),this.right.get(5),new int[]{1,1,1}, "NL Wildcard");
            this.currSeries[3] = new Series(this.right.get(3), this.right.get(4),new int[]{1,1,1}, "NL Wildcard");
            this.right.remove(5);
            this.right.remove(4);
            this.right.remove(3);
            this.right.remove(2);

        }else if(this.round == 2){
            this.currSeries = new Series[4];
            this.currSeries[0] = new Series(this.left.get(0),this.left.get(3),new int[]{1,1,2,2,1}, "AL Divisional Series");
            this.currSeries[1] = new Series(this.left.get(1), this.left.get(2), new int[]{1,1,2,2,1}, "AL Divisional Series");
            this.left.clear();

            this.currSeries[2] = new Series(this.right.get(0), this.right.get(3), new int[]{1,1,2,2,1},"NL Divisional Series");
            this.currSeries[3] = new Series(this.right.get(1),this.right.get(2),new int[]{1,1,2,2,1}, "NL Divisional Series");
            this.right.clear();
        }else if(this.round == 3){
            this.currSeries = new Series[2];
            this.currSeries[0] = new Series(this.left.get(0), this.left.get(1), new int[]{1,1,2,2,2,1,1}, "ALCS");
            this.currSeries[1] = new Series(this.right.get(0), this.right.get(1), new int[]{1,1,2,2,2,1,1}, "NLCS");
            this.right.clear();
            this.left.clear();

        }else if(this.round == 4){
            this.currSeries = new Series[1];
            if(this.right.get(0).lessThan(this.left.get(0))){
                this.currSeries[0] = new Series(this.right.get(0),this.left.get(0),new int[]{1,1,2,2,2,1,1}, "World Series");
            }else {
                this.currSeries[0] = new Series(this.left.get(0),this.right.get(0),new int[]{1,1,2,2,2,1,1}, "World Series");
            }
        }
        this.round ++;
    }

    public void seed(){
        for(Division div: mlb.leagues[0].divs){
            this.left.add(div.teamList.getFirst());
        }
        this.left = Merger.mergeAdd(new ArrayList<>(),this.left);
        int added = 0;
        for(Team team: mlb.leagues[0].getTeamList()){
            if(!this.left.contains(team)){
                this.left.add(team);
                if(added == 2){
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
                if(added == 2){
                    break;
                }else{
                    added ++;
                }
            }
        }
    }

    public void simRound(){
        for(Series series : this.currSeries){
            series.playSeries();
        }
    }

    public Team simulate(){

        //round 1 - wildcard round best of 3
        this.seed();
        System.out.println(this.toString());
        this.setupNextRound();
        this.simRound();
        this.left.add(this.currSeries[0].victor);
        this.left.add(this.currSeries[1].victor);
        this.right.add(this.currSeries[2].victor);
        this.right.add(this.currSeries[3].victor);

        //round 2 - divisional round best of 5
        this.setupNextRound();
        this.simRound();
        this.left.add(this.currSeries[0].victor);
        this.left.add(this.currSeries[1].victor);
        this.left = Merger.mergeAdd(new ArrayList<>(), this.left);
        this.right.add(this.currSeries[2].victor);
        this.right.add(this.currSeries[3].victor);
        this.right = Merger.mergeAdd(new ArrayList<>(), this.right);

        //round 3 - league championship round best of 7
        this.setupNextRound();
        this.simRound();
        this.left.add(this.currSeries[0].victor);
        this.right.add(this.currSeries[1].victor);


        //round 4 - world series best of 7
        this.setupNextRound();
        this.simRound();
        this.winner = this.currSeries[0].victor;

        System.out.println("The " + this.winner.name + " have won the World Series!");
        return this.winner;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("American League Teams\n");
        for(Team team : this.left)s.append(team);
        s.append("\nNational League Teams\n");
        for(Team team: this.right)s.append(team);
        s.append("\n");
        return s.toString();
    }
}
