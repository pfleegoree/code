SELECT A.AddressLine1 as 'Address',
  A.city as 'City',
    State.name AS 'State',
    R.Name AS 'Country'
     
FROM  [Person].[Address] AS A join [Person].[StateProvince] AS State
ON 
A.StateProvinceID = State.StateProvinceID
JOIN [Person].[CountryRegion] AS R
ON
state.CountryRegionCode = R.CountryRegionCode

