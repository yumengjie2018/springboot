package com.example.service.entity.response;

public enum ResponseStatus
{
    Ok("ok", 0),

    Fail("fail", -1),

    ParamInvalid("params invalid", -2),

    ForbiddenAccess("unauthorized access", -11),

    AuthorizedFail("authorized fail", -12),

    PasswordExpired("password expired", -13),

    DatabaseException("database exception", -21);

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
