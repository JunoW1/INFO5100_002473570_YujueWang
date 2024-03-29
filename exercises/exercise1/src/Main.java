import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Main {
    public static void main(String[] args) {


        Session session = new Session();
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            FullTimeStudent f = new FullTimeStudent();
            f.setName(generateName());
            f.setQuizzScore(new int[15]);
            Random random = new Random();
            int[] quizScore = f.getQuizzScore();
            for(int j = 0; j < 15; j++) {
                quizScore[j] = random.nextInt(40) + 60;
            }
            f.setExamScore(new int[2]);
            int[] examScore = f.getExamScore();
            for(int j = 0; j < 2; j++) {
                examScore[j] = random.nextInt(40) + 60;
            }
            students.add(f);
        }

        for (int i = 0; i < 10; i++) {
            PartTimeStudent p = new PartTimeStudent();
            p.setName(generateName());
            p.setPartTime(true);
            Random random = new Random();
            p.setQuizzScore(new int[15]);
            int[] quizScore = p.getQuizzScore();
            for(int j = 0; j < 15; j++) {
                quizScore[j] = random.nextInt(40) + 60;
            }
            students.add(p);
        }
        session.setStudents(students);
        System.out.println(session.calculateAverage(10));

        session.printExamScore();

    }

    public static String generateName() {
        byte[] array = new byte[5];
        new Random().nextBytes(array);
        return new String(array, Charset.forName("UTF-8"));
    }

}