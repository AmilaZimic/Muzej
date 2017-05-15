package com.example.dana.muzej;

public class RowItem {

    private String member_name;
    private int profile_pic_id;
    private String status;

    public RowItem(String place_name, int place_pic_id, String street) {

        this.member_name = place_name;
        this.profile_pic_id = place_pic_id;
        this.status = street;
    }

    public String getMember_name() {
        return member_name;
    }

    public void setMember_name(String member_name) {
        this.member_name = member_name;
    }

    public int getProfile_pic_id() {
        return profile_pic_id;
    }

    public void setProfile_pic_id(int profile_pic_id) {
        this.profile_pic_id = profile_pic_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}