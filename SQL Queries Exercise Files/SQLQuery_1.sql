SELECT WorkOrderID, ScrappedQty, StartDate, EndDate
from Production.WorkOrder
Where  OrderQty >0 AND  StartDate >= '2013-12-01' AND  EndDate <='2013-12-31'
order by ScrappedQty Desc;