package programbot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "programming_calendar")
public class ProgrammingCalendar {

    @Getter
    @Setter
    @Id
    @GenericGenerator(
            name = "CALENDAR_SEQUENCE",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence__name", value = "CALENDAR_SEQUENCE"),
                    @org.hibernate.annotations.Parameter(name = "initial__value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment__size", value = "1")
            }
    )
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CALENDAR_SEQUENCE")
    @Column(name = "id")
    private Long id;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_group", referencedColumnName = "id_group")
    private Group group;

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_lab", referencedColumnName = "id_lab")
    private ProgrammingLab programmingLab;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "lesson_date", nullable = true, insertable = true, updatable = true)
    public Date date;


    @Override
    public String toString() {
        return "ProgrammingCalendar{" +
                "id=" + id +
                ", groupa='" + group + '\'' +
                '}';
    }

    public ProgrammingCalendar(Group group, ProgrammingLab programmingLab, Date date) {
        this.group = group;
        this.programmingLab = programmingLab;
        this.date = date;
    }
}
