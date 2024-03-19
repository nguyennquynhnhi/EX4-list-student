import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong hoc vien: ");
        int n = sc.nextInt();
        List<String> students = new ArrayList<>();
        for(int i=0; i<n; i++) {
            sc.nextLine();
            System.out.println("Nhap thong tin hoc vien thu "+(i+1));
            System.out.println("Ma sinh vien:");
            String MSV = sc.nextLine();
            System.out.println("Ho ten:");
            String hoTen = sc.nextLine();
            System.out.println("Gioi tinh:");
            String gioiTinh = sc.nextLine();
            System.out.println("Diem Python:");
            double diemPython = sc.nextDouble();
            System.out.println("Diem Java:");
            double diemJava = sc.nextDouble();

            students.add((MSV+","+hoTen+","+gioiTinh+","+diemPython+","+diemJava));
        }

        try (PrintWriter writer = new PrintWriter("input.txt")) {
            for (String student : students) {
                writer.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        List<Student> studentsFromFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                studentsFromFile.add(new Student(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]), Double.parseDouble(parts[4])));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        studentsFromFile.sort(Comparator.comparingDouble(Student::getDiemtb).reversed());

        System.out.println("Danh sach hoc vien sau khi sap xep:");
        try (PrintWriter writer = new PrintWriter("output.txt")) {
            for (Student student : studentsFromFile) {
                System.out.println(student);
                writer.println(student.toString());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.print("Nhap ho ten hoc vien can tim: ");
        String searchName = sc.next();

        boolean found = false;
        System.out.println("Danh sach hoc vien co ho ten \"" + searchName + "\":");
        for (Student student : studentsFromFile) {
            if (student.getHoTen().equals(searchName)) {
                System.out.println(student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Khong tim thay hoc vien co ho ten \"" + searchName + "\".");
        }

        System.out.println("Danh sach hoc vien da dau:");
        for (Student student : studentsFromFile) {
            if (student.getKqua().equals("Dau")) {
                System.out.println(student);
            }
        }

        System.out.println("Danh sach hoc vien da truot:");
        for (Student student : studentsFromFile) {
            if (student.getKqua().equals("Truot")) {
                System.out.println(student);
            }
        }

        System.out.println("Danh sach hoc vien diem trung binh tren 8: ");
        for (Student student : studentsFromFile) {
            if (student.getDiemtb() > 8) {
                System.out.println(student);
            }
        }
    }
}