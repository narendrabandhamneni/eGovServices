
CREATE TABLE egpt_property (
    id integer NOT NULL,
    tenantid character varying NOT NULL,
    upicnumber character varying NOT NULL,
    oldUpicNumber character varying,
    vltUpicNumber character varying,
    creationreason character varying NOT NULL,
    assessmentdate character varying,
    occupancydate character varying NOT NULL,
    gisrefno character varying,
    isauthorised boolean,
    isunderworkflow boolean,
    active boolean default true,
    channel character varying NOT NULL,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime integer,
    lastmodifiedtime integer
);



CREATE SEQUENCE seq_egpt_property
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_property OWNED BY egpt_property.id;



ALTER TABLE ONLY egpt_property ALTER COLUMN id SET DEFAULT nextval('seq_egpt_property'::regclass);



ALTER TABLE ONLY egpt_property
    ADD CONSTRAINT egpt_property_pk PRIMARY KEY (id);



CREATE TABLE egpt_address (
    id integer NOT NULL,
    tenantid character varying,
    latitude integer,
    longitude integer,
    addressId character varying,
    addressNumber character varying,
    addressLine1 character varying,
    addressLine2 character varying,
    landmark character varying,
    city character varying,
    pincode character varying,
    detail character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime integer,
    lastmodifiedtime integer,
    property_id integer
);



CREATE SEQUENCE seq_egpt_address
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;



ALTER SEQUENCE seq_egpt_address OWNED BY egpt_address.id;

ALTER TABLE ONLY egpt_address ALTER COLUMN id SET DEFAULT nextval('seq_egpt_address'::regclass);


ALTER TABLE ONLY egpt_address
    ADD CONSTRAINT egpt_address_pk PRIMARY KEY (id);


ALTER TABLE ONLY egpt_address
    ADD CONSTRAINT egpt_address_property_id_fkey FOREIGN KEY (property_id) REFERENCES egpt_property(id) DEFERRABLE INITIALLY DEFERRED;



CREATE TABLE egpt_propertydetails (
    id integer NOT NULL,
    source character varying,
    regddocno character varying,
    regddocdate character varying,
    reason character varying,
    status character varying,
    isverified boolean,
    verificationdate character varying,
    isexempted boolean,
    exemptionreason character varying,
    propertytype character varying NOT NULL,
    category character varying,
    usage character varying,
    department character varying,
    apartment character varying,
    sitelength integer,
    sitebreadth integer,
    sitalarea integer NOT NULL,
    totalbuiltuparea integer,
    undividedshare integer,
    nooffloors integer,
    issuperstructure boolean,
    landowner character varying,
    floortype character varying,
    woodtype character varying,
    rooftype character varying,
    walltype character varying,
    stateid character varying,
    applicationno character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime integer,
    lastmodifiedtime integer,
    property_id integer
);



CREATE SEQUENCE seq_egpt_propertydetails
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_propertydetails OWNED BY egpt_propertydetails.id;


ALTER TABLE ONLY egpt_propertydetails ALTER COLUMN id SET DEFAULT nextval('seq_egpt_propertydetails'::regclass);


ALTER TABLE ONLY egpt_propertydetails
    ADD CONSTRAINT egpt_propertydetail_pk PRIMARY KEY (id);


ALTER TABLE ONLY egpt_propertydetails
    ADD CONSTRAINT egpt_propertydetail_property_id_fkey FOREIGN KEY (property_id) REFERENCES egpt_property(id) DEFERRABLE INITIALLY DEFERRED;


CREATE TABLE egpt_floors (
    id integer NOT NULL,
    floorno character varying NOT NULL,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime integer,
    lastmodifiedtime integer,
    property_details_id integer
);



CREATE SEQUENCE seq_egpt_floors
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_floors OWNED BY egpt_floors.id;


ALTER TABLE ONLY egpt_floors ALTER COLUMN id SET DEFAULT nextval('seq_egpt_floors'::regclass);


ALTER TABLE ONLY egpt_floors
    ADD CONSTRAINT egpt_floors_pk PRIMARY KEY (id);

ALTER TABLE ONLY egpt_floors
    ADD CONSTRAINT egpt_floors_property_details_id_fkey FOREIGN KEY (property_details_id) REFERENCES egpt_propertydetails(id) DEFERRABLE INITIALLY DEFERRED;

 
 CREATE TABLE egpt_unit (
    id integer NOT NULL,
    unitno integer NOT NULL,
    unittype character varying,
    length integer,
    width integer,
    builtuparea integer NOT NULL,
    assessablearea integer,
    bpabuiltuparea integer,
    bpano character varying,
    bpadate character varying,
    usage character varying NOT NULL,
    occupancy character varying NOT NULL,
    occupiername character varying,
    firmname character varying,
    rentcollected integer,
    structure character varying NOT NULL,
    age character varying,
    exemptionreason character varying,
    isstructured boolean,
    occupancydate character varying,
    constcompletiondate character varying,
    manualarv integer,
    arv integer,
    electricmeterno character varying,
    watermeterno character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime integer,
    lastmodifiedtime integer,
    floor_id integer
);



CREATE SEQUENCE seq_egpt_unit
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_unit OWNED BY egpt_unit.id;



