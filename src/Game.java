public class Game {
    public Team home, away;
    public Game(Team home, Team away){
        this.home = home;
        this.away = away;
    }

    public boolean play(){
        int victor = (int)(Math.random()*2);
        if(victor == 1){
            this.home.win ++;
            this.away.loss ++;
            return true;
        }
        this.home.loss ++;
        this.away.win ++;
        return false;
    }
}
