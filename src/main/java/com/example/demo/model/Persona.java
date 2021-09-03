package com.example.demo.model;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "Persona")
@EntityListeners(AuditingEntityListener.class)
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "Full_Name", nullable = false)
    private String FullName;

    
    @Column(name = "Birth_Date ", nullable = false)
    private Date BirthDate;


  /**
   * Gets id.
   *
   * @return the id
   */
  public long getId() {
        return id;
    }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(long id) {
        this.id = id;
    }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFullName() {
        return FullName;
    }

  /**
   * Sets Full name.
   *
   * @param Full_Name the Full name
   */
  public void setFullName(String FullName) {
        this.FullName = FullName;
    }

  public Date getBirthDate() {
        return BirthDate;
    }

  /**
   * Sets BirthDate.
   *
   * @param BirthDate the BirthDate
   */
  public void setBirthDate(Date BirthDate) {
        this.BirthDate = BirthDate;
    }
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Full_Name='" + FullName + '\'' +
                ", birth_Date'" + BirthDate +
                '}';
    }


}
