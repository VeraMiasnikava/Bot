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
@Table(name = "groups")
public class Group {

    @Getter
    @Setter
    @Id
    @GenericGenerator(
            name = "GROUP_SEQUENCE",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence__name", value = "GROUP_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial__value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment__size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GROUP_SEQUENCE")
    @Column(name = "id_group", updatable = false, nullable = false)
    private Long idGroup;

    @Getter
    @Setter
    @Column(name = "groupa", length = 10)
    private String groupTitle;

    public Group(String groupTitle) {
        this.groupTitle = groupTitle;
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    @Getter
    @Setter
    @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<ProgrammingCalendar> programmingDates = new ArrayList<>();

    public void addProgrammingCalendar(ProgrammingCalendar programmingCalendar) {
        programmingCalendar.setGroup(this);
        programmingDates.add(programmingCalendar);
    }
}
