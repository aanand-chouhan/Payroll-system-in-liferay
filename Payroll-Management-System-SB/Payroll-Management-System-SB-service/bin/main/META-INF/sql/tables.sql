create table admin_details (
	admin_id INTEGER not null primary key,
	userName VARCHAR(75) null,
	password_ VARCHAR(75) null
);

create table advance_salary_records (
	request_id INTEGER not null primary key,
	eid VARCHAR(75) null,
	reason VARCHAR(75) null,
	is_checked VARCHAR(75) null,
	date_ DATE null
);

create table ctc_details (
	ctc INTEGER not null primary key,
	hra INTEGER,
	ma INTEGER,
	ca INTEGER,
	ta INTEGER,
	pf INTEGER,
	sa INTEGER,
	incomeTax INTEGER,
	proffesionalTax INTEGER,
	basicSalary INTEGER,
	contributionAmt INTEGER,
	gratuity INTEGER
);

create table department (
	dno INTEGER not null primary key,
	dName VARCHAR(75) null,
	eid VARCHAR(75) null
);

create table emp_details (
	eno LONG not null primary key,
	eid VARCHAR(75) null,
	eName VARCHAR(75) null,
	email VARCHAR(75) null,
	password_ VARCHAR(75) null,
	gender VARCHAR(75) null,
	mobileNo INTEGER,
	panCardNo VARCHAR(75) null,
	adharCardNo LONG,
	uanNo LONG,
	dob DATE null,
	doj DATE null,
	designation VARCHAR(75) null,
	role VARCHAR(75) null,
	address VARCHAR(75) null,
	qualificationS VARCHAR(75) null,
	image BLOB
);

create table emp_documents (
	docId LONG not null primary key,
	name VARCHAR(75) null,
	mimeType VARCHAR(75) null,
	document BLOB,
	eno LONG,
	is_uploaded INTEGER
);

create table leaverequest (
	request_id INTEGER not null primary key,
	eid VARCHAR(75) null,
	reason VARCHAR(75) null,
	is_checked VARCHAR(75) null,
	date_ DATE null
);

create table payslip_details (
	ctcId LONG not null primary key,
	ctc INTEGER,
	hra INTEGER,
	ma INTEGER,
	ca INTEGER,
	ta INTEGER,
	pf INTEGER,
	sa INTEGER,
	incomeTax INTEGER,
	netSalary INTEGER,
	month INTEGER,
	eid VARCHAR(75) null,
	basicSalary INTEGER,
	proffesionalTax INTEGER,
	TaxablAmt INTEGER,
	gratuity INTEGER,
	grossSalary INTEGER
);