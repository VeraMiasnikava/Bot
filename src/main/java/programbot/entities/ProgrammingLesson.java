package programbot.entities;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "programming_lessons")
public class ProgrammingLesson {

    @Id
    @GenericGenerator(
            name = "LESSON_SEQUENCE",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence__name", value = "LESSON_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial__value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment__size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LESSON_SEQUENCE")
    @Getter
    @Setter
    @Column(name = "id_lesson", updatable = false, nullable = false)
    private Long idLesson;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_student", referencedColumnName = "id_student")
    private Student student;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lab", referencedColumnName = "id_lab")
    private ProgrammingLab programmingLab;

    @Getter
    @Setter
    @Column(name = "presence", length = 10)
    //n+, n-, пусто
    private String presence;

    @Getter
    @Setter
    @Column(name = "pass_test", length = 10)
    //пусто, z+,z-, пр
    private String passTest;

    @Getter
    @Setter
    @Column(name = "mark_1")
    private Integer mark1;

    @Getter
    @Setter
    @Column(name = "mark_2")
    private Integer mark2;

    @Override
    public String toString() {
        String s1 = " + ";
        if (!presence.isEmpty()) {
            s1 = presence;
        }
        String s2 = " - ";
        if (!passTest.isEmpty()) {
            s2 = passTest;
        }
        String s3 = programmingLab.getTitle().substring(0, 12);
        String s = String.format("|%12s | %4s  | %4s| ", s3, s1, s2);
        if (mark1 != null) {
            s = s + mark1;
        }
        if (mark2 != null) {
            s = s + "/ " + mark2;
        }
        return s;
    }


    public ProgrammingLesson(Student student, ProgrammingLab programmingLab, String presence, String passTest, Integer mark1, Integer mark2) {
        this.student = student;
        this.programmingLab = programmingLab;
        this.presence = presence;
        this.passTest = passTest;
        this.mark1 = mark1;
        this.mark2 = mark2;
    }

    public ProgrammingLesson(Student student, ProgrammingLab programmingLab, String presence, String passTest, Integer mark1) {
        this.student = student;
        this.programmingLab = programmingLab;
        this.presence = presence;
        this.passTest = passTest;
        this.mark1 = mark1;
    }

    public ProgrammingLesson(Student student, ProgrammingLab programmingLab, String presence, String passTest) {
        this.student = student;
        this.programmingLab = programmingLab;
        this.presence = presence;
        this.passTest = passTest;
    }

}

