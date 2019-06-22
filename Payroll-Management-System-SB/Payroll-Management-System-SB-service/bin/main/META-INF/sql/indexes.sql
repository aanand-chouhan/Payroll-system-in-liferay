create index IX_C0998992 on admin_details (userName[$COLUMN_LENGTH:75$], password_[$COLUMN_LENGTH:75$]);

create index IX_B4075EF6 on advance_salary_records (is_checked[$COLUMN_LENGTH:75$]);

create index IX_34333999 on emp_details (email[$COLUMN_LENGTH:75$], password_[$COLUMN_LENGTH:75$]);

create index IX_D685E6F on emp_documents (eno);

create index IX_5C4345B1 on payslip_details (month, eid[$COLUMN_LENGTH:75$]);