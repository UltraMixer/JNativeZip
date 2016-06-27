package com.ultramixer.jnativezip;

/**
 * Created by TB on 27.06.16.
 */
public class JNativeZipException extends Exception
{
    public JNativeZipException()
    {
    }

    public JNativeZipException(String message)
    {
        super(message);
    }

    public JNativeZipException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public JNativeZipException(Throwable cause)
    {
        super(cause);
    }

    public JNativeZipException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
