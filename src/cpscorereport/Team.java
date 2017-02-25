package cpscorereport;

import java.util.ArrayList;

public class Team implements Comparable {

    private String myTeamName;
    private ArrayList<Score> myWindows1Scores;
    private String myWin1Name;
    private ArrayList<Score> myWindows2Scores;
    private String myWin2Name;
    private ArrayList<Score> myWindows3Scores;
    private String myWin3Name;
    private ArrayList<Score> myLinux1Scores;
    private String myLin1Name;
    private ArrayList<Score> myLinux2Scores;
    private String myLin2Name;
    private ArrayList<Score> myLinux3Scores;
    private String myLin3Name;

    public Team(ArrayList<Score> scores, String name, String OS) {
        if (OS.toLowerCase().contains("win")) {
            myWindows1Scores = scores;
            myWin1Name = OS;
        } else {
            myLinux1Scores = scores;
            myLin1Name = OS;
        }
        myTeamName = name;
    }

    public Team(String name) {
        myTeamName = name;
    }

    public Team(String name, Score starting, String OS) {
        if (OS.toLowerCase().contains("win")) {
            myWindows1Scores = new ArrayList<>();
            myWindows1Scores.add(starting);
            myWin1Name = OS;
        } else {
            myLinux1Scores = new ArrayList<>();
            myLinux1Scores.add(starting);
            myLin1Name = OS;
        }
        myTeamName = name;
    }

    public void addScore(Score toAdd, String OS) {
        if (OS.toLowerCase().contains("win")) {
            if (myWin1Name != null && OS.equals(myWin1Name)) {
                myWindows1Scores.add(toAdd);
            } else if (myWin2Name != null && OS.equals(myWin2Name)) {
                myWindows2Scores.add(toAdd);
            } else if (myWin3Name != null && OS.equals(myWin3Name)) {
                myWindows3Scores.add(toAdd);
            } else if (myWin1Name == null) {
                myWindows1Scores = new ArrayList<>();
                myWindows1Scores.add(toAdd);
                myWin1Name = OS;
            } else if (myWin2Name == null) {
                myWindows2Scores = new ArrayList<>();
                myWindows2Scores.add(toAdd);
                myWin2Name = OS;
            } else if (myWin3Name == null) {
                myWindows3Scores = new ArrayList<>();
                myWindows3Scores.add(toAdd);
                myWin3Name = OS;
            }
        } else if (OS.toLowerCase().contains("lin")) {
            if (myLin1Name != null && OS.equals(myLin1Name)) {
                myLinux1Scores.add(toAdd);
            } else if (myLin2Name != null && OS.equals(myLin2Name)) {
                myLinux2Scores.add(toAdd);
            } else if (myLin3Name != null && OS.equals(myLin3Name)) {
                myLinux3Scores.add(toAdd);
            } else if (myLin1Name == null) {
                myLinux1Scores = new ArrayList<>();
                myLinux1Scores.add(toAdd);
                myLin1Name = OS;
            } else if (myLin2Name == null) {
                myLinux2Scores = new ArrayList<>();
                myLinux2Scores.add(toAdd);
                myLin2Name = OS;
            } else if (myLin3Name == null) {
                myLinux3Scores = new ArrayList<>();
                myLinux3Scores.add(toAdd);
                myLin3Name = OS;
            }
        }
    }

    public ArrayList<Score> getWin1Scores() {
        return myWindows1Scores;
    }

    public ArrayList<Score> getWin2Scores() {
        return myWindows2Scores;
    }

    public ArrayList<Score> getWin3Scores() {
        return myWindows3Scores;
    }

    public ArrayList<Score> getLin1Scores() {
        return myLinux1Scores;
    }

    public ArrayList<Score> getLin2Scores() {
        return myLinux2Scores;
    }

    public ArrayList<Score> getLin3Scores() {
        return myLinux3Scores;
    }

    public ArrayList<ArrayList<Score>> getScores(){
        ArrayList<ArrayList<Score>> allScores = new ArrayList<>(this.getTotalOS());
        if (myWindows1Scores != null){
            allScores.add(myWindows1Scores);
        }
        if (myWindows2Scores != null){
            allScores.add(myWindows2Scores);
        }
        if (myWindows3Scores != null){
            allScores.add(myWindows3Scores);
        }
        if (myLinux1Scores != null){
            allScores.add(myLinux1Scores);
        }
        if (myLinux2Scores != null){
            allScores.add(myLinux2Scores);
        }
        if (myLinux3Scores != null){
            allScores.add(myLinux3Scores);
        }
        return allScores;
    }
    
    public ArrayList<String> getOSes(){
        ArrayList<String> allScores = new ArrayList<>(this.getTotalOS());
        if (myWin1Name != null){
            allScores.add(myWin1Name);
        }
        if (myWin2Name != null){
            allScores.add(myWin2Name);
        }
        if (myWin3Name != null){
            allScores.add(myWin3Name);
        }
        if (myLin1Name != null){
            allScores.add(myLin1Name);
        }
        if (myLin2Name != null){
            allScores.add(myLin2Name);
        }
        if (myLin3Name != null){
            allScores.add(myLin3Name);
        }
        return allScores;
    }
    
    public String getTeamName() {
        return myTeamName;
    }

    public Score getLatestWin1Score() {
        if (myWindows1Scores == null) {
            return null;
        }
        return myWindows1Scores.get(myWindows1Scores.size() - 1);
    }

    public Score getLatestWin2Score() {
        if (myWindows2Scores == null) {
            return null;
        }
        return myWindows2Scores.get(myWindows2Scores.size() - 1);
    }

    public Score getLatestWin3Score() {
        if (myWindows3Scores == null) {
            return null;
        }
        return myWindows3Scores.get(myWindows3Scores.size() - 1);
    }

    public Score getLatestLin1Score() {
        if (myLinux1Scores == null) {
            return null;
        }
        return myLinux1Scores.get(myLinux1Scores.size() - 1);
    }

    public Score getLatestLin2Score() {
        if (myLinux2Scores == null) {
            return null;
        }
        return myLinux2Scores.get(myLinux2Scores.size() - 1);
    }

    public Score getLatestLin3Score() {
        if (myLinux3Scores == null) {
            return null;
        }
        return myLinux3Scores.get(myLinux3Scores.size() - 1);
    }
    
    public int getTotalOS() {
        int total = 0;
        if (myWin1Name != null) {
            total++;
        }
        if (myWin2Name != null) {
            total++;
        }
        if (myWin3Name != null) {
            total++;
        }
        if (myLin1Name != null) {
            total++;
        }
        if (myLin2Name != null) {
            total++;
        }
        if (myLin3Name != null) {
            total++;
        }
        return total;
    }

    @Override
    public String toString() {
        return myTeamName;
    }

    @Override
    public int compareTo(Object other) {
        Score otherTeam = ((Team) other).getLatestWin1Score();
        return this.getLatestWin1Score().getScore() - otherTeam.getScore();
    }
}
