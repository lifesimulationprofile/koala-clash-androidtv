package androidx.room.util;

import android.database.Cursor;
import androidx.camera.core.ImageAnalysis$$ExternalSyntheticLambda1;
import androidx.compose.ui.Modifier;
import androidx.sqlite.db.framework.FrameworkSQLiteDatabase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
/* JADX INFO: loaded from: classes.dex */
public final class TableInfo {
    public final Map columns;
    public final Set foreignKeys;
    public final Set indices;
    public final String name;

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Column {
        public final int affinity;
        public final String defaultValue;
        public final int mCreatedFrom;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public Column(String str, String str2, boolean z, int i, String str3, int i2) {
            this.name = str;
            this.type = str2;
            this.notNull = z;
            this.primaryKeyPosition = i;
            int i3 = 5;
            if (str2 != null) {
                String upperCase = str2.toUpperCase(Locale.US);
                if (upperCase.contains("INT")) {
                    i3 = 3;
                } else if (upperCase.contains("CHAR") || upperCase.contains("CLOB") || upperCase.contains("TEXT")) {
                    i3 = 2;
                } else if (!upperCase.contains("BLOB")) {
                    i3 = (upperCase.contains("REAL") || upperCase.contains("FLOA") || upperCase.contains("DOUB")) ? 4 : 1;
                }
            }
            this.affinity = i3;
            this.defaultValue = str3;
            this.mCreatedFrom = i2;
        }

        public static boolean defaultValueEquals(String str, String str2) {
            if (str2 == null) {
                return false;
            }
            if (str.equals(str2)) {
                return true;
            }
            if (str.length() != 0) {
                int i = 0;
                for (int i2 = 0; i2 < str.length(); i2++) {
                    char cCharAt = str.charAt(i2);
                    if (i2 != 0 || cCharAt == '(') {
                        if (cCharAt == '(') {
                            i++;
                        } else if (cCharAt != ')' || (i = i - 1) != 0 || i2 == str.length() - 1) {
                        }
                    }
                }
                if (i == 0) {
                    return str.substring(1, str.length() - 1).trim().equals(str2);
                }
            }
            return false;
        }

        public final boolean equals(Object obj) {
            if (this != obj) {
                if (!(obj instanceof Column)) {
                    return false;
                }
                Column column = (Column) obj;
                int i = column.mCreatedFrom;
                String str = column.defaultValue;
                if (this.primaryKeyPosition != column.primaryKeyPosition || !this.name.equals(column.name) || this.notNull != column.notNull) {
                    return false;
                }
                String str2 = this.defaultValue;
                int i2 = this.mCreatedFrom;
                if (i2 == 1 && i == 2 && str2 != null && !defaultValueEquals(str2, str)) {
                    return false;
                }
                if (i2 == 2 && i == 1 && str != null && !defaultValueEquals(str, str2)) {
                    return false;
                }
                if (i2 != 0 && i2 == i) {
                    if (str2 != null) {
                        if (!defaultValueEquals(str2, str)) {
                            return false;
                        }
                    } else if (str != null) {
                        return false;
                    }
                }
                if (this.affinity != column.affinity) {
                    return false;
                }
            }
            return true;
        }

        public final int hashCode() {
            return (((((this.name.hashCode() * 31) + this.affinity) * 31) + (this.notNull ? 1231 : 1237)) * 31) + this.primaryKeyPosition;
        }

        public final String toString() {
            StringBuilder sb = new StringBuilder("Column{name='");
            sb.append(this.name);
            sb.append("', type='");
            sb.append(this.type);
            sb.append("', affinity='");
            sb.append(this.affinity);
            sb.append("', notNull=");
            sb.append(this.notNull);
            sb.append(", primaryKeyPosition=");
            sb.append(this.primaryKeyPosition);
            sb.append(", defaultValue='");
            return ImageAnalysis$$ExternalSyntheticLambda1.m(sb, this.defaultValue, "'}");
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ForeignKey {
        public final List columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List list, List list2) {
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = Collections.unmodifiableList(list);
            this.referenceColumnNames = Collections.unmodifiableList(list2);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ForeignKey)) {
                return false;
            }
            ForeignKey foreignKey = (ForeignKey) obj;
            if (this.referenceTable.equals(foreignKey.referenceTable) && this.onDelete.equals(foreignKey.onDelete) && this.onUpdate.equals(foreignKey.onUpdate) && this.columnNames.equals(foreignKey.columnNames)) {
                return this.referenceColumnNames.equals(foreignKey.referenceColumnNames);
            }
            return false;
        }

        public final int hashCode() {
            return this.referenceColumnNames.hashCode() + ((this.columnNames.hashCode() + Modifier.CC.m(Modifier.CC.m(this.referenceTable.hashCode() * 31, 31, this.onDelete), 31, this.onUpdate)) * 31);
        }

