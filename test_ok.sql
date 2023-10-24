-- CREATE EXTENSION postgres_fdw

CREATE SERVER postgres-jdbc_srv
	FOREIGN DATA WRAPPER postgres_fdw
	OPTIONS(host 'localhost', dbname 'postgres', port '5432');
CREATE USER MAPPING FOR CURRENT_USER SERVER postgres-jdbc_srv;
CREATE FOREIGN TABLE public.answers (
	tableoid oid NULL,
	cmax cid NULL,
	xmax xid NULL,
	cmin cid NULL,
	xmin xid NULL,
	ctid tid NULL,
	id_answer serial4 NULL,
	answer varchar NULL,
	correct_answer int4 NULL
)
SERVER postgres-jdbc_srv;
CREATE FOREIGN TABLE public.questions (
	tableoid oid NULL,
	cmax cid NULL,
	xmax xid NULL,
	cmin cid NULL,
	xmin xid NULL,
	ctid tid NULL,
	id_question serial4 NULL,
	question varchar NULL
)
SERVER postgres-jdbc_srv;
CREATE FOREIGN TABLE public.tests (
	tableoid oid NULL,
	cmax cid NULL,
	xmax xid NULL,
	cmin cid NULL,
	xmin xid NULL,
	ctid tid NULL,
	id_test int4 NULL,
	test_name varchar NULL
)
SERVER postgres-jdbc_srv;
