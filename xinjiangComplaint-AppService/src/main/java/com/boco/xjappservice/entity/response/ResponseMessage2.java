package com.boco.xjappservice.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description="通信应答对象（泛型）")
    public class ResponseMessage2<T>
            implements Serializable
    {
        private static final long serialVersionUID = 3808233533283493241L;

        @ApiModelProperty("执行状态 0为成功")
        private int status = ResponseStatus.Ok
                .getIndex();

        @ApiModelProperty("提示信息")
        private String message;

        @ApiModelProperty("业务数据")
        private T data;

        public ResponseMessage2()
        {
            this.status = ResponseStatus.Ok.getIndex();
        }

        public ResponseMessage2(int status, String message, T data)
        {
            this.status = status;
            this.message = message;
            this.data = data;
        }

        public int getStatus()
        {
            return this.status;
        }

        public void setStatus(int status)
        {
            this.status = status;
        }

        public String getMessage()
        {
            return this.message;
        }

        public void setMessage(String message)
        {
            this.message = message;
        }

        public T getData()
        {
            return this.data;
        }

        public void setData(T data)
        {
            this.data = data;
        }

        public static <TInput> ResponseMessage2<TInput> Success()
        {
            return new ResponseMessage2(0, "ok", null);
        }

        public static <TInput> ResponseMessage2<TInput> Success2(TInput data)
        {
            return new ResponseMessage2(ResponseStatus.Ok.getIndex(), "ok", data);
        }

        public static <TInput> ResponseMessage2<TInput> Success(String message)
        {
            return new ResponseMessage2(ResponseStatus.Ok.getIndex(), message, null);
        }

        public static <TInput> ResponseMessage2<TInput> Success(String message, TInput data)
        {
            return new ResponseMessage2(ResponseStatus.Ok.getIndex(), message, data);
        }

        public static <TInput> ResponseMessage2<TInput> Failed(String message)
        {
            return new ResponseMessage2(ResponseStatus.Fail.getIndex(), message, null);
        }

        public static <TInput> ResponseMessage2<TInput> Failed(int status, String message)
        {
            return new ResponseMessage2(status, message, null);
        }
        public static <TInput> ResponseMessage2<TInput> Failed(int status, String message,TInput data)
        {
            return new ResponseMessage2(status, message, data);
        }

        public static <TInput> ResponseMessage2<TInput> Create(int status, String message, TInput data)
        {
            return new ResponseMessage2(status, message, data);
        }

}
