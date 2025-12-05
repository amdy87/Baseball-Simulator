
public class Main {
    public static void main(String[] args){
        Association mlb = buildMLB();
        mlb.randomizeRank();
        System.out.println(mlb.listTeamByRank());
        Team home = mlb.teamList.get(0);
        Team away = mlb.teamList.get(1);
        Series series = new Series(home,away,new int[]{1,2,2,2,1,1,1});
        series.playSeries();
    }

    public static Association buildMLB(){
        Association mlb = new Association("MLB", new League[]{
            new League("American League", new Division[]{
                new Division("East",new Team[]{
                    new Team("New York Yankees"),
                    new Team("Toronto Blue Jays"),
                    new Team("Boston Red Sox"),
                    new Team("Tampa Bay Rays"),
                    new Team("Baltimore Orioles")
                }),
                new Division("Central",new Team[]{
                    new Team("Cleveland Guardians"),
                    new Team("Detroit Tigers"),
                    new Team("Kansas City Royals"),
                    new Team("Minnesota Twins"),
                    new Team("Chicago White Sox")
                }),
                new Division("West",new Team[]{
                    new Team("Seattle Mariners"),
                    new Team("Houston Astros"),
                    new Team("Texas Rangers"),
                    new Team("Athletics"),
                    new Team("Los Angeles Angels")
                })}),
            new League("National League", new Division[]{
                new Division("East", new Team[]{
                    new Team("Philadelphia Phillies"),
                    new Team("New York Mets"),
                    new Team("Miami Marlins"),
                    new Team("Atlanta Braves"),
                    new Team("Washington Nationals")
                    }),
                new Division("Central", new Team[]{
                    new Team("Milwaukee Brewers"),
                    new Team("Chicago Cubs"),
                    new Team("Cincinnati Reds"),
                    new Team("St. Louis Cardinals"),
                    new Team("Pittsburgh Pirates")
                }),
                new Division("West", new Team[]{
                    new Team("Los Angeles Dodgers"),
                    new Team("San Diego Padres"),
                    new Team("San Francisco Giants"),
                    new Team("Arizona Diamondbacks"),
                    new Team("Colorado Rockies")
                })
                })});

        return mlb;
    }
}