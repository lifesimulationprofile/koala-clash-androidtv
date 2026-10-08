package com.github.kr328.clash.design.model;

import java.util.Date;
import java.util.regex.Matcher;
import kotlin.collections.ReversedListReadOnly;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatcherMatchResult;
import kotlin.text.Regex;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class LogFile {
    public static final Regex REGEX_FILE = new Regex("clash-(\\d+).log");
    public final Date date;
    public final String fileName;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public abstract class Companion {
        public static LogFile parseFromFileName(String str) {
            Matcher matcher = LogFile.REGEX_FILE.nativePattern.matcher(str);
            MatcherMatchResult matcherMatchResult = !matcher.matches() ? null : new MatcherMatchResult(matcher, str);
            if (matcherMatchResult == null) {
                return null;
            }
            if (matcherMatchResult.groupValues_ == null) {
                matcherMatchResult.groupValues_ = new ReversedListReadOnly(1, matcherMatchResult);
            }
            return new LogFile(str, new Date(Long.parseLong((String) matcherMatchResult.groupValues_.get(1))));
        }
    }

    public LogFile(String str, Date date) {
        this.fileName = str;
        this.date = date;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LogFile)) {
            return false;
        }
        LogFile logFile = (LogFile) obj;
        return Intrinsics.areEqual(this.fileName, logFile.fileName) && Intrinsics.areEqual(this.date, logFile.date);
    }

    public final int hashCode() {
        return this.date.hashCode() + (this.fileName.hashCode() * 31);
    }

    public final String toString() {
        return "LogFile(fileName=" + this.fileName + ", date=" + this.date + ")";
    }
}
