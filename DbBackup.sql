toc.dat                                                                                             0000600 0004000 0002000 00000005474 15036222401 0014444 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        PGDMP   5                    }            StudentWellness    17.5    17.5 
    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                           false         �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                           false         �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                           false         �           1262    16393    StudentWellness    DATABASE     �   CREATE DATABASE "StudentWellness" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_South Africa.1252';
 !   DROP DATABASE "StudentWellness";
                     admin4    false         �           0    0    DATABASE "StudentWellness"    ACL     {   REVOKE ALL ON DATABASE "StudentWellness" FROM admin4;
GRANT ALL ON DATABASE "StudentWellness" TO admin4 WITH GRANT OPTION;
                        admin4    false    4850                     2615    16412    login    SCHEMA        CREATE SCHEMA login;
    DROP SCHEMA login;
                     admin4    false         �            1259    16413    login_credentials    TABLE     X  CREATE TABLE login.login_credentials (
    studentnumber character varying(20) NOT NULL,
    studentname character varying(100) NOT NULL,
    studentsurname character varying(100) NOT NULL,
    studentemail character varying(150) NOT NULL,
    studentphone character varying(20) NOT NULL,
    studentpassword character varying(255) NOT NULL
);
 $   DROP TABLE login.login_credentials;
       login         heap r       postgres    false    6         �          0    16413    login_credentials 
   TABLE DATA           �   COPY login.login_credentials (studentnumber, studentname, studentsurname, studentemail, studentphone, studentpassword) FROM stdin;
    login               postgres    false    218       4844.dat X           2606    16419 (   login_credentials login_credentials_pkey 
   CONSTRAINT     p   ALTER TABLE ONLY login.login_credentials
    ADD CONSTRAINT login_credentials_pkey PRIMARY KEY (studentnumber);
 Q   ALTER TABLE ONLY login.login_credentials DROP CONSTRAINT login_credentials_pkey;
       login                 postgres    false    218         Z           2606    16421 4   login_credentials login_credentials_studentemail_key 
   CONSTRAINT     v   ALTER TABLE ONLY login.login_credentials
    ADD CONSTRAINT login_credentials_studentemail_key UNIQUE (studentemail);
 ]   ALTER TABLE ONLY login.login_credentials DROP CONSTRAINT login_credentials_studentemail_key;
       login                 postgres    false    218                                                                                                                                                                                                            4844.dat                                                                                            0000600 0004000 0002000 00000000156 15036222401 0014252 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        123	dgg	jhgjgj	temp@gmaiol.com	+27812471255	$2a$10$t3IwlYrJoLDDde.kCatDc.Ila6Dz8D5BucJ2j3u0PZx1PojvkTrAe
\.


                                                                                                                                                                                                                                                                                                                                                                                                                  restore.sql                                                                                         0000600 0004000 0002000 00000006014 15036222401 0015360 0                                                                                                    ustar 00postgres                        postgres                        0000000 0000000                                                                                                                                                                        --
-- NOTE:
--
-- File paths need to be edited. Search for $$PATH$$ and
-- replace it with the path to the directory containing
-- the extracted data files.
--
--
-- PostgreSQL database dump
--

-- Dumped from database version 17.5
-- Dumped by pg_dump version 17.5

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

DROP DATABASE "StudentWellness";
--
-- Name: StudentWellness; Type: DATABASE; Schema: -; Owner: admin4
--

CREATE DATABASE "StudentWellness" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE_PROVIDER = libc LOCALE = 'English_South Africa.1252';


ALTER DATABASE "StudentWellness" OWNER TO admin4;

\connect "StudentWellness"

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET transaction_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: login; Type: SCHEMA; Schema: -; Owner: admin4
--

CREATE SCHEMA login;


ALTER SCHEMA login OWNER TO admin4;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: login_credentials; Type: TABLE; Schema: login; Owner: postgres
--

CREATE TABLE login.login_credentials (
    studentnumber character varying(20) NOT NULL,
    studentname character varying(100) NOT NULL,
    studentsurname character varying(100) NOT NULL,
    studentemail character varying(150) NOT NULL,
    studentphone character varying(20) NOT NULL,
    studentpassword character varying(255) NOT NULL
);


ALTER TABLE login.login_credentials OWNER TO postgres;

--
-- Data for Name: login_credentials; Type: TABLE DATA; Schema: login; Owner: postgres
--

COPY login.login_credentials (studentnumber, studentname, studentsurname, studentemail, studentphone, studentpassword) FROM stdin;
\.
COPY login.login_credentials (studentnumber, studentname, studentsurname, studentemail, studentphone, studentpassword) FROM '$$PATH$$/4844.dat';

--
-- Name: login_credentials login_credentials_pkey; Type: CONSTRAINT; Schema: login; Owner: postgres
--

ALTER TABLE ONLY login.login_credentials
    ADD CONSTRAINT login_credentials_pkey PRIMARY KEY (studentnumber);


--
-- Name: login_credentials login_credentials_studentemail_key; Type: CONSTRAINT; Schema: login; Owner: postgres
--

ALTER TABLE ONLY login.login_credentials
    ADD CONSTRAINT login_credentials_studentemail_key UNIQUE (studentemail);


--
-- Name: DATABASE "StudentWellness"; Type: ACL; Schema: -; Owner: admin4
--

REVOKE ALL ON DATABASE "StudentWellness" FROM admin4;
GRANT ALL ON DATABASE "StudentWellness" TO admin4 WITH GRANT OPTION;


--
-- PostgreSQL database dump complete
--

                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    