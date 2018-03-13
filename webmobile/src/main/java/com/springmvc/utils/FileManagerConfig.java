package com.springmvc.utils;

import java.io.Serializable;

/**
 * Created by tangminghui on 2017/10/14.
 */
public interface FileManagerConfig extends Serializable {

    public static final String FILE_DEFAULT_WIDTH = "120";
    public static final String FILE_DEFAULT_HEIGHT = "120";
    public static final String FILE_DEFAULT_AUTHOR = "DIANDI";

    public static final String PROTOCOL = "http://";

    public static final String SEPARATOR = "/";

    public static final String TRACKER_NGNIX_PORT 	= "8080";
//    代理服务器配置地址
    public static final String CLIENT_CONFIG_FILE   = "fdfs_client.conf";
}
