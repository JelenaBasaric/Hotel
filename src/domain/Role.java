package domain;

import java.util.Objects;

/**
 *
 * @author Jelena Basaric
 */
public class Role {
    private Integer id;
    private String title;
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Role() {
    }

    public Role(Integer id, String name) {
        this.id = id;
        this.title = name;
    }

    public Role(Integer id, String title, String desc) {
        this.id = id;
        this.title = title;
        this.desc = desc;
    }
    

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return title ;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Role other = (Role) obj;
        return Objects.equals(this.title, other.title);
    }
    

    
}
