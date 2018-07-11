import com.sz.entity.Husband;
import com.sz.mapper.HusbandMapper;
import com.sz.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class Test1 {


    @Test
    public void m1(){
        SqlSession session = MybatisUtil.getSession();
        HusbandMapper mapper = session.getMapper(HusbandMapper.class);
        Husband husband = mapper.selectByPrimaryKey(1);
        System.out.println(husband);
    }


    @Test
    public void m2(){
        SqlSession session = MybatisUtil.getSession();
        HusbandMapper mapper = session.getMapper(HusbandMapper.class);
        Husband husband = mapper.selectByPrimaryKey2(1);
        System.out.println(husband);
    }

    @Test
    public void m3(){
        SqlSession session = MybatisUtil.getSession();
        HusbandMapper mapper = session.getMapper(HusbandMapper.class);
        Husband husband = mapper.selectByPrimaryKey3(1);
        System.out.println(husband);
    }
}
