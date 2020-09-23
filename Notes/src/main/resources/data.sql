insert into user (id, name, username, password) values(101, 'Marko Jovanovski', 'marko', 'marko');
insert into user (id, name, username, password) values(102, 'Jovica Stojicik', 'jovica', 'jovica');

insert into tag (id, name, user_id) values (101, 'SpringTag',102);
insert into tag (id, name, user_id) values (102, 'JpaTag',101);

insert into note (id, content, title, user_id) values (101, 'my first note', 'note 1',  101);
insert into note (id, content, title, user_id) values (102, 'my second note', 'note 2', 102);

insert into note_tags(notes_id,tags_id) values(101,101);
insert into note_tags(notes_id,tags_id) values(102,102);

