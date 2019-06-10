package com.pinyougou.redis;

import java.util.*;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.Protocol;

import java.util.Properties;

public class JedisPoolTest {

    private static JedisPool jedisPool;

    static{
        JedisPoolConfig config = new JedisPoolConfig();
        Properties proptis;
        try {
            String pwd = "passw0rd";
            String host = "10.1.60.135";
            int port = 6379;
            int dataBase = 1;
            jedisPool=new JedisPool(config, host, port, Protocol.DEFAULT_TIMEOUT, pwd,dataBase);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JedisPool getRedisPool(){
        return jedisPool;
    }

    public static Jedis getRedis(){
        return jedisPool.getResource();
    }

//    public static void closeConn(Jedis jedis){
//        if(jedis!=null){
//            jedis.close();
//        }
//    }

    public static void main(String[] args) {
        Jedis jedis = getRedis();
//        Map<String,Object> chatInfos = new HashMap<>();
//        Map<String,Object> intelligentResult = new HashMap<>();
//        chatInfos.put("intelligentResult",intelligentResult);
//
//        Map<String,Object> intelligentMsgInfo = new HashMap<>();
//        chatInfos.put("intelligentMsgInfo",intelligentMsgInfo);
//
//        Map<String,Object> chatInfo = new HashMap<>();
//        chatInfos.put("chatInfo",chatInfo);
//
//        Map<String,Object> msgInfo = new HashMap<>();
//        chatInfos.put("msgInfo",msgInfo);

        Map<String,Object> buInfos = new HashMap<>();
        buInfos.put("buName","移动云");
        buInfos.put("buType","0");
        buInfos.put("parentCode","bu_icloud002");
        buInfos.put("state","1");
        buInfos.put("buCode","bu_icloud001");
        buInfos.put("welcomeConfig","你好");
        Map<String,Object> question1 = new HashMap<>();
        question1.put("paramAttr1","问题");
        question1.put("paramAttr2","答案");
        Map<String,Object> question2 = new HashMap<>();
        question2.put("paramAttr1","问题");
        question2.put("paramAttr2","答案");
        List<Map<String,Object>> list = new ArrayList<>();
        list.add(question1);
        list.add(question2);
        buInfos.put("questionConfig",list);
//
        Object[] onlineWaitingClients = new Object[0];
        Object[] onlineRespondClients = new Object[0];
        Object[] busyAgentsQueue = new Object[0];
        Object[] availableAgentsQueue = new Object[0];
        Object[] intelligentQuestion = new Object[0];
//
        buInfos.put("onlineWaitingClients",onlineWaitingClients);
        buInfos.put("onlineRespondClients",onlineRespondClients);
        buInfos.put("availableAgentsQueue",availableAgentsQueue);
        buInfos.put("intelligentQuestion",intelligentQuestion);
        buInfos.put("busyAgentsQueue",busyAgentsQueue);

//        Map<String,Object> onlineAgent = new HashMap<>();
//        Map<String,Object> onlineAgentInfo = new HashMap<>();
//        Map<String,Object> onlineAgentSocket = new HashMap<>();
//        onlineAgent.put("onlineAgentInfo",onlineAgentInfo);
//        onlineAgent.put("onlineAgentSocket",onlineAgentSocket);
        jedis.hset("buInfos","bu_icloud001", JSON.toJSONString(buInfos));
    }
}
