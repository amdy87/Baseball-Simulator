public class Team {
    public String name;
    public int rank = 0, seed = 0;
    public int win = 0, loss = 0, totWin = 0, totLos = 0;

    public Team(String name){
        this.name = name;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    public void reset(){
        this.totLos += this.loss;
        this.loss = 0;
        this.totWin += this.win;
        this.win = 0;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.rank + "\n";
    }

    public boolean lessThan(Team other){
        if(other == null) return false;
        return this.rank < other.rank;
    }

}
