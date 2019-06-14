CREATE TABLE public.user_roles
(
  id bigserial NOT NULL,
  name CHARACTER VARYING NOT NULL,
  description CHARACTER VARYING (1024),
  CONSTRAINT user_roles_pkey PRIMARY KEY (id)
);


CREATE TABLE public.users
(
  id bigserial NOT NULL,
  name CHARACTER VARYING,
  login CHARACTER VARYING NOT NULL,
  password CHARACTER VARYING NOT NULL,
  description CHARACTER VARYING (1024),
  phone_number CHARACTER VARYING NOT NULL,
  bot_channel_id CHARACTER VARYING,
  user_role_id BIGINT NOT NULL,
  CONSTRAINT user_pkey PRIMARY KEY (id),
  CONSTRAINT fk_user_to_user_roles FOREIGN KEY (user_role_id) REFERENCES public.user_roles (id)
);

CREATE TABLE public.room_status
(
  id bigserial NOT NULL,
  name CHARACTER VARYING NOT NULL,
  description CHARACTER VARYING (1024),
  CONSTRAINT room_status_pkey PRIMARY KEY (id)
);

CREATE TABLE public.offices
(
  id bigserial NOT NULL,
  name CHARACTER VARYING NOT NULL,
  CONSTRAINT office_pkey PRIMARY KEY (id)
);

CREATE TABLE public.meet_room
(
  id bigserial NOT NULL,
  name CHARACTER VARYING NOT NULL,
  office_id BIGINT,
  CONSTRAINT meet_room_pkey PRIMARY KEY (id),
  CONSTRAINT fk_meet_room_to_offices FOREIGN KEY (office_id) REFERENCES public.offices (id)
);

