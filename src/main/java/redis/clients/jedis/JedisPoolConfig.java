package redis.clients.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class JedisPoolConfig extends GenericObjectPoolConfig {
  public JedisPoolConfig() {
    // defaults to make your life with connection pool easier :) 默认资源池设置
    setTestWhileIdle(true);  //在空闲时检查有效性
    setMinEvictableIdleTimeMillis(60000);  //逐出连接的最小空闲时间为60000毫秒(1分钟)
    setTimeBetweenEvictionRunsMillis(30000);  //逐出扫描的时间间隔(30s) 如果为负数,则不运行逐出线程
    setNumTestsPerEvictionRun(-1);
  }
}
