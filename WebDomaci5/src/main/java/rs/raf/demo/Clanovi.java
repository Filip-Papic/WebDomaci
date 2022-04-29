package rs.raf.demo;

import java.io.Serializable;

public class Clanovi implements Serializable {

    private String memberName;
    private String memberLastname;
    private String memberEmail;
    private String memberRole;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberLastname() {
        return memberLastname;
    }

    public void setMemberLastname(String memberLastname) {
        this.memberLastname = memberLastname;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberRole() {
        return memberRole;
    }

    public void setMemberRole(String memberRole) {
        this.memberRole = memberRole;
    }
}
