package java_account;

import com.mysql.jdbc.PreparedStatement;

class ListStudents {

    private final int id;

    private final String name;
    private final float age;
    private final String date;
    private final byte[] picture;

    public ListStudents(int rid, String rname, float rage, String rdate, byte[] rimg) {
        this.id = rid;
        this.name = rname;
        this.age = rage;
        this.date = rdate;
        this.picture = rimg;

    }

    private PreparedStatement PreparedStatement(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId() {

        return id;
    }

    public String getName() {
        return name;

    }

    public float getAge() {

        return age;

    }

    public String getDate() {

        return date;

    }

    public byte[] getImage() {

        return picture;

    }

}
