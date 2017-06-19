CREATE TABLE egpt_mstr_factor
(
    id bigserial NOT NULL,
    tenantid character varying NOT NULL,
    fromdate timestamp with time zone NOT NULL,
    todate timestamp with time zone NOT NULL,
    data jsonb NOT NULL,
   CONSTRAINT egpt_mstr_factor_pkey PRIMARY KEY(id)
);

CREATE SEQUENCE seq_egpt_mstr_factor;


CREATE TABLE egpt_mstr_guidancevalue
(
    id bigserial NOT NULL,
    tenantid  character varying NOT NULL,
    fromdate timestamp with time zone NOT NULL,
    todate timestamp with time zone NOT NULL,
    data jsonb NOT NULL,
   CONSTRAINT egpt_mstr_guidancevalue_pkey PRIMARY KEY(id)
);

CREATE SEQUENCE egpt_mstr_guidancevalue;


CREATE TABLE egpt_mstr_taxrates
(
    id bigserial NOT NULL,
    tenantid  character varying NOT NULL,
    fromdate timestamp with time zone NOT NULL,
    todate timestamp with time zone NOT NULL,
    data jsonb NOT NULL,
   CONSTRAINT egpt_mstr_taxrates_pkey PRIMARY KEY(id)
);

CREATE SEQUENCE egpt_mstr_taxrates;

CREATE TABLE egpt_mstr_taxperiods
(
    id bigserial NOT NULL,
    tenantid  character varying NOT NULL,
    fromdate timestamp with time zone NOT NULL,
    todate timestamp with time zone NOT NULL,
    data jsonb NOT NULL,
   CONSTRAINT egpt_mstr_taxperiods_pkey PRIMARY KEY(id)
);

CREATE SEQUENCE egpt_mstr_taxperiods;
