import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Student {
    protected String name;
    protected int studentId;
    protected Map<String, String> grades = new HashMap<>();

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
    }

    public void addGrade(String course, double marks) {
        grades.put(course, calculateGrade(marks));
    }

    private String calculateGrade(double marks) {
        if (marks >= 90) return "A";
        if (marks >= 80) return "B";
        if (marks >= 70) return "C";
        if (marks >= 60) return "D";
        return "F";
    }

    public double calculateGPA() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (String grade : grades.values()) {
            sum += gradeToPoint(grade);
        }
        return sum / grades.size();
    }

    private double gradeToPoint(String grade) {
        switch (grade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            case "D": return 1.0;
            default: return 0.0;
        }
    }

    public String getInfo() {
        return String.format("Student: %s (ID: %d)\nGPA: %.2f\nGrades: %s",
                name, studentId, calculateGPA(), grades);
    }
}

class UndergraduateStudent extends Student {
    public UndergraduateStudent(String name, int id) {
        super(name, id);
    }
}

public class Main {
    public static void main(String[] args) {
        String datasetPath = "students.csv";
        String outputPath = "gpa_results.txt";
        
        if (args.length > 0) {
            datasetPath = args[0];
        }
        if (args.length > 1) {
            outputPath = args[1];
        }

        try {
            processStudentData(datasetPath, outputPath);
            System.out.println("Successfully saved GPA results to: " + outputPath);
        } catch (IOException e) {
            System.err.println("Error processing data: " + e.getMessage());
            System.out.println("Usage: java Main [dataset_path] [output_path]");
        }
    }

    private static void processStudentData(String inputPath, String outputPath) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(inputPath));
             FileWriter writer = new FileWriter(outputPath)) {
            
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length != 4) continue;

                String name = data[0];
                int studentId = Integer.parseInt(data[1]);
                String course = data[2];
                double marks = Double.parseDouble(data[3]);

                Student student = new UndergraduateStudent(name, studentId);
                student.addGrade(course, marks);
                writer.write(student.getInfo() + "\n\n");
            }
        }
    }
}
