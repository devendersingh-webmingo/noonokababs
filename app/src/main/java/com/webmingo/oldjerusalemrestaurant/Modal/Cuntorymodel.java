package com.webmingo.oldjerusalemrestaurant.Modal;

public class Cuntorymodel {


    String name, id, phonecode, code;

    public Cuntorymodel(String name, String id, String phonecode, String code) {
        this.name = name;
        this.id = id;
        this.phonecode = phonecode;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhonecode() {
        return phonecode;
    }

    public void setPhonecode(String phonecode) {
        this.phonecode = phonecode;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
