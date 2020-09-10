package mapper;
import java.util.List;
import po.User;

public interface Mapper {

    public List<User> query() throws Exception;
    public User query2(String username) throws Exception;
    public void query3(User user) throws Exception;

}
