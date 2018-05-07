package com.gys.sm.item.cache.session;

import com.gys.sm.item.bean.BaseSession;
import java.util.HashMap;
import java.util.Map;

public class SessionCache {
    private static Map<String,BaseSession> cacheMap=new HashMap<String, BaseSession>();

    protected static Map<String,BaseSession> getCacheMap(){
        return cacheMap;
    }

    public static void put(String key,BaseSession user){
        synchronized (cacheMap){
            cacheMap.put(key,user);
            if(!CheckSessionThread.start){//线程未启动
                CheckSessionThread checkThread=new CheckSessionThread();
                Thread thread=new Thread(checkThread);
                thread.start();
            }
        }
    }
    public static void remove(String key){
        synchronized (cacheMap){
            cacheMap.remove(key);
            if(cacheMap.isEmpty()){
                CheckSessionThread.start=false;
            }
        }
    }

    /**
     * 默认获取session是重新设置开始时间的
     * @param key
     * @return
     */
    public static BaseSession get(String key){
        synchronized (cacheMap){
            if(cacheMap.containsKey(key)){
                BaseSession userSession=cacheMap.get(key);
                userSession.setStartTime(System.currentTimeMillis());
                return userSession;
            }else{
                return null;
            }
        }
    }

    /**
     *  获取session是设置开始时间
     * @param key
     * @param isSetStartTime  是否设置开始时间 true，false
     * @return
     */
    public static BaseSession get(String key,boolean isSetStartTime){
        synchronized (cacheMap){
            if(cacheMap.containsKey(key)){
                BaseSession userSession=cacheMap.get(key);
                if(isSetStartTime){
                    userSession.setStartTime(System.currentTimeMillis());
                }
                return userSession;
            }else{
                return null;
            }
        }
    }
}
