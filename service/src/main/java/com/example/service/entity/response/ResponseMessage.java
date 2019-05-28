package com.example.service.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(description="通信应答对象（泛型）")
    public class ResponseMessage<T>
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

        public ResponseMessage()
        {
            this.status = ResponseStatus.Ok.getIndex();
        }

        public ResponseMessage(int status, String message, T data)
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

        public static <TInput> ResponseMessage<TInput> Success()
        {
            return new ResponseMessage(0, "ok", null);
        }

        public static <TInput> ResponseMessage<TInput> Success2(TInput data)
        {
            return new ResponseMessage(ResponseStatus.Ok.getIndex(), "ok", data);
        }

        public static <TInput> ResponseMessage<TInput> Success(String message)
        {
            return new ResponseMessage(ResponseStatus.Ok.getIndex(), message, null);
        }

        public static <TInput> ResponseMessage<TInput> Success(String message, TInput data)
        {
            return new ResponseMessage(ResponseStatus.Ok.getIndex(), message, data);
        }

        public static <TInput> ResponseMessage<TInput> Failed(String message)
        {
            return new ResponseMessage(ResponseStatus.Fail.getIndex(), message, null);
        }

        public static <TInput> ResponseMessage<TInput> Failed(int status, String message)
        {
            return new ResponseMessage(status, message, null);
        }

        public static <TInput> ResponseMessage<TInput> Create(int status, String message, TInput data)
        {
            return new ResponseMessage(status, message, data);
        }

}
