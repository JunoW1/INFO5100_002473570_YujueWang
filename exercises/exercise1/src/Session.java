import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Session {

    private List<Student> students;

    public void Session() {
        students = new ArrayList<>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudents(Student student) {
        this.students.add(student);
    }

    public Integer calculateAverage(int quizCount) {
        int headCount = students.size();
        int sum = 0;
        for(Student s : students) {
            int[] quizScore = s.getQuizzScore();
            quizCount = quizCount > 15 ? 15 : quizCount;
            for (int i = 0; i < quizCount; i++) {
                sum += quizScore[i];
            }
        }
        return sum / quizCount / headCount;
    }

    public void printExamScore() {
        for(Student s : students) {
            if(!s.isPartTime()) {
                FullTimeStudent f = (FullTimeStudent) s;
                System.out.println(f.getName() + "  " + Arrays.toString(f.getExamScore()));
            }
        }
    }

}
