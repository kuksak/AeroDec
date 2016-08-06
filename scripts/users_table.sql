CREATE table "USERS" (
    "ID"         NUMBER NOT NULL,
    "USERNAME"   VARCHAR2(256) NOT NULL,
    "PASSWORD"   VARCHAR2(256) NOT NULL,
    constraint  "USERS_PK" primary key ("ID")
)
/

CREATE sequence "USERS_SEQ"
/

CREATE trigger "BI_USERS"
  before insert on "USERS"
  for each row
begin
  if :NEW."ID" is null then
    select "USERS_SEQ".nextval into :NEW."ID" from dual;
  end if;
end;
/

alter table "USERS" add
constraint "USERS_UK1"
unique ("USERNAME")
/
