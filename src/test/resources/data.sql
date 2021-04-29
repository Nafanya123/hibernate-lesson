-- TRUNCATE TABLE university CASCADE;

INSERT INTO university (name,id) VALUES
	 ('History University',1);

INSERT INTO public."group" (name,id_university,id) VALUES
	 ('History Group',1,1);

INSERT INTO public.student (name,age,id,id_group) VALUES
	 ('Vasy',22,0,1);


