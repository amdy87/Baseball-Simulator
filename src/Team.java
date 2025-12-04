public class Team {
    public String name;
    public int rank = 0;

    public Team(){}

    public Team(String name){
        this.name = name;
    }

    public void setRank(int rank){
        this.rank = rank;
    }

    @Override
    public String toString(){
        return this.name + " - " + this.rank + "\n";
    }
}
