public class Student {
    private String name;

    private int[] quizzScore;

    private boolean isPartTime;

    public boolean isPartTime() {
        return isPartTime;
    }

    public void setPartTime(boolean partTime) {
        isPartTime = partTime;
    }

    public void Student() {
        quizzScore = new int[15];
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getQuizzScore() {
        return quizzScore;
    }

    public void setQuizzScore(int[] quizzScore) {
        this.quizzScore = quizzScore;
    }
}
