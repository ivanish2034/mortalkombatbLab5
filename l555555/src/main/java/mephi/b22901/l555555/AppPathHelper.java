/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.l555555;

/**
 *
 * @author ivis2
 */
import java.io.File;
import java.net.URISyntaxException;

public class AppPathHelper {
    private static String appDirectory;
    
    static {
        try {
            File jarFile = new File(AppPathHelper.class.getProtectionDomain()
                                  .getCodeSource()
                                  .getLocation()
                                  .toURI());
            appDirectory = jarFile.getParent();
        } catch (URISyntaxException e) {
            appDirectory = System.getProperty("user.dir");
        }
    }
    
    public static String getAppDirectory() {
        return appDirectory;
    }
    
    public static String getPathForResource(String filename) {
        return appDirectory + File.separator + filename;
    }
}