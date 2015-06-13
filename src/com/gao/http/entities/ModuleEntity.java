package com.gao.http.entities;


public class ModuleEntity {
    /*"groupId": "105",
    "moduleName": "萝莉",
    "iconUrl": "http://bcs.duapp.com/jsontest/project/luoli.jpg",
    "point": "0",
    "description": "萝莉妹纸要推倒"*/
    private int groupId;
    private String moduleName;
    private String iconUrl;
    private int point;
    private String description;
    public int getGroupId() {
        return groupId;
    }
    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }
    public String getModuleName() {
        return moduleName;
    }
    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
    public String getIconUrl() {
        return iconUrl;
    }
    public void setIconUrl(String iconUrl) {
        this.iconUrl = iconUrl;
    }
    public int getPoint() {
        return point;
    }
    public void setPoint(int point) {
        this.point = point;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
