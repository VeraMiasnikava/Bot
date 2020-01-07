package programbot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

//@EqualsAndHashCode
@Entity
@Table(name = "programming_lessons")
//@IdClass(ProgrammingLesson.ProgrLessonKey.class)
public class ProgrammingLesson implements Serializable  {

    //@JoinTable (name="students")

   /* @JoinTable (name="students",
            joinColumns=@JoinColumn (name="id_student"),
            inverseJoinColumns=@JoinColumn(name="id_student"))*/
/*
  @Id
  @AttributeOverrides({
          @AttributeOverride(name = "student",
                  column = @Column(name="STREET")),
          @AttributeOverride(name = "labProgramming",
                  column = @Column(name="CITY"))
  })*/



  @Id
 // @SequenceGenerator(name = "hibernateSeq", sequenceName = "LESSON_SEQUENCE")
  @GenericGenerator(
          name = "LESSON_SEQUENCE",
          strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
          parameters = {
                  @org.hibernate.annotations.Parameter(name = "sequence__name", value = "LESSON_SEQUENCE"),
                  @org.hibernate.annotations.Parameter(name = "initial__value", value = "1"),
                  @org.hibernate.annotations.Parameter(name = "increment__size", value = "1")
          }
  )
  @GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "LESSON_SEQUENCE")
 // @Getter
 // @Setter
  @Column(name = "id_lesson", updatable = false, nullable = false)
  private long id_lesson;

 // @Getter
 // @Setter
  @ManyToOne(optional=false, cascade= CascadeType.ALL)
  @JoinColumn(name="id_student", referencedColumnName = "id_student")
  private Student student;

 // @Getter
 // @Setter
  @ManyToOne(optional=false, cascade=CascadeType.ALL)
  // @JoinTable (name="lab_programming_works")
   @JoinColumn (name="id_lab", referencedColumnName = "id_lab")
  private LabProgramming labProgramming;

  //  @Getter
  //  @Setter
    @Column(name = "was_present")
    private boolean wasPresent;

   // @Getter
   // @Setter
    @Column(name = "waiting_document")
    private boolean waitingDocument;

   // @Getter
   // @Setter
    @Column(name = "pass_test")
    private boolean passTest;

  //  @Getter
  //  @Setter
    @Column(name = "waiting_report")
    private boolean waitingReport;

   // @Getter
   // @Setter
    @Column(name = "mark_1")
    private Integer mark1;

  //  @Getter
  //  @Setter
    @Column(name = "mark_2")
    private Integer mark2;

  public ProgrammingLesson() {
  }

  public long getId_lesson() {
    return id_lesson;
  }

  public Student getStudent() {
    return student;
  }

  public LabProgramming getLabProgramming() {
    return labProgramming;
  }

  public boolean isWasPresent() {
    return wasPresent;
  }

  public boolean isWaitingDocument() {
    return waitingDocument;
  }

  public boolean isPassTest() {
    return passTest;
  }

  public boolean isWaitingReport() {
    return waitingReport;
  }

  public Integer getMark1() {
    return mark1;
  }

  public Integer getMark2() {
    return mark2;
  }

  public void setId_lesson(long id_lesson) {
    this.id_lesson = id_lesson;
  }

  public void setStudent(Student student) {
    this.student = student;
  }

  public void setLabProgramming(LabProgramming labProgramming) {
    this.labProgramming = labProgramming;
  }

  public void setWasPresent(boolean wasPresent) {
    this.wasPresent = wasPresent;
  }

  public void setWaitingDocument(boolean waitingDocument) {
    this.waitingDocument = waitingDocument;
  }

  public void setPassTest(boolean passTest) {
    this.passTest = passTest;
  }

  public void setWaitingReport(boolean waitingReport) {
    this.waitingReport = waitingReport;
  }

  public void setMark1(Integer mark1) {
    this.mark1 = mark1;
  }

  public void setMark2(Integer mark2) {
    this.mark2 = mark2;
  }

  @Override
  public String toString() {
    return "ProgrammingLesson{" +
         //   "id_lesson=" + id_lesson +
            ", student=" + student +
            ", labProgramming=" + labProgramming +
            ", wasPresent=" + wasPresent +
            ", waitingDocument=" + waitingDocument +
            ", passTest=" + passTest +
            ", waitingReport=" + waitingReport +
            ", mark1=" + mark1 +
            ", mark2=" + mark2 +
            '}';
  }


    public ProgrammingLesson(Student student,LabProgramming labProgramming  ) {
        this.student = student;
        this.labProgramming=labProgramming;
        this.wasPresent = true;
        this.waitingDocument = false;
        this.passTest = false;
        this.waitingReport = true;
        this.mark1 = 0;
        this.mark2 = 0;
    }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof ProgrammingLesson)) return false;
    ProgrammingLesson that = (ProgrammingLesson) o;
    return id_lesson == that.id_lesson &&
            wasPresent == that.wasPresent &&
            waitingDocument == that.waitingDocument &&
            passTest == that.passTest &&
            waitingReport == that.waitingReport &&
            student.equals(that.student) &&
            Objects.equals(labProgramming, that.labProgramming) &&
            Objects.equals(mark1, that.mark1) &&
            Objects.equals(mark2, that.mark2);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id_lesson, student, labProgramming, wasPresent, waitingDocument, passTest, waitingReport, mark1, mark2);
  }

    /*
  @Embeddable
  @EqualsAndHashCode
  @ToString
  public class ProgrLessonKey implements Serializable {
    static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private Student student;

    @Getter
    @Setter
    private LabProgramming labProgramming;

    public ProgrLessonKey() {
    }
  }*/
}

