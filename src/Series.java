public class Series {
    public Team team1, team2;
    private Game[] games;
    private int currGame = 0;
    private int vicPt;
    public Team victor;
    private String name;

    public Series(Team team1, Team team2, int[] home, String name){
        this.team1 = team1;
        this.team1.reset();
        this.team2 = team2;
        this.team2.reset();
        this.games = new Game[home.length];
        for(int i = 0;i < home.length; i ++){
            if(home[i] == 1){
                this.games[i] = new Game(team1,team2);
            }else {
                this.games[i] = new Game(team2,team1);
            }
        }
        this.vicPt =  (int)Math.ceil(this.games.length/2.0);

        this.name = name;
    }

    public Team playGame(){
        System.out.println("Game " + (this.currGame + 1));
        boolean homeWin = this.games[currGame].play();
        String s = "";
        if(homeWin) s = this.games[currGame].away.name + " @ " + this.games[currGame].home.name + " (W)";
        else s = this.games[currGame].away.name + " (W) @ " + this.games[currGame].home.name;
        System.out.println(s);
        System.out.println("Series: " + this.games[currGame].away.win + " - " + this.games[currGame].home.win + "\n");
        currGame ++;
        if(this.team1.win >= this.vicPt) {
            this.victor = this.team1;
            return this.team1;
        }else if(this.team2.win >= this.vicPt) {
            this.victor = this.team2;
            return this.team2;
        }
        return null;
    }

    public Team playSeries(){
        System.out.println(this.toString());
        for(int i = 0; i < this.games.length;i++){
            Team victor = this.playGame();
            if(victor != null){
                System.out.println("The " +victor.name + " have won the series!\n\n");
                return victor;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return this.name + ": " + this.team1.name + " vs. " + this.team2.name;
    }
}
