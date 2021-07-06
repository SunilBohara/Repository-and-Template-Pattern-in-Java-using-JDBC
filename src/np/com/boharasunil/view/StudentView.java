/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package np.com.boharasunil.view;

import java.util.Scanner;
import np.com.boharasunil.entity.Student;
import np.com.boharasunil.repository.StudentRepository;
import np.com.boharasunil.repository.impl.StudentRepositoryImpl;

/**
 *
 * @author sunilbohara
 */
public class StudentView {

    private static final Scanner sc = new Scanner(System.in);
    private static final StudentRepository studentRepository = new StudentRepositoryImpl();

    public void showMenus() {
        System.out.println("1) Add Student");
        System.out.println("2) View Students");
        System.out.println("3) Update Student");
        System.out.println("4) Delete Student");
        System.out.println("5) Search Student");
        System.out.println("6) Exit");
        System.out.print("Choose :");
    }

    public StudentView() throws Exception {
        while (true) {

            showMenus();

            int user = sc.nextInt();

            switch (user) {
                case 1:
                    System.out.println("===========================");
                    System.out.print("Enter studentid: ");
                    Student student = new Student();
                    student.setSid(sc.nextInt());
                    System.out.print("Enter fullname: ");
                    student.setFullName(sc.next());
                    System.out.print("Enter gender: ");
                    student.setGender(sc.next());
                    System.out.print("Enter address: ");
                    student.setAddress(sc.next());
                    System.out.print("Enter email: ");
                    student.setEmail(sc.next());
                    System.out.print("Enter phoneno: ");
                    student.setContactNo(sc.nextLong());
                    studentRepository.insert(student);
                    System.out.println("Student added successfuly");
                    break;
                case 2:
                    System.out.println("===========================");
                    for (Student s : studentRepository.findAll()) {
                        System.out.println(s.toString());
                    }
                    break;
                case 3:
                    System.out.println("===========================");
                    System.out.print("Enter studentid to update: ");
                    Student updateStudent = new Student();
                    updateStudent.setSid(sc.nextInt());
                    System.out.print("Enter new fullname: ");
                    updateStudent.setFullName(sc.next());
                    System.out.print("Enter new gender: ");
                    updateStudent.setGender(sc.next());
                    System.out.print("Enter new address: ");
                    updateStudent.setAddress(sc.next());
                    System.out.print("Enter new email: ");
                    updateStudent.setEmail(sc.next());
                    System.out.print("Enter new phoneno: ");
                    updateStudent.setContactNo(sc.nextLong());
                    studentRepository.update(updateStudent, updateStudent.getSid());
                    System.out.println("Updated successfully");
                    break;
                case 4:
                    System.out.println("===========================");
                    System.out.print("Enter studentid to delete: ");
                    studentRepository.delete(sc.nextInt());
                    System.out.println("Deleted successfully");
                    break;
                case 5:
                    System.out.println("===========================");
                    System.out.print("Search students: ");
                    Student stu = studentRepository.findByInput(sc.next());
                    System.out.println(stu.toString());
                    break;

                case 6:
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Input!");
                    break;
            }

        }
    }

}
