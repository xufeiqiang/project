package com.cn.betasoft.redis.model;

import java.io.Serializable;

/**
 * Created by ZC-16-012 on 2018/7/31.
 */
public class HostModel implements Serializable {


    private static final long serialVersionUID = 6074895357346471187L;

    private String uuid;

    private String name;

    private String ip;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Override
    public String toString() {
        return "HostModel{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                '}';
    }
}
