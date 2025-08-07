
public class GradeStatisticsSystem {
    public static void main(String[] args) {
        int[] grades = {85, 92, 78, 96, 87, 73, 89, 94, 82, 90};

        int max = grades[0], min = grades[0], sum = 0;
        int[] levels = new int[5]; // A B C D F

        for (int g : grades) {
            max = Math.max(max, g);
            min = Math.min(min, g);
            sum += g;

            if (g >= 90) levels[0]++;        // A
            else if (g >= 80) levels[1]++;   // B
            else if (g >= 70) levels[2]++;   // C
            else if (g >= 60) levels[3]++;   // D
            else levels[4]++;                // F
        }

        double avg = sum / (double) grades.length;
        int aboveAvg = 0;
        for (int g : grades) if (g > avg) aboveAvg++;

        System.out.println("平均: " + avg);
        System.out.println("最高: " + max);
        System.out.println("最低: " + min);
        System.out.println("等第統計: A=" + levels[0] + ", B=" + levels[1] + ", C=" + levels[2] + ", D=" + levels[3] + ", F=" + levels[4]);
        System.out.println("高於平均的人數: " + aboveAvg);
    }
}