ALTER TABLE ONLY egpt_unit ALTER COLUMN id SET DEFAULT nextval('seq_egpt_unit'::regclass);



ALTER TABLE ONLY egpt_unit
    ADD CONSTRAINT egpt_unit_pk PRIMARY KEY (id);


ALTER TABLE ONLY egpt_unit
    ADD CONSTRAINT egpt_unit_fk FOREIGN KEY (floor_id) REFERENCES egpt_floors(id) DEFERRABLE INITIALLY DEFERRED;

CREATE TABLE egpt_documenttype (
    id integer NOT NULL,
    name character varying,
    application character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime character varying,
    lastmodifiedtime character varying
);


CREATE SEQUENCE seq_egpt_documenttype
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_documenttype OWNED BY egpt_documenttype.id;


ALTER TABLE ONLY egpt_documenttype ALTER COLUMN id SET DEFAULT nextval('seq_egpt_documenttype'::regclass);


ALTER TABLE ONLY egpt_documenttype
    ADD CONSTRAINT egpt_documenttype_pk PRIMARY KEY (id);


CREATE TABLE egpt_document (
    id integer NOT NULL,
    documenttype integer NOT NULL,
    filestore character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime character varying,
    lastmodifiedtime character varying,
    property_details_id integer
);



CREATE SEQUENCE seq_egpt_document
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_document OWNED BY egpt_document.id;


ALTER TABLE ONLY egpt_document ALTER COLUMN id SET DEFAULT nextval('seq_egpt_document'::regclass);

ALTER TABLE ONLY egpt_document
    ADD CONSTRAINT egpt_document_pk PRIMARY KEY (id);

ALTER TABLE ONLY egpt_document
    ADD CONSTRAINT egpt_document_property_details_id_fkey FOREIGN KEY (property_details_id) REFERENCES egpt_propertydetails(id) DEFERRABLE INITIALLY DEFERRED;


ALTER TABLE ONLY egpt_document
    ADD CONSTRAINT egpt_documenttype_fk FOREIGN KEY (documenttype) REFERENCES egpt_documenttype(id) DEFERRABLE INITIALLY DEFERRED;


CREATE TABLE egpt_vacantland (
    id integer NOT NULL,
    surveynumber character varying,
    pattanumber character varying,
    marketvalue integer,
    capitalvalue integer,
    layoutapprovedauth character varying,
    layoutpermissionno character varying,
    layoutpermissiondate character varying,
    resdplotarea integer,
    nonresdplotarea integer,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime character varying,
    lastmodifiedtime character varying,
    property_id integer
);



CREATE SEQUENCE seq_egpt_vacantland
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_vacantland OWNED BY egpt_vacantland.id;


ALTER TABLE ONLY egpt_vacantland ALTER COLUMN id SET DEFAULT nextval('seq_egpt_vacantland'::regclass);

ALTER TABLE ONLY egpt_vacantland
    ADD CONSTRAINT egpt_vacantland_pk PRIMARY KEY (id);

ALTER TABLE ONLY egpt_vacantland
    ADD CONSTRAINT egpt_vacantland_property_id_fkey FOREIGN KEY (property_id) REFERENCES egpt_property(id) DEFERRABLE INITIALLY DEFERRED;


CREATE TABLE egpt_property_user (
    id integer NOT NULL,
    property_id integer NOT NULL,
    user_id character varying,
    isPrimaryOwner boolean,
    isSecondaryOwner boolean,
    ownerShipPercentage integer,
    ownerType character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime character varying,
    lastmodifiedtime character varying
);


CREATE SEQUENCE seq_egpt_property_user
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_property_user OWNED BY egpt_property_user.id;


ALTER TABLE ONLY egpt_property_user ALTER COLUMN id SET DEFAULT nextval('seq_egpt_property_user'::regclass);


ALTER TABLE ONLY egpt_property_user
    ADD CONSTRAINT egpt_property_user_pk PRIMARY KEY (id);


ALTER TABLE ONLY egpt_property_user
    ADD CONSTRAINT egpt_property_fk FOREIGN KEY (property_id) REFERENCES egpt_property(id) DEFERRABLE INITIALLY DEFERRED;



CREATE TABLE egpt_propertylocation (
    id integer NOT NULL,
    revenueboundary integer,
    locationboundary integer,
    adminboundary integer,
    northboundedby character varying,
    eastboundedby character varying,
    westboundedby character varying,
    southboundedby character varying,
    createdby character varying,
    lastmodifiedby character varying,
    createdtime integer,
    lastmodifiedtime integer,
    property_id integer
);


CREATE SEQUENCE seq_egpt_propertylocation
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER SEQUENCE seq_egpt_propertylocation OWNED BY egpt_propertylocation.id;


ALTER TABLE ONLY egpt_propertylocation ALTER COLUMN id SET DEFAULT nextval('seq_egpt_propertylocation'::regclass);


ALTER TABLE ONLY egpt_propertylocation
    ADD CONSTRAINT egpt_propertylocation_pk PRIMARY KEY (id);


ALTER TABLE ONLY egpt_propertylocation
    ADD CONSTRAINT egpt_propertylocation_fk FOREIGN KEY (property_id) REFERENCES egpt_property(id) DEFERRABLE INITIALLY DEFERRED;


