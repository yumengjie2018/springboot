-- Create table
create table TAP_APP_FTP
(
  USER_ID             VARCHAR2(128),
  SCAN_START_TIME     DATE,
  DOWNLOAD_SPEED_PEAK FLOAT,
  DOWNLOAD_SPEED_MEAN FLOAT,
  UPLOAD_SPEED_PEAK   FLOAT,
  UPLOAD_SPEED_MEAN   FLOAT
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column TAP_APP_FTP.USER_ID
  is '用户id';
comment on column TAP_APP_FTP.SCAN_START_TIME
  is '日期';
comment on column TAP_APP_FTP.DOWNLOAD_SPEED_PEAK
  is '下载速度峰值';
comment on column TAP_APP_FTP.DOWNLOAD_SPEED_MEAN
  is '下载速度均值';
comment on column TAP_APP_FTP.UPLOAD_SPEED_PEAK
  is '上传速度峰值';
comment on column TAP_APP_FTP.UPLOAD_SPEED_MEAN
  is '上传速度均值';
