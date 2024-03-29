public class FullTimeStudent extends Student{

    private int[] examScore;

    public FullTimeStudent() {
        examScore = new int[2];
    }

    public int[] getExamScore() {
        return examScore;
    }

    public void setExamScore(int[] examScore) {
        this.examScore = examScore;
    }
}
