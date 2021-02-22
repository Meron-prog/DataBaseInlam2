create or replace view Visa_medelBetyget as
select produkt.ID, märke.namn, produkt.storlek, produkt.farg,  
case when avg(betygvärde.siffervärde) >=4.5 then 'mycketnojd'
         when avg(betygvärde.siffervärde) >=3.5 then 'Ganskanojd'
          when avg(betygvärde.siffervärde) >=2.5 then 'Nojd'
          when avg(betygvärde.siffervärde) >=1.5 then 'Missnojd'
         else 'null'
         end as 'Betyg komment'
, avg(betygvärde.siffervärde) as 'medelbetyg'
from produkt
inner join märke on produkt.märkeid = märke.ID
left join betyg on produkt.ID = betyg.produktid
left join betygvärde on betyg.BetygvärdeID = betygvärde.ID
group by produkt.ID;

select*from Visa_medelBetyget;