package com.map.pandora;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import com.map.pandora.PoiHistory;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table POI_HISTORY.
*/
public class PoiHistoryDao extends AbstractDao<PoiHistory, String> {

    public static final String TABLENAME = "POI_HISTORY";

    /**
     * Properties of entity PoiHistory.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Key = new Property(0, String.class, "key", true, "KEY");
        public final static Property City = new Property(1, String.class, "city", false, "CITY");
        public final static Property District = new Property(2, String.class, "district", false, "DISTRICT");
        public final static Property Timestamp = new Property(3, java.util.Date.class, "timestamp", false, "TIMESTAMP");
    };


    public PoiHistoryDao(DaoConfig config) {
        super(config);
    }
    
    public PoiHistoryDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'POI_HISTORY' (" + //
                "'KEY' TEXT PRIMARY KEY NOT NULL ," + // 0: key
                "'CITY' TEXT," + // 1: city
                "'DISTRICT' TEXT," + // 2: district
                "'TIMESTAMP' INTEGER);"); // 3: timestamp
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'POI_HISTORY'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, PoiHistory entity) {
        stmt.clearBindings();
 
        String key = entity.getKey();
        if (key != null) {
            stmt.bindString(1, key);
        }
 
        String city = entity.getCity();
        if (city != null) {
            stmt.bindString(2, city);
        }
 
        String district = entity.getDistrict();
        if (district != null) {
            stmt.bindString(3, district);
        }
 
        java.util.Date timestamp = entity.getTimestamp();
        if (timestamp != null) {
            stmt.bindLong(4, timestamp.getTime());
        }
    }

    /** @inheritdoc */
    @Override
    public String readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public PoiHistory readEntity(Cursor cursor, int offset) {
        PoiHistory entity = new PoiHistory( //
            cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0), // key
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // city
            cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2), // district
            cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)) // timestamp
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, PoiHistory entity, int offset) {
        entity.setKey(cursor.isNull(offset + 0) ? null : cursor.getString(offset + 0));
        entity.setCity(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setDistrict(cursor.isNull(offset + 2) ? null : cursor.getString(offset + 2));
        entity.setTimestamp(cursor.isNull(offset + 3) ? null : new java.util.Date(cursor.getLong(offset + 3)));
     }
    
    /** @inheritdoc */
    @Override
    protected String updateKeyAfterInsert(PoiHistory entity, long rowId) {
        return entity.getKey();
    }
    
    /** @inheritdoc */
    @Override
    public String getKey(PoiHistory entity) {
        if(entity != null) {
            return entity.getKey();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
