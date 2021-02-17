--
-- PostgreSQL database dump
--

-- Dumped from database version 9.4.1
-- Dumped by pg_dump version 11.5

-- Started on 2020-02-23 19:37:43 -03

SET statement_timeout = 0;
SET lock_timeout = 0;
--SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
--SET row_security = off;

--
-- TOC entry 6 (class 2615 OID 2200)
-- Name: public; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA public;


ALTER SCHEMA public OWNER TO postgres;

--
-- TOC entry 2313 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: COMMENT; Schema: -; Owner: postgres
--

COMMENT ON SCHEMA public IS 'standard public schema';


--
-- TOC entry 8 (class 2615 OID 457452)
-- Name: vendas; Type: SCHEMA; Schema: -; Owner: postgres
--

CREATE SCHEMA vendas;


ALTER SCHEMA vendas OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 174 (class 1259 OID 457453)
-- Name: clientes; Type: TABLE; Schema: vendas; Owner: postgres
--

CREATE TABLE vendas.clientes (
    id integer NOT NULL,
    nome character varying,
    telefone1 integer,
    telefone2 integer,
    usuario integer,
    data_nascimento date,
    cpf character varying(11),
    rg character varying,
    cep character varying(8),
    estado character varying(2),
    cidade character varying,
    bairro character varying,
    logradouro character varying,
    numero integer,
    cod_ibge integer
);


ALTER TABLE vendas.clientes OWNER TO postgres;

--
-- TOC entry 181 (class 1259 OID 465235)
-- Name: pagamentos; Type: TABLE; Schema: vendas; Owner: postgres
--

CREATE TABLE vendas.pagamentos (
    id integer NOT NULL,
    id_venda integer,
    valor_pago double precision,
    data_pagamento date,
    usuario integer,
    cancelada boolean,
    data_hora_cancelamento timestamp without time zone
);


ALTER TABLE vendas.pagamentos OWNER TO postgres;

--
-- TOC entry 180 (class 1259 OID 465233)
-- Name: pagamentos_id_seq; Type: SEQUENCE; Schema: vendas; Owner: postgres
--

CREATE SEQUENCE vendas.pagamentos_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vendas.pagamentos_id_seq OWNER TO postgres;

--
-- TOC entry 2317 (class 0 OID 0)
-- Dependencies: 180
-- Name: pagamentos_id_seq; Type: SEQUENCE OWNED BY; Schema: vendas; Owner: postgres
--

ALTER SEQUENCE vendas.pagamentos_id_seq OWNED BY vendas.pagamentos.id;


--
-- TOC entry 175 (class 1259 OID 457459)
-- Name: planta_id_seq; Type: SEQUENCE; Schema: vendas; Owner: postgres
--

CREATE SEQUENCE vendas.planta_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vendas.planta_id_seq OWNER TO postgres;

--
-- TOC entry 2318 (class 0 OID 0)
-- Dependencies: 175
-- Name: planta_id_seq; Type: SEQUENCE OWNED BY; Schema: vendas; Owner: postgres
--

ALTER SEQUENCE vendas.planta_id_seq OWNED BY vendas.clientes.id;


--
-- TOC entry 176 (class 1259 OID 457461)
-- Name: usuario; Type: TABLE; Schema: vendas; Owner: postgres
--

CREATE TABLE vendas.usuario (
    id integer NOT NULL,
    nome character varying,
    login character varying,
    senha character varying,
    ativo boolean DEFAULT true NOT NULL
);


ALTER TABLE vendas.usuario OWNER TO postgres;

--
-- TOC entry 177 (class 1259 OID 457468)
-- Name: usuario_id_seq; Type: SEQUENCE; Schema: vendas; Owner: postgres
--

CREATE SEQUENCE vendas.usuario_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vendas.usuario_id_seq OWNER TO postgres;

--
-- TOC entry 2320 (class 0 OID 0)
-- Dependencies: 177
-- Name: usuario_id_seq; Type: SEQUENCE OWNED BY; Schema: vendas; Owner: postgres
--

ALTER SEQUENCE vendas.usuario_id_seq OWNED BY vendas.usuario.id;


