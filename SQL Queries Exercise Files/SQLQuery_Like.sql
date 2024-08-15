SELECT name
from Purchasing.Vendor 
where (name like 'C%') AND ((name like '%BIKE%') OR (name like  '%BICYCLE%'))