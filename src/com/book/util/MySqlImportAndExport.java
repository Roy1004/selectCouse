package com.book.util;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * 在进行导出的时候，需要注意命令语句的运行环境，如果已经将mysql安装路径下的bin加入到
 * 系统的path变量中，那么在导出的时候可以直接使用命令语句，否则，就需要在执行命令语句的
 * 时候加上命令所在位置的路径，即mysql安装路径想的bin下的mysqldump命令
 * @author andy
 *
 */
public class MySqlImportAndExport {

    /**
     * 根据属性文件的配置导出指定位置的指定数据库到指定位置
     * @throws IOException
     */
    public static void SqlExport() throws IOException {
        InputStream is = MySqlImportAndExport.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(is);
        Runtime runtime = Runtime.getRuntime();
        String command = getExportCommand(properties);
        runtime.exec(command);//这里简单一点异常我就直接往上抛
    }


    /**
     * 利用属性文件提供的配置来拼装命令语句
     * 在拼装命令语句的时候有一点是需要注意的：一般我们在命令窗口直接使用命令来
     * 进行导出的时候可以简单使用“>”来表示导出到什么地方，即mysqldump -uusername -ppassword databaseName > exportPath，
     * 但在Java中这样写是不行的，它需要你用-r明确的指出导出到什么地方，如：
     * mysqldump -uusername -ppassword databaseName -r exportPath。
     * @param properties
     * @return
     */
    private static String getExportCommand(Properties properties) {
        URL path = Thread.currentThread().getContextClassLoader().getResource("");
        File classes = new File(path.getPath());
        File web_inf = classes.getParentFile();
        File webapp = web_inf.getParentFile();

        StringBuffer command = new StringBuffer();
        String username = properties.getProperty("db.username");//用户名
        String password = properties.getProperty("db.password");//用户密码
        String address = properties.getProperty("db.url");
        String exportDatabaseName = address.substring(address.lastIndexOf("/") + 1, address.length());
        String exportPath = webapp.toString();
    
        command.append("mysqldump -u ").append(username).append(" -p ").append(password)
                .append(" ").append(exportDatabaseName).append(" -r ").append(exportPath);
        System.out.println(command.toString());
        return command.toString();
    }

}