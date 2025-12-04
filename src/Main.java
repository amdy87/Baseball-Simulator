
public class Main {
    public static void main(String[] args){
        League mlb = buildLeage();

        System.out.println(mlb);
    }

    public static League buildLeage(){
        Team tbj = new Team("Toronto Blue Jays");
        Team nyy = new Team("New York Yankees");
        League alEast = new League("East",new Team[]{tbj,nyy});
        League al = new League("American League", new League[]{alEast});
        League mlb = new League("MLB", new League[]{al});

        mlb.randomizeRank();

        return mlb;
    }
}