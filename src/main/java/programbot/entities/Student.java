package programbot.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Getter
    @Setter
    @Id
    @Column(name = "id_student")
    private int idStudent;

    @Getter
    @Column(name = "name", length = 30)
    private String name;

    @Getter
    @Column(name = "surname", length = 30)
    private String surname;

    @Getter
    @Column(name = "groupa", length = 10)
    private String groupa;

    @Getter
    @Setter
    @Column(name = "stat")
    private int state;

    @Getter
    @Setter
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ProgrammingLesson> lessons=new ArrayList<>();


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
