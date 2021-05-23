-- This file preloads bloodtypes if they are not already in the database.

INSERT INTO public.bloodtypes (bloodtype) VALUES('A POS') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('A NEG') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('B POS') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('B NEG') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('O POS') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('O NEG') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('AB POS') ON CONFLICT DO NOTHING;
INSERT INTO public.bloodtypes (bloodtype) VALUES('AB NEG') ON CONFLICT DO NOTHING;