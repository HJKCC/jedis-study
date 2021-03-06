package redis.clients.jedis.tests.commands;

import static org.junit.Assert.assertArrayEquals;

import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.Before;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.tests.HostAndPortUtil;

public abstract class JedisCommandTestBase {
//  protected static HostAndPort hnp = HostAndPortUtil.getRedisServers().get(0);
  protected static HostAndPort hnp = new HostAndPort("192.168.110.40", 6379);

  protected Jedis jedis;

  public JedisCommandTestBase() {
    super();
  }

  /**
   * 建立和redis服务的tcp连接
   * @throws Exception
   */
  @Before
  public void setUp() throws Exception {
    jedis = new Jedis(hnp.getHost(), hnp.getPort(), 500);
    jedis.connect();
//    jedis.auth("foobared");
    jedis.flushAll();
  }

  /**
   * 断开和redis服务的tcp连接
   */
  @After
  public void tearDown() {
    jedis.disconnect();
  }

  protected Jedis createJedis() {
    Jedis j = new Jedis(hnp);
    j.connect();
    j.auth("foobared");
    j.flushAll();
    return j;
  }

  protected boolean arrayContains(List<byte[]> array, byte[] expected) {
    for (byte[] a : array) {
      try {
        assertArrayEquals(a, expected);
        return true;
      } catch (AssertionError e) {

      }
    }
    return false;
  }

  protected boolean setContains(Set<byte[]> set, byte[] expected) {
    for (byte[] a : set) {
      try {
        assertArrayEquals(a, expected);
        return true;
      } catch (AssertionError e) {

      }
    }
    return false;
  }
}
