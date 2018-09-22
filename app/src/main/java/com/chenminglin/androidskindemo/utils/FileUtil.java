package com.chenminglin.androidskindemo.utils;

import android.content.Context;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {


    public static void copySkinToSDCard(Context context) {
        File skinDir = initSkinDir(context);
        if (skinDir.exists()) {
            try {
                File toFile = new File(skinDir.getAbsolutePath() + File.separator + "skin.skin");
                if (toFile.exists()) {
                    return;
                }

                InputStream is = context.getAssets().open("skin.skin");
                OutputStream os = new FileOutputStream(toFile);
                int byteCount;
                byte[] bytes = new byte[1024];

                while ((byteCount = is.read(bytes)) != -1) {
                    os.write(bytes, 0, byteCount);
                }
                os.close();
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private static File initSkinDir(Context context) {
        String skinPath = context.getExternalCacheDir().getPath() + File.separator + "skin.skin";
        File skinDir = new File(skinPath);
        if (!skinDir.exists()) {
            skinDir.mkdir();
            return skinDir;
        }
        return skinDir;
    }

    public static String getSkinDir(Context context) {
        File dir = initSkinDir(context);
        return dir.getAbsolutePath();
    }

}
