package com.book.util;

import java.io.*;
import java.net.URL;
import java.util.Properties;

/**
 * �ڽ��е�����ʱ����Ҫע�������������л���������Ѿ���mysql��װ·���µ�bin���뵽
 * ϵͳ��path�����У���ô�ڵ�����ʱ�����ֱ��ʹ��������䣬���򣬾���Ҫ��ִ����������
 * ʱ�������������λ�õ�·������mysql��װ·�����bin�µ�mysqldump����
 * @author andy
 *
 */
public class MySqlImportAndExport {

    /**
     * ���������ļ������õ���ָ��λ�õ�ָ�����ݿ⵽ָ��λ��
     * @throws IOException
     */
    public static void SqlExport() throws IOException {
        InputStream is = MySqlImportAndExport.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties = new Properties();
        properties.load(is);
        Runtime runtime = Runtime.getRuntime();
        String command = getExportCommand(properties);
        runtime.exec(command);//�����һ���쳣�Ҿ�ֱ��������
    }


    /**
     * ���������ļ��ṩ��������ƴװ�������
     * ��ƴװ��������ʱ����һ������Ҫע��ģ�һ�������������ֱ��ʹ��������
     * ���е�����ʱ����Լ�ʹ�á�>������ʾ������ʲô�ط�����mysqldump -uusername -ppassword databaseName > exportPath��
     * ����Java������д�ǲ��еģ�����Ҫ����-r��ȷ��ָ��������ʲô�ط����磺
     * mysqldump -uusername -ppassword databaseName -r exportPath��
     * @param properties
     * @return
     */
    private static String getExportCommand(Properties properties) {
        URL path = Thread.currentThread().getContextClassLoader().getResource("");
        File classes = new File(path.getPath());
        File web_inf = classes.getParentFile();
        File webapp = web_inf.getParentFile();

        StringBuffer command = new StringBuffer();
        String username = properties.getProperty("db.username");//�û���
        String password = properties.getProperty("db.password");//�û�����
        String address = properties.getProperty("db.url");
        String exportDatabaseName = address.substring(address.lastIndexOf("/") + 1, address.length());
        String exportPath = webapp.toString();
    
        command.append("mysqldump -u ").append(username).append(" -p ").append(password)
                .append(" ").append(exportDatabaseName).append(" -r ").append(exportPath);
        System.out.println(command.toString());
        return command.toString();
    }

}