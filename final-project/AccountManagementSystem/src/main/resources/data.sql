/* user_login_details */
insert into user_login_details (user_id, password) values ('10001', 'hello');
insert into user_login_details (user_id, password) values ('10002', 'hello');
insert into user_login_details (user_id, password) values ('10003', 'hello');

/* user_profile_details */
insert into user_profile_details (user_id, first_name, last_name, dob, gender, city, phone_number, email_id)
values ('10001', 'Srikanth', 'Naidu', '15-06-1989', 'Male', 'Bangalore', '9959656462', 'sr20000959@gmail.com');
insert into user_profile_details (user_id, first_name, last_name, dob, gender, city, phone_number, email_id)
values ('10002', 'Kiran', 'Chowdary', '1-10-1993', 'Male', 'Chittoor', '9456783656', 'kr645646@gmail.com');
insert into user_profile_details (user_id, first_name, last_name, dob, gender, city, phone_number, email_id)
values ('10003', 'Yamini', 'Chowdary', '4-12-1995', 'Female', 'Hyderabad', '9566566786', 'yc94489@gmail.com');

/* user_account_details */
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('5914509740', 54500, '2018-06-29 10:15:40');
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('8400980084', 118000, '2018-06-29 10:15:40');
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('0543289780', 5400, '2018-06-29 10:15:40');

insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('5733298746', 80555.27, '2018-06-29 10:15:40');
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('8995644897', 27000, '2018-06-29 10:15:40');
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('0954889005', 94435, '2018-06-29 10:15:40');

insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('5904589800', 9500.56, '2018-06-29 10:15:40');
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('8544754446', 694040, '2018-06-29 10:15:40');
insert into user_account_details (account_number, account_balance, updated_date_time) 
values ('0545357778', 38800, '2018-06-29 10:15:40');

/* user_bank_details */
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50001', '10001', '5914509740', 'SBI', 'Savings Bank Account');
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50002', '10001', '8400980084', 'HDFC', 'Savings Bank Account');
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50003', '10001', '0954889005', 'ICICI', 'Savings Bank Account');

insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50004', '10002', '5733298746', 'SBI', 'Savings Bank Account');
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50005', '10002', '8995644897', 'HDFC', 'Savings Bank Account');
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50006', '10002', '0543289780', 'ICICI', 'Savings Bank Account');

insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50007', '10003', '5904589800', 'SBI', 'Savings Bank Account');
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50008', '10003', '8544754446', 'HDFC', 'Savings Bank Account');
insert into user_bank_details (bank_id, user_id, account_number, bank_name, account_type) 
values ('50009', '10003', '0545357778', 'ICICI', 'Savings Bank Account');

/* account_transaction_details */
insert into account_transaction_details (transaction_id, account_number, amount, closing_balance, debit_credit_ind, transaction_description, updated_date_time) 
values (90001, '5914509740', 1000, 1500, 'Debit', 'June Expenses', '2018-06-25 12:04:09');
insert into account_transaction_details (transaction_id, account_number, amount, closing_balance, debit_credit_ind, transaction_description, updated_date_time) 
values (90002, '8400980084', 1000, 171000, 'Credit', 'June Expenses', '2018-06-25 12:04:09');

insert into account_transaction_details (transaction_id, account_number, amount, closing_balance, debit_credit_ind, transaction_description, updated_date_time) 
values (90003, '5914509740', 50000, 51500, 'Credit', 'To Parents Expenses', '2018-06-26 10:17:16');
insert into account_transaction_details (transaction_id, account_number, amount, closing_balance, debit_credit_ind, transaction_description, updated_date_time) 
values (90004, '8400980084', 50000, 121000, 'Debit', 'To Parents Expenses', '2018-06-26 10:17:16');

insert into account_transaction_details (transaction_id, account_number, amount, closing_balance, debit_credit_ind, transaction_description, updated_date_time) 
values (90005, '5914509740', 3000, 54500, 'Credit', 'To Exam Fees', '2018-06-28 06:20:16');
insert into account_transaction_details (transaction_id, account_number, amount, closing_balance, debit_credit_ind, transaction_description, updated_date_time) 
values (90006, '8400980084', 3000, 118000, 'Debit', 'To Exam Fees', '2018-06-28 06:20:16');
