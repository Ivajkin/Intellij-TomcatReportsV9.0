package pro.tmedia.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * User: Ivaykin Timofey
 * Date: 2/12/14
 */

@Entity
@Table(name="dept")
public class Department extends DictionaryItem {
    String head;

    void setHead(String head) {
        this.head = head;
    }
    String getHead() {
        return head;
    }
}

