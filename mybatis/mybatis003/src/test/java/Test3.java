import com.sz.entity.Author;
import com.sz.entity.Blog;
import com.sz.entity.Husband;
import com.sz.mapper.AuthorMapper;
import com.sz.mapper.BlogMapper;
import com.sz.mapper.HusbandMapper;
import com.sz.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test3 {


    @Test
    public void m1() {
        SqlSession session = MybatisUtil.getSession();
        HusbandMapper mapper = session.getMapper(HusbandMapper.class);
        Husband husband = mapper.selectByPrimaryKey(1);
        // 缓存的作用就是一个中间结果，不再直接去数据库查询。
        // 如果你进行了增删改的操作都会让缓存失效
        // 手工清除缓存，一刀切
//        session.clearCache();
//        session.
        husband.setName("王宝强");
        mapper.update(husband);
        Husband husband2 = mapper.selectByPrimaryKey(1);


    }








}
