-- Create table
create table TCO_USER_TOKEN
(
  USER_ID VARCHAR2(255) not null,
  TOKEN   VARCHAR2(500)
)
tablespace USERS
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64
    next 1
    minextents 1
    maxextents unlimited
  );
-- Add comments to the table 
comment on table TCO_USER_TOKEN
  is 'APP用户token表';
-- Add comments to the columns 
comment on column TCO_USER_TOKEN.USER_ID
  is '用户ID';
comment on column TCO_USER_TOKEN.TOKEN
  is '用户当前登录token';
-- Create/Recreate indexes 
create index I_TCO_USER_TOKEN on TCO_USER_TOKEN (USER_ID)
  tablespace USERS
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
