package redis.clients.jedis.tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import redis.clients.jedis.BuilderFactory;

public class BuilderFactoryTest {
  @Test
  public void buildDouble() {
    Double build = BuilderFactory.DOUBLE.build("1.0".getBytes());   //BuilderFactory生产一个Double对象
    assertEquals(new Double(1.0), build);   //判断两个值是否相等，如果相等，则运行success，反之Failure

    build = BuilderFactory.DOUBLE.build("inf".getBytes());
    assertEquals(new Double(Double.POSITIVE_INFINITY), build);

    build = BuilderFactory.DOUBLE.build("+inf".getBytes());
    assertEquals(new Double(Double.POSITIVE_INFINITY), build);

    build = BuilderFactory.DOUBLE.build("-inf".getBytes());
    assertEquals(new Double(Double.NEGATIVE_INFINITY), build);
  }
}