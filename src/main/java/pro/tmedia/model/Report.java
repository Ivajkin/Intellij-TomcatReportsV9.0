package pro.tmedia.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * User: Ivaykin Timofey
 * Date: 2/14/14
 */
@Entity
@Table(name="report")
public class Report implements Serializable {


    @GeneratedValue
    @Id
    private Integer id;


    @ManyToOne
    private Flow flow;
    @ManyToOne
    private Discipline disc;
    @ManyToOne
    private Semester sem;

    @ManyToOne
    private Department dept;

    @ManyToOne
    private Teacher teacher;

    public Flow getFlow() {
        return flow;
    }
    public void setFlow(Flow flow) {
        this.flow = flow;
    }

    public Discipline getDisc() {
        return disc;
    }
    public void setDisc(Discipline disc) {
        this.disc = disc;
    }

    public Semester getSem() {
        return sem;
    }
    public void setSem(Semester sem) {
        this.sem = sem;
    }


    public Department getDept() {
        return dept;
    }
    public void setDept(Department dept) {
        this.dept = dept;
    }

    public Teacher getTeacher() {
        return teacher;
    }
    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
}
