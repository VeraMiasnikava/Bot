package programbot.entities;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "programming_calendar")
public class ProgramminCalendar {
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
    @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "CALENDAR_SEQUENCE")
    @Getter
    @Setter
    @Column(name = "id_calendar", updatable = false, nullable = false)
    private long id_calendar;

    @Getter
    @Setter
    @Column(name = "groupa", length = 10)
    private String groupa;

    @Getter
    @Setter
    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = true, insertable = true, updatable = true)
    public java.util.Date date;

    @Getter
    @Setter
    @Column(name = "home_work", length = 100)
    private String homeWork;

}
