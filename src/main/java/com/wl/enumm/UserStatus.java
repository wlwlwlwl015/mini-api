package com.wl.enumm;

/**
 * Created by wangliang on 2018/4/27.
 */
public enum UserStatus {

    ENABLE(0, "enable", "启用"),
    DISABLE(1, "disable", "停用");

    private Integer index;
    private String name_en;
    private String name_ch;

    private UserStatus(Integer index, String name_en, String name_ch) {
        this.index = index;
        this.name_en = name_en;
        this.name_ch = name_ch;
    }

    public Integer getIndex() {
        return index;
    }

    public String getName_en() {
        return name_en;
    }

    public String getName_ch() {
        return name_ch;
    }

    public static UserStatus getByIndex(Integer index) {
        UserStatus[] array = UserStatus.values();
        for (UserStatus item : array) {
            if (item.getIndex().equals(index)) {
                return item;
            }
        }
        return null;
    }
}