--
-- TOC entry 179 (class 1259 OID 465227)
-- Name: venda; Type: TABLE; Schema: vendas; Owner: postgres
--

CREATE TABLE vendas.venda (
    id integer NOT NULL,
    id_cliente integer,
    valor double precision,
    qtd integer,
    data date,
    usuario integer,
    cancelada boolean,
    data_hora_cancelamento timestamp without time zone
);


ALTER TABLE vendas.venda OWNER TO postgres;

--
-- TOC entry 178 (class 1259 OID 465225)
-- Name: venda_id_seq; Type: SEQUENCE; Schema: vendas; Owner: postgres
--

CREATE SEQUENCE vendas.venda_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE vendas.venda_id_seq OWNER TO postgres;

--
-- TOC entry 2321 (class 0 OID 0)
-- Dependencies: 178
-- Name: venda_id_seq; Type: SEQUENCE OWNED BY; Schema: vendas; Owner: postgres
--

ALTER SEQUENCE vendas.venda_id_seq OWNED BY vendas.venda.id;


--
-- TOC entry 2168 (class 2604 OID 457470)
-- Name: clientes id; Type: DEFAULT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.clientes ALTER COLUMN id SET DEFAULT nextval('vendas.planta_id_seq'::regclass);


--
-- TOC entry 2172 (class 2604 OID 465238)
-- Name: pagamentos id; Type: DEFAULT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.pagamentos ALTER COLUMN id SET DEFAULT nextval('vendas.pagamentos_id_seq'::regclass);


--
-- TOC entry 2170 (class 2604 OID 457471)
-- Name: usuario id; Type: DEFAULT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.usuario ALTER COLUMN id SET DEFAULT nextval('vendas.usuario_id_seq'::regclass);


--
-- TOC entry 2171 (class 2604 OID 465230)
-- Name: venda id; Type: DEFAULT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.venda ALTER COLUMN id SET DEFAULT nextval('vendas.venda_id_seq'::regclass);

--
-- TOC entry 2322 (class 0 OID 0)
-- Dependencies: 180
-- Name: pagamentos_id_seq; Type: SEQUENCE SET; Schema: vendas; Owner: postgres
--

SELECT pg_catalog.setval('vendas.pagamentos_id_seq', 762, true);


--
-- TOC entry 2323 (class 0 OID 0)
-- Dependencies: 175
-- Name: planta_id_seq; Type: SEQUENCE SET; Schema: vendas; Owner: postgres
--

SELECT pg_catalog.setval('vendas.planta_id_seq', 284, true);


--
-- TOC entry 2324 (class 0 OID 0)
-- Dependencies: 177
-- Name: usuario_id_seq; Type: SEQUENCE SET; Schema: vendas; Owner: postgres
--

SELECT pg_catalog.setval('vendas.usuario_id_seq', 179, true);


--
-- TOC entry 2325 (class 0 OID 0)
-- Dependencies: 178
-- Name: venda_id_seq; Type: SEQUENCE SET; Schema: vendas; Owner: postgres
--

SELECT pg_catalog.setval('vendas.venda_id_seq', 379, true);


--
-- TOC entry 2185 (class 2606 OID 465240)
-- Name: pagamentos pagamentos_pkey; Type: CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.pagamentos
    ADD CONSTRAINT pagamentos_pkey PRIMARY KEY (id);


--
-- TOC entry 2174 (class 2606 OID 457473)
-- Name: clientes pk_planta_id; Type: CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.clientes
    ADD CONSTRAINT pk_planta_id PRIMARY KEY (id);


--
-- TOC entry 2176 (class 2606 OID 457475)
-- Name: usuario pk_usuario_id; Type: CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.usuario
    ADD CONSTRAINT pk_usuario_id PRIMARY KEY (id);


--
-- TOC entry 2178 (class 2606 OID 700198)
-- Name: usuario unique_login; Type: CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.usuario
    ADD CONSTRAINT unique_login UNIQUE (login);


--
-- TOC entry 2181 (class 2606 OID 465232)
-- Name: venda venda_pkey; Type: CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.venda
    ADD CONSTRAINT venda_pkey PRIMARY KEY (id);


