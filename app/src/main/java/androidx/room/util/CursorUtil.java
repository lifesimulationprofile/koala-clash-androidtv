package androidx.room.util;

import android.database.Cursor;
import android.os.Build;
import android.util.Log;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import java.util.Arrays;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public abstract class CursorUtil {
    public static int getColumnIndexOrThrow(Cursor cursor, String str) {
        String string;
        int columnIndex = cursor.getColumnIndex(str);
        if (columnIndex < 0) {
            columnIndex = cursor.getColumnIndex("`" + str + "`");
            if (columnIndex < 0) {
                if (Build.VERSION.SDK_INT <= 25 && str.length() != 0) {
                    String[] columnNames = cursor.getColumnNames();
                    String strConcat = ".".concat(str);
                    String strM$1 = ImageAnalysis$$ExternalSyntheticLambda1.m$1(".", str, "`");
                    int i = 0;
                    while (true) {
                        if (i < columnNames.length) {
                            String str2 = columnNames[i];
                            if (str2.length() < str.length() + 2 || !(str2.endsWith(strConcat) || (str2.charAt(0) == '`' && str2.endsWith(strM$1)))) {
                                i++;
                            } else {
                                columnIndex = i;
                            }
                        } else {
                            columnIndex = -1;
                        }
                    }
                } else {
                    columnIndex = -1;
                }
            }
        }
        if (columnIndex >= 0) {
            return columnIndex;
        }
        try {
            string = Arrays.toString(cursor.getColumnNames());
        } catch (Exception e) {
            Log.d("RoomCursorUtil", "Cannot collect column names for debug purposes", e);
            string = "";
        }
        throw new IllegalArgumentException("column '" + str + "' does not exist. Available columns: " + string);
    }
}
