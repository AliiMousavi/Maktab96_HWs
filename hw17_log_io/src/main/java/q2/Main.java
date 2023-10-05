package q2;


import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import q1.entity.Student;
import q2.entity.Course;
import q2.entity.Studentt;
import q2.entity.StudentCourseRating;
import q2.util.ApplicationContext;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static Date parsDate(String input) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            java.util.Date parsedDate = dateFormat.parse(input);
            Timestamp timestamp = new Timestamp(parsedDate.getTime());
            return new Date(timestamp.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
    public static void main(String[] args) {
        //1
        File file = new File("C:\\Users\\asus\\Desktop\\hw17_log_io\\src\\main\\java\\q2\\file\\haminMatno.txt");

        List<String> list = new ArrayList<>();

        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                list.add(scanner.nextLine());
                String line = list.get(0);

                String[] splitValues = line.split(",");

                List<String> arrayList = new ArrayList<>(Arrays.asList(splitValues));

                Course course = new Course();
                Studentt studentt = new Studentt();
                StudentCourseRating studentCourseRating = new StudentCourseRating();

                course.setCourseName(arrayList.get(0));
                studentt.setStudentName(arrayList.get(1));
                studentCourseRating.setTimestamp(parsDate(arrayList.get(2)));
                studentCourseRating.setRating(Double.parseDouble(arrayList.get(3)));
                studentCourseRating.setComment(arrayList.get(4));

                ApplicationContext.getStudentService().saveOrUpdate(studentt);
                ApplicationContext.getCourseService().saveOrUpdate(course);
                ApplicationContext.getStudentCourseRatingService().saveOrUpdate(studentCourseRating);
                list.clear();
                arrayList.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2
        File filee = new File("C:\\Users\\asus\\Desktop\\hw17_log_io\\src\\main\\java\\q2\\file\\file.csv");




        try (CSVReader reader = new CSVReader(new FileReader(filee))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String courseName = nextLine[0].trim();
                String studentName = nextLine[1].trim();
                Date timestamp = parsDate(nextLine[2].trim());
                double rating = Double.parseDouble(nextLine[3].trim());
                String comment = nextLine[4].trim();

                Studentt student = new Studentt();
                student.setStudentName(studentName);

                Course course = new Course();
                course.setCourseName(courseName);

                StudentCourseRating studentCourseRating = new StudentCourseRating();
                studentCourseRating.setTimestamp(timestamp);
                studentCourseRating.setRating(rating);
                studentCourseRating.setComment(comment);

                ApplicationContext.getStudentService().saveOrUpdate(student);
                ApplicationContext.getCourseService().saveOrUpdate(course);
                ApplicationContext.getStudentCourseRatingService().saveOrUpdate(studentCourseRating);
            }
        } catch (IOException e) {
           e.printStackTrace();
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
