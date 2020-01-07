package programbot.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import programbot.utils.HibernateSessionFactory;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@EqualsAndHashCode
@Entity
@Table(name = "lab_programming_works")
public class LabProgramming {

   // @Getter
   // @Setter
    @Id
    @Column(name = "id_lab")
    private int idLab;


  //  @Getter
    @Column(name = "title", length=100)
    private String title;

  //  @Getter
  //  @Setter
    @Column(name= "semestr")
    private int semestr;

   // @Getter
   // @Setter
    @OneToMany(mappedBy = "labProgramming", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    private List<ProgrammingLesson> lessons=new ArrayList<>();

    public LabProgramming() {
    }

    public LabProgramming(int idLab, String title, int semestr) throws UnsupportedEncodingException {
        this.idLab = idLab;
        String tit=new String(title.getBytes("cp1251"), "UTF-8");
        this.title = tit;
        this.semestr = semestr;
    }

    public void setTitle(String title) throws UnsupportedEncodingException{
        String tit=new String(title.getBytes("cp1251"), "UTF-8");
        this.title = tit;
    }

    public int getIdLab() {
        return idLab;
    }

    public String getTitle() {
        return title;
    }

    public int getSemestr() {
        return semestr;
    }

    public List<ProgrammingLesson> getLessons() {
        return lessons;
    }

    public void setIdLab(int idLab) {
        this.idLab = idLab;
    }

    public void setSemestr(int semestr) {
        this.semestr = semestr;
    }

    public void setLessons(List<ProgrammingLesson> lessons) {
        this.lessons = lessons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LabProgramming)) return false;
        LabProgramming that = (LabProgramming) o;
        return idLab == that.idLab &&
                semestr == that.semestr &&
                title.equals(that.title) &&
                Objects.equals(lessons, that.lessons);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idLab, title, semestr, lessons);
    }

    @Override
    public String toString() {
        return "LabWorkProgramming{" +
                "idLab=" + idLab +
                ", title='" + title + '\'' +
                ", semestr=" + semestr +
                '}';
    }


}
