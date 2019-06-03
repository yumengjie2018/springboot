package com.example.service.entity.response.xuxuelii;

import java.io.Serializable;

/**
 * title：Result
 * description:
 *
 * @author yumengjie
 * @date 2019/4/19 13:53
 */

public class Result<T> implements Serializable {
    public static final long serialVersionUID = 42L;
    public static final int SUCCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final Result<String> OK = new Result((Object)null);
    public static final Result<String> FAILE = new Result(500, (String)null);
    private int code;
    private String msg;
    private T content;

    public Result() {
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(T content) {
        this.code = 200;
        this.content = content;
    }

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getContent() {
        return this.content;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof Result)) {
            return false;
        } else {
            Result<?> other = (Result)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$msg = this.getMsg();
                Object other$msg = other.getMsg();
                if (this$msg == null) {
                    if (other$msg != null) {
                        return false;
                    }
                } else if (!this$msg.equals(other$msg)) {
                    return false;
                }

                Object this$content = this.getContent();
                Object other$content = other.getContent();
                if (this$content == null) {
                    if (other$content != null) {
                        return false;
                    }
                } else if (!this$content.equals(other$content)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(Object other) {
        return other instanceof Result;
    }

//    public int hashCode() {
//        int PRIME = true;
//        int result = 1;
//        int result = result * 59 + this.getCode();
//        Object $msg = this.getMsg();
//        result = result * 59 + ($msg == null ? 43 : $msg.hashCode());
//        Object $content = this.getContent();
//        result = result * 59 + ($content == null ? 43 : $content.hashCode());
//        return result;
//    }

    public String toString() {
        return "Result(code=" + this.getCode() + ", msg=" + this.getMsg() + ", content=" + this.getContent() + ")";
    }
}
