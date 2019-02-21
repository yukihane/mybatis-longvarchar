package com.github.yukihane.mybatis.mapper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.JDBCType;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class LongvarcharTableMapperTest {

    @Test
    public void test() throws IOException, SQLException {

        final String resource = "mybatis-config.xml";
        final InputStream inputStream = Resources.getResourceAsStream(resource);
        final SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        try (final SqlSession sess = sqlSessionFactory.openSession()) {

            final Connection conn = sess.getConnection();
            try (final ResultSet rs = conn.createStatement()
                    .executeQuery("select longvarchar_column from longvarchar_table")) {

                final int sqlType = rs.getMetaData().getColumnType(1);
                System.out.println("JDBCType: " + JDBCType.valueOf(sqlType));
                assertEquals(Types.LONGVARCHAR, sqlType);
            }

            final LongvarcharTableMapper mapper = sess.getMapper(LongvarcharTableMapper.class);

            mapper.insert("hello, longvarchar");

            final List<String> texts = mapper.select();
            assertTrue(texts.size() > 0);

            sess.commit();
        }

    }

}
