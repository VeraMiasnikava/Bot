package programbot.entities;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@EqualsAndHashCode
@NoArgsConstructor
@ToString
@Entity
@Table(name = "users")
public class User {

    @Getter
    @Setter
    @Id
    @Column(name = "id_user")
    private Long idUser;

    @Getter
    @Setter
    @Column(name = "stat")
    private int state;

    @Getter
    @Setter
    @Column(name = "discipline_number")
    private int numberOfDiscipline;

    @Getter
    @Setter
    @Column(name = "groupa")
    private String groupTitle;

    public User(Long idUser, int state) {
        this.idUser = idUser;
        this.state = state;
    }

    public User(Long idUser, int state, int numberOfDiscipline) {
        this.idUser = idUser;
        this.state = state;
        this.numberOfDiscipline = numberOfDiscipline;
    }

    public User(Long idUser, int state, int numberOfDiscipline, String groupTitle) {
        this.idUser = idUser;
        this.state = state;
        this.numberOfDiscipline = numberOfDiscipline;
        this.groupTitle = groupTitle;
    }


}
