package programbot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "programming_lab_works")
public class ProgrammingLab {

    @Getter
    @Setter
    @Id
    @GenericGenerator(
            name = "LAB_SEQUENCE",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence__name", value = "LAB_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial__value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment__size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LAB_SEQUENCE")
    @Column(name = "id_lab")
    private Long idLab;

    @Getter
    @Setter
    @Column(name = "title", length = 100)
    private String title;

    @Getter
    @Setter
    @Column(name = "semestr")
    private int semestr;

    @Getter
    @Setter
    @OneToMany(mappedBy = "programmingLab", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProgrammingLesson> lessons = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(mappedBy = "programmingLab", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProgrammingCalendar> dates = new ArrayList<>();


    public ProgrammingLab(String title, int semestr)  {
        this.title = title;
        this.semestr = semestr;
    }

    @Override
    public String toString() {
        return "LabWorkProgramming{" +
                "idLab=" + idLab +
                '}';
    }


    public void addProgrammingLesson(ProgrammingLesson lesson) {
        lesson.setProgrammingLab(this);
        lessons.add(lesson);
    }

    public void addProgrammingCalendar(ProgrammingCalendar calendar) {
        calendar.setProgrammingLab(this);
        dates.add(calendar);
    }

}
