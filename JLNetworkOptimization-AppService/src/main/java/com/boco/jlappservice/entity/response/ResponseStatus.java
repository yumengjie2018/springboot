package com.boco.jlappservice.entity.response;

public enum ResponseStatus
{
    Ok("ok", 0),

    Fail("fail", -1),

    ParamInvalid("params invalid", -2),

    ForbiddenAccess("unauthorized access", -11),

    AuthorizedFail("authorized fail", -12),

    PasswordExpired("password expired", -13),

    DatabaseException("database exception", -21),

    HAVE_LOGIN("have login",111),

    NULL_TOKEN("null token",112),

    NULL_USER_OR_TOKEN("null user or token",113),

    FACE_RECOGNITION_PICTURE("face recognition picture",114),

    FACE_RECOGNIZE("face recognize",115),

    ACCOUNT_LOCKED("account locked",116),

    ILLEGAL_USER("illegal user",120);

    private int index;
    private String name;

    private ResponseStatus(String name, int index)
    {
        this.name = name;
        this.index = index;
    }

    public static String getName(int index)
    {
        for (ResponseStatus status : values()) {
            if (status.getIndex() == index) {
                return status.name;
            }
        }

        return null;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getIndex()
    {
        return this.index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }
}
