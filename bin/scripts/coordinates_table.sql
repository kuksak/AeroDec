CREATE table "COORDINATES" (
    "ID"          NUMBER NOT NULL,
    "NACA_ID"     NUMBER NOT NULL,
    "XCOORDINATE" FLOAT(8) NOT NULL,
    "YCOORDINATE" FLOAT(8) NOT NULL,
    constraint  "COORDINATES_PK" primary key ("ID")
)
/

CREATE sequence "COORDINATES_SEQ"
/

CREATE trigger "BI_COORDINATES"
  before insert on "COORDINATES"
  for each row
begin
  if :NEW."ID" is null then
    select "COORDINATES_SEQ".nextval into :NEW."ID" from dual;
  end if;
end;
/

ALTER TABLE "COORDINATES" ADD CONSTRAINT "COORDINATES_FK"
FOREIGN KEY ("NACA_ID")
REFERENCES "AEROFOILS" ("ID")
ON DELETE CASCADE

/
