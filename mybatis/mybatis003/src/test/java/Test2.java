import com.sz.entity.Author;
import com.sz.entity.Blog;
import com.sz.entity.Husband;
import com.sz.mapper.AuthorMapper;
import com.sz.mapper.BlogMapper;
import com.sz.mapper.HusbandMapper;
import com.sz.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test2 {


    @Test
    public void m1() {
        SqlSession session = MybatisUtil.getSession();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);
        Author author = mapper.selectByPrimaryKeyWithBlogs(1);
        System.out.println(author);


    }




    @Test
    public void m2() {
        SqlSession session = MybatisUtil.getSession();
        AuthorMapper mapper = session.getMapper(AuthorMapper.class);
        Author author = mapper.selectByPrimaryKeyWithBlogsAndComments(1);
        System.out.println(author);


    }


    @Test
    public void m3() {
        SqlSession session = MybatisUtil.getSession();
        BlogMapper mapper = session.getMapper(BlogMapper.class);
        Blog blog = mapper.selectByPrimaryKeyWithAuthor(1);

        System.out.println(blog +  "" + blog.getAuthor());


    }


}
