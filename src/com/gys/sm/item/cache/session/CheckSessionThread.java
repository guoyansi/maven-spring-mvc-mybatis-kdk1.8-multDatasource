package com.gys.sm.item.cache.session;

import java.util.Map;

import com.gys.sm.item.bean.BaseSession;

public class CheckSessionThread implements Runnable {
    public static boolean start=false;
    public void run() {
        while (start){
            long currentTime=System.currentTimeMillis();
            Map<String,BaseSession> map=SessionCache.getCacheMap();
            for(Map.Entry<String,BaseSession> session:map.entrySet()){
                BaseSession user=session.getValue();
                if(currentTime-user.getStartTime()>user.getCycle()){//超时
                    SessionCache.remove(user.getAccessToken());
                }
            }
        }
        try {
            Thread.sleep(5000);
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
