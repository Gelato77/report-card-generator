import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        float marks[] = new float[5];
        String subjects[] = new String[]{"Math", "Science", "English", "Computer Science", "Spanish"};
        float total=0, avg;
        String sName = "";
        String name = "";
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Name of School:");
        sName = scanner.nextLine();
        System.out.print("Enter Name of Student:");
        name = scanner.nextLine();

        for(int i=0; i<5; i++) {
            boolean correct = true;
            while (correct){
                System.out.print("Enter Mark for "+subjects[i]+":");
                float in = scanner.nextFloat();
                if (in > 0 && in < 110){
                    marks[i] = in;
                    total = total + marks[i];
                    correct = false;
                }
                else {
                    System.out.println("Incorrect mark, Please enter correct mark.");
                }
            }
        }
        scanner.close();
        //Calculating average here
        avg = total/5;
        String grade = "";
        if(avg>=95)
        {
            grade = "A+";
        }
        else if(avg>=90 && avg<95)
        {
            grade = "A";
        }
        else if(avg>=80 && avg<90)
        {
            grade = "B";
        }
        else if(avg>=70 && avg<80)
        {
            grade = "C";
        }
        else if(avg>=60 && avg<70)
        {
            grade = "D";
        }
        else
        {
            grade = "F";
        }

        // Print Report Card Here
        List<List<String>> rows = new ArrayList<>();
        System.out.println("\t\t"+sName+"\t\t");
        System.out.println("\t\t"+name+"\t\t");
        List<String> headers = Arrays.asList("Subjects", "Marks");
        rows.add(headers);
        for (int i = 0; i < subjects.length;i++) {
            rows.add(Arrays.asList(subjects[i], String.valueOf(marks[i])+"%"));
        }
        System.out.println(formatAsTable(rows));
        System.out.println("Marks Total:\t\t"+total);
        System.out.println("Average %:\t\t"+avg+"%");
        System.out.println("Final Grade:\t\t"+grade);
    }
    public static String formatAsTable(List<List<String>> rows)
    {
        int[] maxLengths = new int[rows.get(0).size()];
        for (List<String> row : rows)
        {
            for (int i = 0; i < row.size(); i++)
            {
                maxLengths[i] = Math.max(maxLengths[i], row.get(i).length());
            }
        }

        StringBuilder formatBuilder = new StringBuilder();
        for (int maxLength : maxLengths)
        {
            formatBuilder.append("%-").append(maxLength + 2).append("s");
        }
        String format = formatBuilder.toString();

        StringBuilder result = new StringBuilder();
        for (List<String> row : rows)
        {
            result.append(String.format(format, row.toArray(new String[0]))).append("\n");
        }
        return result.toString();
    }
}