--
-- TOC entry 2182 (class 1259 OID 533491)
-- Name: a; Type: INDEX; Schema: vendas; Owner: postgres
--

CREATE INDEX a ON vendas.pagamentos USING btree (id_venda);


--
-- TOC entry 2183 (class 1259 OID 571097)
-- Name: fk_usuario; Type: INDEX; Schema: vendas; Owner: postgres
--

CREATE INDEX fk_usuario ON vendas.pagamentos USING btree (usuario);


--
-- TOC entry 2179 (class 1259 OID 533497)
-- Name: venda_cliente; Type: INDEX; Schema: vendas; Owner: postgres
--

CREATE INDEX venda_cliente ON vendas.venda USING btree (id_cliente);


--
-- TOC entry 2186 (class 2606 OID 571098)
-- Name: clientes clientes_usuario_fkey; Type: FK CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.clientes
    ADD CONSTRAINT clientes_usuario_fkey FOREIGN KEY (usuario) REFERENCES vendas.usuario(id);


--
-- TOC entry 2189 (class 2606 OID 533498)
-- Name: pagamentos pagamentos_id_venda_fkey; Type: FK CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.pagamentos
    ADD CONSTRAINT pagamentos_id_venda_fkey FOREIGN KEY (id_venda) REFERENCES vendas.venda(id);


--
-- TOC entry 2190 (class 2606 OID 571092)
-- Name: pagamentos pagamentos_usuario_fkey; Type: FK CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.pagamentos
    ADD CONSTRAINT pagamentos_usuario_fkey FOREIGN KEY (usuario) REFERENCES vendas.usuario(id);


--
-- TOC entry 2187 (class 2606 OID 533492)
-- Name: venda venda_id_cliente_fkey; Type: FK CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.venda
    ADD CONSTRAINT venda_id_cliente_fkey FOREIGN KEY (id_cliente) REFERENCES vendas.clientes(id);


--
-- TOC entry 2188 (class 2606 OID 571103)
-- Name: venda venda_usuario_fkey; Type: FK CONSTRAINT; Schema: vendas; Owner: postgres
--

ALTER TABLE ONLY vendas.venda
    ADD CONSTRAINT venda_usuario_fkey FOREIGN KEY (usuario) REFERENCES vendas.usuario(id);


--
-- TOC entry 2314 (class 0 OID 0)
-- Dependencies: 6
-- Name: SCHEMA public; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA public FROM PUBLIC;
REVOKE ALL ON SCHEMA public FROM postgres;
GRANT ALL ON SCHEMA public TO postgres;
GRANT ALL ON SCHEMA public TO PUBLIC;


--
-- TOC entry 2315 (class 0 OID 0)
-- Dependencies: 8
-- Name: SCHEMA vendas; Type: ACL; Schema: -; Owner: postgres
--

REVOKE ALL ON SCHEMA vendas FROM PUBLIC;
REVOKE ALL ON SCHEMA vendas FROM postgres;
GRANT ALL ON SCHEMA vendas TO postgres;
GRANT ALL ON SCHEMA vendas TO PUBLIC;


--
-- TOC entry 2316 (class 0 OID 0)
-- Dependencies: 174
-- Name: TABLE clientes; Type: ACL; Schema: vendas; Owner: postgres
--

REVOKE ALL ON TABLE vendas.clientes FROM PUBLIC;
REVOKE ALL ON TABLE vendas.clientes FROM postgres;
GRANT ALL ON TABLE vendas.clientes TO postgres;
GRANT ALL ON TABLE vendas.clientes TO PUBLIC;


--
-- TOC entry 2319 (class 0 OID 0)
-- Dependencies: 176
-- Name: TABLE usuario; Type: ACL; Schema: vendas; Owner: postgres
--

REVOKE ALL ON TABLE vendas.usuario FROM PUBLIC;
REVOKE ALL ON TABLE vendas.usuario FROM postgres;
GRANT ALL ON TABLE vendas.usuario TO postgres;
GRANT ALL ON TABLE vendas.usuario TO PUBLIC;


-- Completed on 2020-02-23 19:37:43 -03

--
-- PostgreSQL database dump complete
--

