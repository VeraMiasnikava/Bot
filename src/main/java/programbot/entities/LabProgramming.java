package programbot.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Entity
@Table(name = "lab_programming_works")
public class LabProgramming {

    @Getter
    @Setter
    @Id
    @Column(name = "id_lab")
    private int idLab;


    @Getter
    @Column(name = "titl", length=100)
    private String title;

    @Getter
    @Setter
    @Column(name= "semest")
    private int semestr;
/*
    @Getter
    @Setter
    @OneToMany(mappedBy = "labProgramming", cascade = CascadeType.ALL, orphanRemoval = true, fetch=FetchType.LAZY)
    private List<ProgrammingLesson> lessons;*/

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

    @Override
    public String toString() {
        return "LabWorkProgramming{" +
                "idLab=" + idLab +
                ", title='" + title + '\'' +
                ", semestr=" + semestr +
                '}';
    }
}
