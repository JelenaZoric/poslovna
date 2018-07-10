insert into klijent (id_klijenta, naziv_klijenta, mesto, aktivan) values (2, 'Tea', 'Ruma', true)

insert into racuni_pravnih_lica (id_racuna, broj_racuna, datum_otvaranja, vazeci, klijent_id) values (1, '333', '2018-10-24', true, 1)

insert into dnevno_stanje_racuna(broj_izvoda, datum_prometa, prethodno_stanje, prometukorist, promet_na_teret, novo_stanje, racuni_pravnih_lica_id) values (1, '2019-04-23', 0, 1000, 0, 1000, 1)

insert into analitika_izvoda(datum_prijema, datum_valute, duznik_nalogodavac, iznos, hitno, poverilac_primalac, status, tip_greske, dnevno_stanje_racuna_id, svrha_placanja) values ('2018-11-09', '2018-10-09', 'Tea', 1000, false, 'Viki', 'c', 1, 1, 'uplata')

insert into drzava(id, Sifra, Naziv) values(2, 12, 'francuska')
insert into valute(sifra, naziv, domicilna, drzava_id) values ('123', 'naziv valute', true, 2)