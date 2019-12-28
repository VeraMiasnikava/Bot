package programbot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "programming_lessons")
@IdClass(ProgrammingLesson.ProgrLessonKey.class)
public class ProgrammingLesson  {

    //@JoinTable (name="students")

   /* @JoinTable (name="students",
            joinColumns=@JoinColumn (name="id_student"),
            inverseJoinColumns=@JoinColumn(name="id_student"))*/

  @Id
  @AttributeOverrides({
          @AttributeOverride(name = "student",
                  column = @Column(name="STREET")),
          @AttributeOverride(name = "idLab",
                  column = @Column(name="CITY"))
  })


  @Getter
  @Setter
  /*@ManyToOne(optional=false, cascade= CascadeType.ALL)
  @JoinColumn(name="id_student", referencedColumnName = "id_student")*/
  // @Column(name = "id_student")
  private int student;


  @Getter
  @Setter
  // @ManyToOne(optional=false, cascade=CascadeType.ALL)
  // @JoinTable (name="lab_programming_works")
  // @JoinColumn (name="id_lab")
  @Column(name = "id_lab")
  private int idLab;

    @Getter
    @Setter
    @Column(name = "was_present")
    private boolean wasPresent;

    @Getter
    @Setter
    @Column(name = "waiting_document")
    private boolean waitingDocument;

    @Getter
    @Setter
    @Column(name = "pass_test")
    private boolean passTest;

    @Getter
    @Setter
    @Column(name = "waiting_report")
    private boolean waitingReport;

    @Getter
    @Setter
    @Column(name = "mark_1")
    private int mark1;

    @Getter
    @Setter
    @Column(name = "mark_2")
    private int mark2;

  public ProgrammingLesson() {
  }

   /*
    public ProgrammingLesson(int idStudent,  int mark1) {
        this.idStudent = idStudent;
        this.wasPresent = true;
        this.waitingDocument = false;
        this.passTest = false;
        this.waitingReport = true;
        this.mark1 = mark1;
        this.mark2 = 0;
    }*/
   @Embeddable
  @EqualsAndHashCode
  @ToString
  public class ProgrLessonKey implements Serializable {
    static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private int student;

    @Getter
    @Setter
    private int idLab;

    public ProgrLessonKey() {
    }
  }
}

