/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lart2150.fms;


import com.filemaker.adminserver.*;
import com.filemaker.adminserver.dbs.*;
/**
 *
 * @author lart
 */
public class ServerSingleton {
    protected static DBSManager dbsMan = null;
    protected static AdminServerManager adminMannager = null;
    public static synchronized DBSManager getDBSManager() throws AdminServerException, DBSConnectionException{
        if (dbsMan == null){
            dbsMan = new com.filemaker.adminserver.dbs.DBSManager();
        }
        return dbsMan;
    }
    public static synchronized AdminServerManager getAdminServerManager() throws AdminServerException, DBSConnectionException{
        if (adminMannager == null){
            adminMannager = new AdminServerManager();
        }
        return adminMannager;
    }
}
