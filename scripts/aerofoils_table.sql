CREATE table "AEROFOILS" (
    "ID"            NUMBER NOT NULL,
    "AEROFOIL_NAME" VARCHAR2(256) NOT NULL,
    constraint  "AEROFOILS_PK" primary key ("ID")
)
/

CREATE sequence "AEROFOILS_SEQ"
/

CREATE trigger "BI_AEROFOILS"
  before insert on "AEROFOILS"
  for each row
begin
  if :NEW."ID" is null then
    select "AEROFOILS_SEQ".nextval into :NEW."ID" from dual;
  end if;
end;
/

alter table "AEROFOILS" add
constraint "AEROFOILS_UK1"
unique ("AEROFOIL_NAME")
/

