package ders2;

import java.time.LocalDate;

public class person implements Comparable<person>{
    private int id;
    private String name;
    private LocalDate birthday;

    public int getId() {
        return id;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public person(int id, String name, LocalDate birthday) {
        this.birthday = birthday;
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    @Override
    public String toString(){
        return "(" + id + " " + name + " " + birthday + ")";
    }
    @Override
    public int compareTo(person o){
        return this.birthday.isBefore(o.birthday)?-1:1;
    }
}
