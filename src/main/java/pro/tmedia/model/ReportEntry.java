package pro.tmedia.model;

import org.hibernate.annotations.ForeignKey;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * User: Ivaykin Timofey
 * Date: 2/14/14
 */
@Entity
@Table(name="rept")
public class ReportEntry implements Serializable {


    @GeneratedValue
    @Id
    private Integer id;

    /*@OneToMany(mappedBy = "project")
    @JoinTable(
            name = "Project_Tasks",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "task_id")
    )
    private Set<Task> tasks;*/

    @ManyToOne
    private Flow flow;
    @ManyToOne
    private Discipline disc;
    @ManyToOne
    private Semester sem;

    private Integer data__test;

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

    public Integer getData__test() {
        return data__test;
    }
    public void setData__test(Integer data__test) {
        this.data__test = data__test;
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
}
