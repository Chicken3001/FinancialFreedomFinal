/*package com.example.grant.financialfreedom;

        import android.database.sqlite.SQLiteDatabase;
        import android.database.sqlite.SQLiteOpenHelper;
        import android.content.Context;
        import android.content.ContentValues;
        import android.database.Cursor;

public class MyDBHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "userDB.db";
    private static final String TABLE_USERS = "users";

    public static final String COLUMN_ID = "userName";
    public static final String COLUMN_USERINCOME = "userIncome";
    public static final String COLUMN_USEREXPENSES = "userExpenses";

    public MyDBHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, DATABASE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_ID + " TEXT," + COLUMN_USERINCOME + COLUMN_USEREXPENSES + " INTEGER" + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);
        onCreate(db);
    }

    public void addUser(User user){
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERINCOME, user.getUserIncome());
        values.put(COLUMN_USEREXPENSES, user.getUserExpenses());

        SQLiteDatabase db = this.getWritableDatabase();

        db.insert(TABLE_USERS, null, values);
        db.close();
    }

    public User findUser(String userName){
        String query = "Select * FROM " + TABLE_USERS + " WHERE " + COLUMN_ID + " = \"" + userName + "\"";

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(query, null);

        User user = new User();

        if (cursor.moveToFirst()){
            cursor.moveToFirst();
            user.setUserName(cursor.getString(0));
            user.setUserIncome(Double.parseDouble(cursor.getString(1)));
            user.setUserExpenses(Double.parseDouble(cursor.getString(2)));
            cursor.close();
        } else {
            user = null;
        }
        db.close();
        return user;
    }
}*/
