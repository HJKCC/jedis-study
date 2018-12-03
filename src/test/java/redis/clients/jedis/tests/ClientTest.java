package redis.clients.jedis.tests;

import org.apache.commons.pool2.impl.DefaultPooledObject;
import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author chencheng0816@gmail.com
 * @date 2018/12/3 14:28
 * @Description ClientTest
 */
public class ClientTest {
	@Test
	public void set() {
		HostAndPort hnp = new HostAndPort("192.168.128.10", 6379);

		JedisPool pool = new JedisPool(new JedisPoolConfig(), hnp.getHost(), hnp.getPort(), 2000);
		Jedis jedis = pool.getResource();
		jedis.set("foo", "bar");
		assertEquals("bar", jedis.get("foo"));
		System.out.println(jedis.get("foo"));
		jedis.close();
		pool.destroy();
		assertTrue(pool.isClosed());
	}
}
