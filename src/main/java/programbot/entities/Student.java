package programbot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.*;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Getter
    @Setter
    @Id
    @GenericGenerator(
            name = "STUDENT_SEQUENCE",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence__name", value = "STUDENT_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial__value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment__size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQUENCE")
    @Column(name = "id_student", updatable = false, nullable = false)
    private Long idStudent;

    @Getter
    @Setter
    @Column(name = "name", length = 30)
    private String name;

    @Getter
    @Setter
    @Column(name = "surname", length = 30)
    private String surname;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_group", referencedColumnName = "id_group")
    private Group group;

    @Getter
    @Setter
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProgrammingLesson> programmingLessons = new ArrayList<>();

    public Student(String name, String surname, Group group)  {
        this.name = name;
        this.surname = surname;
        this.group = group;
    }

    @Override
    public String toString() {
        return String.format("%10d | %10s | %s%n",
                idStudent, surname, name);
    }

    public void addProgrammingLesson(ProgrammingLesson lesson) {
        lesson.setStudent(this);
        programmingLessons.add(lesson);
    }

}
