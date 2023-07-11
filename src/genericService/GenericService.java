package genericService;



import domain.Employee;
import domain.Guest;
import domain.UserProfile;
import java.util.List;


/**
 *
 * @author Jelena Basaric
 */
public interface GenericService <T,ID>{
    void saveOrUpdate(T t) throws Exception;
    List<T> getAll() throws Exception;
    void add(T entity) throws Exception;
    T findById(ID id) ;
    public void update(T entity) throws Exception;

  //  public UserProfile login( ID id, ID id1) throws Exception;
    
    
}
