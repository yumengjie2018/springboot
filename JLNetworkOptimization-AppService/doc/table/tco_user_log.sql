-- Create table
create table TCO_USER_LOG
(
  USER_ID     VARCHAR2(50) not null,
  FILE_PATH   VARCHAR2(500),
  INSERT_TIME DATE,
  FILE_NAME   VARCHAR2(255),
  REMARK      VARCHAR2(255)
)
tablespace NIOSDBS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 16
    next 8
    minextents 1
    maxextents unlimited
  );
-- Add comments to the columns 
comment on column TCO_USER_LOG.USER_ID
  is '�û�ID';
comment on column TCO_USER_LOG.FILE_PATH
  is '�ļ����ӵ�ַ';
comment on column TCO_USER_LOG.INSERT_TIME
  is '����ʱ��';
comment on column TCO_USER_LOG.FILE_NAME
  is '�ļ�����';
comment on column TCO_USER_LOG.REMARK
  is '��ע';
