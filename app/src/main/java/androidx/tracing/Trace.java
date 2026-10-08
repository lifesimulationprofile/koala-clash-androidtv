package androidx.tracing;

import android.os.Build;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class Trace {
    public static Method asyncTraceBeginMethod;
    public static Method asyncTraceEndMethod;
    public static Method isTagEnabledMethod;
    public static Method traceCounterMethod;
    public static long traceTagApp;

    public static final void beginAsyncSection(String str) throws Throwable {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.beginAsyncSection(truncatedTraceSectionLabel(str));
            return;
        }
        String strTruncatedTraceSectionLabel = truncatedTraceSectionLabel(str);
        try {
            if (asyncTraceBeginMethod == null) {
                asyncTraceBeginMethod = android.os.Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = asyncTraceBeginMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            method.invoke(null, Long.valueOf(traceTagApp), strTruncatedTraceSectionLabel, 0);
        } catch (Exception e) {
            handleException("asyncTraceBegin", e);
        }
    }

    public static final void beginSection(String str) {
        android.os.Trace.beginSection(truncatedTraceSectionLabel(str));
    }

    public static final void endAsyncSection(String str, int i) throws Throwable {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.endAsyncSection(truncatedTraceSectionLabel(str), i);
            return;
        }
        String strTruncatedTraceSectionLabel = truncatedTraceSectionLabel(str);
        try {
            if (asyncTraceEndMethod == null) {
                asyncTraceEndMethod = android.os.Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = asyncTraceEndMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            method.invoke(null, Long.valueOf(traceTagApp), strTruncatedTraceSectionLabel, Integer.valueOf(i));
        } catch (Exception e) {
            handleException("asyncTraceEnd", e);
        }
    }

    public static void handleException(String str, Exception exc) throws Throwable {
        if (exc instanceof InvocationTargetException) {
            Throwable cause = ((InvocationTargetException) exc).getCause();
            if (!(cause instanceof RuntimeException)) {
                throw new RuntimeException(cause);
            }
            throw cause;
        }
        Log.v("Trace", "Unable to call " + str + " via reflection", exc);
    }

    public static final boolean isEnabled() throws Throwable {
        if (Build.VERSION.SDK_INT >= 29) {
            return TraceApi29Impl.isEnabled();
        }
        try {
            if (isTagEnabledMethod == null) {
                traceTagApp = android.os.Trace.class.getField("TRACE_TAG_APP").getLong(null);
                isTagEnabledMethod = android.os.Trace.class.getMethod("isTagEnabled", Long.TYPE);
            }
            Method method = isTagEnabledMethod;
            if (method != null) {
                return ((Boolean) method.invoke(null, Long.valueOf(traceTagApp))).booleanValue();
            }
            throw new IllegalArgumentException("Required value was null.");
        } catch (Exception e) {
            handleException("isTagEnabled", e);
            return false;
        }
    }

    public static final void setCounter(String str, int i) throws Throwable {
        if (Build.VERSION.SDK_INT >= 29) {
            TraceApi29Impl.setCounter(truncatedTraceSectionLabel(str), i);
            return;
        }
        String strTruncatedTraceSectionLabel = truncatedTraceSectionLabel(str);
        try {
            if (traceCounterMethod == null) {
                traceCounterMethod = android.os.Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            }
            Method method = traceCounterMethod;
            if (method == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            method.invoke(null, Long.valueOf(traceTagApp), strTruncatedTraceSectionLabel, Integer.valueOf(i));
        } catch (Exception e) {
            handleException("traceCounter", e);
        }
    }

    public static String truncatedTraceSectionLabel(String str) {
        String str2 = str.length() <= 127 ? str : null;
        return str2 == null ? str.substring(0, 127) : str2;
    }
}
