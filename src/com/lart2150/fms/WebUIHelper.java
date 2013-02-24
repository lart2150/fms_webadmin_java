/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lart2150.fms;

import com.filemaker.adminserver.*;
import com.filemaker.adminserver.dbs.*;
import java.util.*;
/**
 *
 * @author lart
 */
public class WebUIHelper {
    protected static HashMap<String, Integer> sessions = new HashMap<String, Integer>();
    
    public static boolean adminLogin(String username, String password) throws AdminServerException, DBSConnectionException{
        DBSManager dbsManager = ServerSingleton.getDBSManager();
        
        AdminServerSessionManager localAdminServerSessionManager = AdminServerSessionManager.getInstance();
        localAdminServerSessionManager.createSession(username, username, username, AdminServerSessionManager.UserType.INVALID, null);

        if (username.equals(dbsManager.getAttributeValue("admin.username")) &&
                password.equals(dbsManager.getAttributeValue("admin.password")))
        {
            AdminServerManager manager = ServerSingleton.getAdminServerManager();
            //could use this for auth and that would support groups as -1 is bad auth
            int sessionid = manager.registerSession(username, password, "127.0.0.1", "don't know what this is :(");
            sessions.remove(username);
            sessions.put(username, sessionid);
            return true;
        }
        return false;
    }
    
    public static int getSession(String username) {
        return sessions.get(username);
    }
    
}