        public final String toString() {
            return "ForeignKey{referenceTable='" + this.referenceTable + "', onDelete='" + this.onDelete + "', onUpdate='" + this.onUpdate + "', columnNames=" + this.columnNames + ", referenceColumnNames=" + this.referenceColumnNames + '}';
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class ForeignKeyWithSequence implements Comparable {
        public final String mFrom;
        public final int mId;
        public final int mSequence;
        public final String mTo;

        public ForeignKeyWithSequence(int i, int i2, String str, String str2) {
            this.mId = i;
            this.mSequence = i2;
            this.mFrom = str;
            this.mTo = str2;
        }

        @Override // java.lang.Comparable
        public final int compareTo(Object obj) {
            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
            int i = this.mId - foreignKeyWithSequence.mId;
            return i == 0 ? this.mSequence - foreignKeyWithSequence.mSequence : i;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-0d0aa97d1fad3edd99b81b175d33e009605b3d4793e5c1d21bed0e5a39522f8f */
    public final class Index {
        public final ArrayList columns;
        public final String name;
        public final List orders;
        public final boolean unique;

        public Index(String str, boolean z, ArrayList arrayList, ArrayList arrayList2) {
            this.name = str;
            this.unique = z;
            this.columns = arrayList;
            this.orders = arrayList2.size() == 0 ? Collections.nCopies(arrayList.size(), "ASC") : arrayList2;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Index)) {
                return false;
            }
            Index index = (Index) obj;
            String str = index.name;
            if (this.unique != index.unique || !this.columns.equals(index.columns) || !this.orders.equals(index.orders)) {
                return false;
            }
            String str2 = this.name;
            return str2.startsWith("index_") ? str.startsWith("index_") : str2.equals(str);
        }

        public final int hashCode() {
            String str = this.name;
            return this.orders.hashCode() + ((this.columns.hashCode() + ((((str.startsWith("index_") ? -1184239155 : str.hashCode()) * 31) + (this.unique ? 1 : 0)) * 31)) * 31);
        }

        public final String toString() {
            return "Index{name='" + this.name + "', unique=" + this.unique + ", columns=" + this.columns + ", orders=" + this.orders + '}';
        }
    }

    public TableInfo(String str, HashMap map, HashSet hashSet, HashSet hashSet2) {
        this.name = str;
        this.columns = Collections.unmodifiableMap(map);
        this.foreignKeys = Collections.unmodifiableSet(hashSet);
        this.indices = hashSet2 == null ? null : Collections.unmodifiableSet(hashSet2);
    }

    public static TableInfo read(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str) {
        ArrayList arrayList;
        Cursor cursorQuery = frameworkSQLiteDatabase.query("PRAGMA table_info(`" + str + "`)");
        HashMap map = new HashMap();
        try {
            if (cursorQuery.getColumnCount() > 0) {
                int columnIndex = cursorQuery.getColumnIndex("name");
                int columnIndex2 = cursorQuery.getColumnIndex("type");
                int columnIndex3 = cursorQuery.getColumnIndex("notnull");
                int columnIndex4 = cursorQuery.getColumnIndex("pk");
                int columnIndex5 = cursorQuery.getColumnIndex("dflt_value");
                while (cursorQuery.moveToNext()) {
                    String string = cursorQuery.getString(columnIndex);
                    map.put(string, new Column(string, cursorQuery.getString(columnIndex2), cursorQuery.getInt(columnIndex3) != 0, cursorQuery.getInt(columnIndex4), cursorQuery.getString(columnIndex5), 2));
                }
            }
            cursorQuery.close();
            HashSet hashSet = new HashSet();
            Cursor cursorQuery2 = frameworkSQLiteDatabase.query("PRAGMA foreign_key_list(`" + str + "`)");
            try {
                int columnIndex6 = cursorQuery2.getColumnIndex("id");
                int columnIndex7 = cursorQuery2.getColumnIndex("seq");
                int columnIndex8 = cursorQuery2.getColumnIndex("table");
                int columnIndex9 = cursorQuery2.getColumnIndex("on_delete");
                int columnIndex10 = cursorQuery2.getColumnIndex("on_update");
                ArrayList foreignKeyFieldMappings = readForeignKeyFieldMappings(cursorQuery2);
                int count = cursorQuery2.getCount();
                int i = 0;
                while (i < count) {
                    cursorQuery2.moveToPosition(i);
                    if (cursorQuery2.getInt(columnIndex7) != 0) {
                        arrayList = foreignKeyFieldMappings;
                    } else {
                        int i2 = cursorQuery2.getInt(columnIndex6);
                        ArrayList arrayList2 = new ArrayList();
                        ArrayList arrayList3 = new ArrayList();
                        int size = foreignKeyFieldMappings.size();
                        int i3 = 0;
                        while (i3 < size) {
                            Object obj = foreignKeyFieldMappings.get(i3);
                            i3++;
                            int i4 = size;
                            ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
                            ArrayList arrayList4 = foreignKeyFieldMappings;
                            if (foreignKeyWithSequence.mId == i2) {
                                arrayList2.add(foreignKeyWithSequence.mFrom);
                                arrayList3.add(foreignKeyWithSequence.mTo);
                            }
                            size = i4;
                            foreignKeyFieldMappings = arrayList4;
                        }
                        arrayList = foreignKeyFieldMappings;
                        hashSet.add(new ForeignKey(cursorQuery2.getString(columnIndex8), cursorQuery2.getString(columnIndex9), cursorQuery2.getString(columnIndex10), arrayList2, arrayList3));
                    }
                    i++;
                    columnIndex6 = columnIndex6;
                    columnIndex7 = columnIndex7;
                    count = count;
                    foreignKeyFieldMappings = arrayList;
                }
                cursorQuery2.close();
                Cursor cursorQuery3 = frameworkSQLiteDatabase.query("PRAGMA index_list(`" + str + "`)");
                try {
                    int columnIndex11 = cursorQuery3.getColumnIndex("name");
                    int columnIndex12 = cursorQuery3.getColumnIndex("origin");
                    int columnIndex13 = cursorQuery3.getColumnIndex("unique");
                    HashSet hashSet2 = null;
                    if (columnIndex11 != -1 && columnIndex12 != -1 && columnIndex13 != -1) {
                        HashSet hashSet3 = new HashSet();
                        while (true) {
                            if (!cursorQuery3.moveToNext()) {
                                cursorQuery3.close();
                                hashSet2 = hashSet3;
                                break;
                            }
                            if ("c".equals(cursorQuery3.getString(columnIndex12))) {
                                Index index = readIndex(frameworkSQLiteDatabase, cursorQuery3.getString(columnIndex11), cursorQuery3.getInt(columnIndex13) == 1);
                                if (index == null) {
                                    cursorQuery3.close();
                                    break;
                                }
                                hashSet3.add(index);
                            }
                        }
                    } else {
                        cursorQuery3.close();
                        break;
                    }
                    return new TableInfo(str, map, hashSet, hashSet2);
                } catch (Throwable th) {
                    cursorQuery3.close();
                    throw th;
                }
            } catch (Throwable th2) {
                cursorQuery2.close();
                throw th2;
            }
        } catch (Throwable th3) {
            cursorQuery.close();
            throw th3;
        }
    }

    public static ArrayList readForeignKeyFieldMappings(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        int columnIndex2 = cursor.getColumnIndex("seq");
        int columnIndex3 = cursor.getColumnIndex("from");
        int columnIndex4 = cursor.getColumnIndex("to");
        int count = cursor.getCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < count; i++) {
            cursor.moveToPosition(i);
            arrayList.add(new ForeignKeyWithSequence(cursor.getInt(columnIndex), cursor.getInt(columnIndex2), cursor.getString(columnIndex3), cursor.getString(columnIndex4)));
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public static Index readIndex(FrameworkSQLiteDatabase frameworkSQLiteDatabase, String str, boolean z) {
        Cursor cursorQuery = frameworkSQLiteDatabase.query("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndex = cursorQuery.getColumnIndex("seqno");
            int columnIndex2 = cursorQuery.getColumnIndex("cid");
            int columnIndex3 = cursorQuery.getColumnIndex("name");
            int columnIndex4 = cursorQuery.getColumnIndex("desc");
            if (columnIndex != -1 && columnIndex2 != -1 && columnIndex3 != -1 && columnIndex4 != -1) {
                TreeMap treeMap = new TreeMap();
                TreeMap treeMap2 = new TreeMap();
                while (cursorQuery.moveToNext()) {
                    if (cursorQuery.getInt(columnIndex2) >= 0) {
                        int i = cursorQuery.getInt(columnIndex);
                        String string = cursorQuery.getString(columnIndex3);
                        String str2 = cursorQuery.getInt(columnIndex4) > 0 ? "DESC" : "ASC";
                        treeMap.put(Integer.valueOf(i), string);
                        treeMap2.put(Integer.valueOf(i), str2);
                    }
                }
                ArrayList arrayList = new ArrayList(treeMap.size());
                arrayList.addAll(treeMap.values());
                ArrayList arrayList2 = new ArrayList(treeMap2.size());
                arrayList2.addAll(treeMap2.values());
                return new Index(str, z, arrayList, arrayList2);
            }
            return null;
        } finally {
            cursorQuery.close();
        }
    }

    public final boolean equals(Object obj) {
        Set set;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo = (TableInfo) obj;
        Set set2 = tableInfo.foreignKeys;
        Map map = tableInfo.columns;
        String str = tableInfo.name;
        String str2 = this.name;
        if (str2 == null ? str != null : !str2.equals(str)) {
            return false;
        }
        Map map2 = this.columns;
        if (map2 == null ? map != null : !map2.equals(map)) {
            return false;
        }
        Set set3 = this.foreignKeys;
        if (set3 == null ? set2 != null : !set3.equals(set2)) {
            return false;
        }
        Set set4 = this.indices;
        if (set4 == null || (set = tableInfo.indices) == null) {
            return true;
        }
        return set4.equals(set);
    }

    public final int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        Map map = this.columns;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        Set set = this.foreignKeys;
        return iHashCode2 + (set != null ? set.hashCode() : 0);
    }

    public final String toString() {
        return "TableInfo{name='" + this.name + "', columns=" + this.columns + ", foreignKeys=" + this.foreignKeys + ", indices=" + this.indices + '}';
    }
}
