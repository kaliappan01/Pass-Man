package domain;

import java.util.List;

public class PassWall {
    private String key;
    private String masterPass;
    private List<PassBrick> passBrickList;

    public List<PassBrick> getPassBrickList() {
        return passBrickList;
    }

    public void setPassBrickList(List<PassBrick> passBrickList) {
        this.passBrickList = passBrickList;
    }
}
