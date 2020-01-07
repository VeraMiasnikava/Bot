package programbot.entities;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.*;

//@EqualsAndHashCode
@Entity
@Table(name = "students")
public class Student {

    //@Getter
   // @Setter
    @Id
    @Column(name = "id_student")
    private int idStudent;

   // @Getter
    @Column(name = "name", length = 30)
    private String name;

    //@Getter
    @Column(name = "surname", length = 30)
    private String surname;

   // @Getter
    @Column(name = "groupa", length = 10)
    private String groupa;

   // @Getter
   // @Setter
    @Column(name = "stat")
    private int state;

   // @Getter
   // @Setter
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ProgrammingLesson> lessons=new ArrayList<>();

    public int getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGroupa() {
        return groupa;
    }

    public int getState() {
        return state;
    }

    public List<ProgrammingLesson> getLessons() {
        return lessons;
    }

    public Student() {
    }

    public Student(int idStudent, String name, String surname, String groupa) throws UnsupportedEncodingException {
        this.idStudent = idStudent;
        String nm = new String(name.getBytes("cp1251"), "UTF-8");
        this.name = nm;
        String snm = new String(surname.getBytes("cp1251"), "UTF-8");
        this.surname = snm;
        String gr = new String(groupa.getBytes("cp1251"), "UTF-8");
        this.groupa = gr;
        this.state = 0;
        lessons = new ArrayList<>();
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setLessons(List<ProgrammingLesson> lessons) {
        this.lessons = lessons;
    }

    public void setName(String name) throws UnsupportedEncodingException {
        String nm = new String(name.getBytes("cp1251"), "UTF-8");
        this.name = nm;
    }

    public void setSurname(String surname) throws UnsupportedEncodingException {
        String snm = new String(surname.getBytes("cp1251"), "UTF-8");
        this.surname = snm;
    }

    public void setGroupa(String group) throws UnsupportedEncodingException {
        String gr = new String(group.getBytes("cp1251"), "UTF-8");
        this.groupa = gr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return idStudent == student.idStudent &&
                state == student.state &&
                name.equals(student.name) &&
                surname.equals(student.surname) &&
                groupa.equals(student.groupa) &&
                Objects.equals(lessons, student.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idStudent, name, surname, groupa, state, lessons);
    }

    @Override
    public String toString() {
        return "Student{" +
                "idStudent=" + idStudent +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", group='" + groupa + '\'' +
                ", state=" + state +
                '}';
    }

    public void addProgrammingLesson(ProgrammingLesson lesson) {
        lesson.setStudent(this);
        lessons.add(lesson);
    }

   /* public void addProgrammingLesson(ProgrammingLesson programmingLesson) {
        programmingLesson.setStudent(this);
        lessons.add(programmingLesson);
    }*/
}
