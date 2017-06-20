package dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by song on 2017/6/16.
 */
public class GetSqlSessionFactory {
    private static SqlSessionFactory sqlSessionFactory=null;
    private static GetSqlSessionFactory getSqlSessionFactory=null;

       static {
           String rs = "mybatis/mybatis-config.xml";
           Reader rd = null;
           try {
               rd = Resources.getResourceAsReader(rs);
               sqlSessionFactory = new SqlSessionFactoryBuilder().build(rd);
               // 注解方式查询时需要注册mapper
//            sqlSessionFactory.getConfiguration().addMapper(UserService.class);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }

    public static SqlSessionFactory getSqlSessionFactory(){
        return sqlSessionFactory;
    }

    public static void main(String[] args) {
        TestList();
//        SqlSession session =GetSqlSessionFactory.getSqlSessionFactory().openSession();
//       try {
//
////           Person person=(Person) session.selectOne("test.getPersonId",22);
//           IPerson iPerson= session.getMapper(IPerson.class);
//           Person person =iPerson.getPersonId(22);
//           if(person!=null) System.out.println(person.getPid()+"--"+person.getUsername()+"--"+person.getPassword());
//       }finally {
//           session.close();
//       }

    }

    public static void TestList(){
        SqlSession session = GetSqlSessionFactory.getSqlSessionFactory().openSession();
        UserMapper iUserMapper =session.getMapper(UserMapper.class);
        List<entity.Person> list = iUserMapper.getPersinList();
        for (entity.Person p :list){
            System.out.println(p.getPid()+"--"+p.getUsername()+"--"+p.getPassword());
        }
    }
}
