package com.ultramixer.jnativezip;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.File;
import java.io.IOException;

/**
 * Created by TB on 27.06.16.
 */
public class JNativeZip
{
    public static void unzip(File zipFile, File destDir) throws JNativeZipException
    {
        unzip(zipFile, destDir, false);
    }

    public static void unzip(File zipFile, File destDir, boolean overwrite) throws JNativeZipException
    {
        String line = "unzip";
        CommandLine cmdLine = CommandLine.parse(line);
        cmdLine.addArgument("-u");
        if (overwrite)
        {
            cmdLine.addArgument("-o");
        }
        cmdLine.addArgument("-d");
        cmdLine.addArgument(destDir.getAbsolutePath());
        cmdLine.addArgument(zipFile.getAbsolutePath());

        DefaultExecutor executor = new DefaultExecutor();
        try
        {
            int exitValue = executor.execute(cmdLine);
            //System.out.println("exitValue = " + exitValue);
            if (exitValue != 0)
            {
                throw new JNativeZipException("Exit Value not 0: " + exitValue);
            }
        }
        catch (IOException e)
        {
            throw new JNativeZipException(e);
        }
    }

}
