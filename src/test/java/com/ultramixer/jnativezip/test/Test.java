package com.ultramixer.jnativezip.test;

import com.ultramixer.jnativezip.JNativeZip;
import com.ultramixer.jnativezip.JNativeZipException;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

import java.io.File;
import java.io.IOException;

/**
 * Created by TB on 27.06.16.
 */
public class Test
{
    @org.junit.Test
    public void test()
    {
        File unpackedDir = new File("tests/unpacked");
        try
        {
            FileUtils.forceMkdir(unpackedDir);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
        try
        {
            FileUtils.cleanDirectory(unpackedDir);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        Assert.assertTrue(unpackedDir.exists());
        try
        {
            JNativeZip.unzip(new File("tests/test.zip"), unpackedDir);
        }
        catch (JNativeZipException e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }

        try
        {
            FileUtils.deleteDirectory(unpackedDir);
        }
        catch (IOException e)
        {
            e.printStackTrace();
            Assert.fail(e.getMessage());
        }
    }
}
